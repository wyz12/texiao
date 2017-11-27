package zxwl.com.texiao2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.zys.brokenview.BrokenCallback;
import com.zys.brokenview.BrokenTouchListener;
import com.zys.brokenview.BrokenView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView ls = (ListView) findViewById(R.id.ls);
        img = (ImageView) findViewById(R.id.img);

        BrokenView brokenView = BrokenView.add2Window(this);

        BrokenTouchListener listener = new BrokenTouchListener.Builder(brokenView).build();

        img.setOnTouchListener(listener);


        new BrokenTouchListener.Builder(brokenView).
                setComplexity(12).          // 设置破裂的复杂度，默认值12
        setBreakDuration(700).       // 设置视图破裂持续的时间，默认值700ms
        setFallDuration(2000).        // 设置视图坠落持续的时间，默认值2000ms
    // 设置以触摸点为中心的圆形裂痕半径，默认值是66dp
            // 设置可以使指定子视图产生破裂效果
               // 设置子视图可以产生破裂效果的区域，保证子视图没有设置触摸事件监听
               // 设置裂痕的画笔
        build();

        brokenView.setCallback(new BrokenCallback() {
            //开始破裂
            @Override
            public void onStart(View v) {
                super.onStart(v);
            }
            //取消结束破裂
            @Override
            public void onCancelEnd(View v) {
                super.onCancelEnd(v);
            }
            //坠落结束
            @Override
            public void onFallingEnd(View v) {
                super.onFallingEnd(v);
            }
            //坠落中
            @Override
            public void onFalling(View v) {
                super.onFalling(v);
            }
            //重新开始破裂
            @Override
            public void onRestart(View v) {
                super.onRestart(v);
            }
            //取消破裂
            @Override
            public void onCancel(View v) {
                super.onCancel(v);
            }
        });




        List<String> sss = new ArrayList<>();
        sss.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2515962000,2788814938&fm=27&gp=0.jpg");
        sss.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3400723282,3860568563&fm=27&gp=0.jpg");
        sss.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1512059719,4097177193&fm=27&gp=0.jpg");
        adapter adapter = new adapter(sss, this);
        ls.setAdapter(adapter);






    }
}
