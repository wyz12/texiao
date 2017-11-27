package zxwl.com.texiaodq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private String[] mItemTexts = new String[] { "一点 ", "二点", "仨点",
            "四点", "五点", "六点" };
    private int[] mItemImgs = new int[] { R.drawable.zzsz1,
            R.drawable.zzsz2, R.drawable.zzsz3,
            R.drawable.zzsz4, R.drawable.zzsz5,
            R.drawable.zzsz6 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        CircleMenuLayout mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);

        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener(){

            @Override
            public void itemClick(View view, int pos)
            {
                Toast.makeText(Main2Activity.this, mItemTexts[pos],
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void itemCenterClick(View view)
            {
                Toast.makeText(Main2Activity.this,
                        "you can do something just like ccb  ",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}
