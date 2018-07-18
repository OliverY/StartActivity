package com.yxj.rx;

import android.content.Intent;

/**
 * Author:  Yxj
 * Time:    2018/7/18 上午10:53
 * -----------------------------------------
 * Description:
 */
public class ResultEntity {

    public int resultCode;
    public Intent intent;

    public ResultEntity(int resultCode, Intent intent) {
        this.resultCode = resultCode;
        this.intent = intent;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "resultCode=" + resultCode +
                ", intent=" + intent +
                '}';
    }
}
