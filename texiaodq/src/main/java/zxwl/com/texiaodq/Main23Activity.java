package zxwl.com.texiaodq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lusfold.spinnerloading.SpinnerLoading;

public class Main23Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);

        SpinnerLoading view = (SpinnerLoading) findViewById(R.id.spinner_loading);
        view.setPaintMode(1);
        view.setCircleRadius(60);
        view.setItemCount(6);
    }
}
