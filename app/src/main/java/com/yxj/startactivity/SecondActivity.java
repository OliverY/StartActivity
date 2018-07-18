package com.yxj.startactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("name","this is value");
        setResult(RESULT_OK,data);
        super.finish();
    }
}
