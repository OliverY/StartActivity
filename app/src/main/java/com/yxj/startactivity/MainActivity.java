package com.yxj.startactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.yxj.rx.ResultEntity;
import com.yxj.rx.RxResult;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new RxResult(MainActivity.this)
//                        .startActivity(SecondActivity.class, new RxCallback() {
//                            @Override
//                            public void onActivityResult(ResultEntity result) {
//                                if(result!=null){
//                                    Log.e("yxj",result.toString());
//                                    Toast.makeText(MainActivity.this,result.intent.getStringExtra("name"),Toast.LENGTH_SHORT).show();
//
//                                }
//                            }
//                        });
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RxResult(MainActivity.this)
                        .startActivity(new Intent(MainActivity.this,SecondActivity.class))
                        .subscribe(new Observer<ResultEntity>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ResultEntity result) {
                                Toast.makeText(MainActivity.this,result.intent.getStringExtra("name"),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                Toast.makeText(MainActivity.this,"complete",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
