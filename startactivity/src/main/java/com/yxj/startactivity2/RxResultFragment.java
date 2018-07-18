package com.yxj.startactivity2;


import android.app.Fragment;
import android.content.Intent;

/**
 * Author:  Yxj
 * Time:    2018/7/18 下午2:19
 * -----------------------------------------
 * Description:
 */
public class RxResultFragment extends Fragment {

    RxCallback callback;

    void startForResult(Intent intent,RxCallback callback){
        this.callback = callback;
        startActivityForResult(intent,callback.hashCode());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == callback.hashCode()){
            callback.onActivityResult(new ResultEntity(resultCode,data));
        }
    }

}
