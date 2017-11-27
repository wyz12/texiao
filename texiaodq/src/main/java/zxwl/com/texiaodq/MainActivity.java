package zxwl.com.texiaodq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import zxwl.com.texiaodq.view.Main6Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bse = (Button) findViewById(R.id.bse);
        Button caid = (Button) findViewById(R.id.caid);
        Button dw = (Button) findViewById(R.id.dw);
        Button jc = (Button) findViewById(R.id.jc);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);






        bse.setOnClickListener(this);
        caid.setOnClickListener(this);
        dw.setOnClickListener(this);
        jc.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bse:
                startActivity(new Intent(MainActivity.this,Mybes.class));
                break;
            case R.id.caid:
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                break;
            case R.id.dw:
                startActivity(new Intent(MainActivity.this,Main3Activity.class));
                break;
            case R.id.jc:
                startActivity(new Intent(MainActivity.this,Main22Activity.class));
                break;
            case R.id.one:
                startActivity(new Intent(MainActivity.this,Main4Activity.class));
                break;
            case R.id.two:
                startActivity(new Intent(MainActivity.this,Main5Activity.class));
                break;
            case R.id.three:
                startActivity(new Intent(MainActivity.this,Main23Activity.class));
                break;
            case R.id.four:
                startActivity(new Intent(MainActivity.this,Main6Activity.class));
                break;
            case R.id.five:
                startActivity(new Intent(MainActivity.this,Main25Activity.class));
                break;
            case R.id.six:
                startActivity(new Intent(MainActivity.this,Main26Activity.class));
                break;
        }

    }
}
