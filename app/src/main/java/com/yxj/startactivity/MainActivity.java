package com.yxj.startactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.yxj.startactivity2.ResultEntity;
import com.yxj.startactivity2.RxCallback;
import com.yxj.startactivity2.RxResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RxResult(MainActivity.this)
                        .startActivity(SecondActivity.class, new RxCallback() {
                            @Override
                            public void onActivityResult(ResultEntity result) {
                                if(result!=null){
                                    Log.e("yxj",result.toString());
                                    Toast.makeText(MainActivity.this,result.intent.getStringExtra("name"),Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
    }
}
