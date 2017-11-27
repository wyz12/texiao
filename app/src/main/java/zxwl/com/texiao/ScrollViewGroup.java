package zxwl.com.texiao;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/11/16.
 */

public class ScrollViewGroup  extends View {
    private int width;
    private int height;
    private Paint mPaintLine;
    private Paint mPaintCircle;
    private Paint mPaintSec;
    private Paint mPaintText,mPaintText2;
    private int dw;//当前档位
    public static final int NEED_INVALIDATE = 0X23;
    private double cx,cy;//手势坐标
    private double yxx,yxy;//圆心
    private String name;
    private double jd;//滑动的角度

    //每隔一秒，在handler中调用一次重新绘制方法
    private Handler handler = new Handler(){

        public void handleMessage(Message msg) {

            switch (msg.what){
                case NEED_INVALIDATE:
                    invalidate();//告诉UI主线程重新绘制
                    handler.sendEmptyMessageDelayed(NEED_INVALIDATE,1000);
                    break;
                default:
                    break;
            }
        }
    };

    public ScrollViewGroup(Context context) {
        super(context);
    }

    public ScrollViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);

        /*
        * 定义多个画不同东西的画笔
        * */
        mPaintLine = new Paint();
        mPaintLine.setColor(Color.WHITE);
        mPaintLine.setStrokeWidth(6);

        mPaintCircle = new Paint();
        mPaintCircle.setColor(context.getResources().getColor(R.color.red));//设置颜色
        mPaintCircle.setStrokeWidth(10);//设置线宽
        mPaintCircle.setAntiAlias(true);//设置是否抗锯齿
        mPaintCircle.setStyle(Paint.Style.STROKE);//设置绘制风格


        mPaintText = new Paint();
        mPaintText.setColor(Color.WHITE);
        mPaintText.setStrokeWidth(10);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setTextSize(40);

        mPaintText2 = new Paint();
        mPaintText2.setColor(Color.WHITE);
        mPaintText2.setStrokeWidth(10);
        mPaintText2.setTextAlign(Paint.Align.CENTER);
        mPaintText2.setTextSize(60);

        //滑针
        mPaintSec = new Paint();
        mPaintSec.setStrokeWidth(10);
        mPaintSec.setColor(Color.YELLOW);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        yxx = width/2;
        yxy = height/2;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int circleRadius = 200;//大圆半径
        //画出大圆
        canvas.drawCircle(width / 2, height / 2, circleRadius, mPaintCircle);

        //依次旋转画布，画出每个刻度和对应数字
        if(dw==0){
            mPaintText2.setColor(Color.RED);
            canvas.drawText("关",width/2,height/2+60,mPaintText2);
        }else{
            mPaintText2.setColor(Color.WHITE);
            canvas.drawText(dw+"档",width/2,height/2+60,mPaintText2);
        }

        mPaintText2.setColor(Color.YELLOW);
        mPaintText2.setTextSize(40);


        for (int i = 0; i <= 71; i++) {//一共有72个（刻度+档位文字）
            canvas.save();//保存当前画布
            canvas.rotate(360 / 72 * i, width / 2, height / 2);
            // canvas.rotate((float)jd, width / 2, height / 2);
            if(i%8!=0) {
                if(i<dw*8||i<jd/5.0f){/*如果使用的档位调节，则该档位内的都有黄色；
                                         如果滑动的，一个刻度是5°,s所以个当前度数除以5*/
                    mPaintLine.setColor(Color.YELLOW);
                }else{
                    mPaintLine.setColor(Color.WHITE);
                }
                canvas.drawLine(width / 2, height / 2 - circleRadius-10, width / 2, height / 2 - circleRadius - 30, mPaintLine);
            }else {
                //左起：文本内容，起始位置x坐标，起始位置y坐标，画笔
                if(i/8<=dw){
                    mPaintText.setColor(Color.YELLOW);
                }else{
                    mPaintText.setColor(Color.WHITE);
                }
                canvas.drawText("" + i / 8, width / 2, height / 2 - circleRadius - 20, mPaintText);
            }
            canvas.restore();
        }

        float secDegree = (float) jd;//dw/9f*360;//得到指针旋转的角度
        canvas.save();
        canvas.rotate(secDegree, width / 2, height / 2);
        canvas.drawLine(width / 2, height / 2 - circleRadius, width / 2, height / 2 - circleRadius - 30, mPaintSec);

        canvas.restore();

    }

    public void setDw(int dw){
        this.dw = dw;
        //handler.sendEmptyMessage(NEED_INVALIDATE);//向handler发送一个消息，让它开启重绘
        this.jd = dw*40;
        invalidate();
    }
    public int getDw(){
        return dw;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        cx=event.getX();
        cy=event.getY();

        jd = getJD(cx,cy);
        if(cx<=yxx) {
            jd=180+(180-jd);
        }
        dw = (int) (jd/40);
        invalidate();
        return true;
    }

    /*
    * type 1表示得到距离，2表示得到的距离的平方
    * */
    private double getJL(double ax,double ay,double bx,double by,int type){
        if(type==1){
            return Math.sqrt(((ax-bx)*(ax-bx)+(ay-by)*(ay-by)));
        }else{
            return (((ax-bx)*(ax-bx)+(ay-by)*(ay-by)));
        }
    }
    //计算角度
    private double getJD(double ax,double ay){
        return (Math.acos(((getJL(ax,ay,yxx,yxy,2)+200*200-getJL(ax,ay,yxx,(yxy-200),2))/(2*200*getJL(ax,ay,yxx,yxy,1))))*180/Math.PI);
    }

}
