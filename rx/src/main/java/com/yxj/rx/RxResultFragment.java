package com.yxj.rx;


import android.app.Fragment;
import android.content.Intent;

import io.reactivex.Observable;
import io.reactivex.Observer;


/**
 * Author:  Yxj
 * Time:    2018/7/18 下午2:19
 * -----------------------------------------
 * Description:
 */
public class RxResultFragment extends Fragment {

    Observer<ResultEntity> observer;

    void startForResult(Intent intent, Observer<ResultEntity> observer){
        this.observer = observer;
        startActivityForResult(intent,observer.hashCode());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == observer.hashCode()){
            observer.onNext(new ResultEntity(resultCode,data));
        }
        observer.onComplete();
    }



}
