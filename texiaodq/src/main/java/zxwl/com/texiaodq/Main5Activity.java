package zxwl.com.texiaodq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.skyfishjy.library.RippleBackground;

public class Main5Activity extends AppCompatActivity {
    private boolean x=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        ImageView imageView=(ImageView)findViewById(R.id.centerImage);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(x){
                    rippleBackground.startRippleAnimation();
                    x=false;
                }else{
                    rippleBackground.stopRippleAnimation();
                    x=true;
                }



            }
        });
    }
}
