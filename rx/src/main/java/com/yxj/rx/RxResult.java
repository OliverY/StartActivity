package com.yxj.rx;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Author:  Yxj
 * Time:    2018/7/18 下午2:18
 * -----------------------------------------
 * Description:
 */
public class RxResult {

    public static final String TAG = "request";

    RxResultFragment rxRequestFragment;

    public RxResult(Activity activity) {
        rxRequestFragment = getFragmentFromActivity(activity);
    }

    private RxResultFragment getFragmentFromActivity(Activity activity) {
        RxResultFragment rxPermissionsFragment = findRxRequestFragment(activity);
        boolean isNewInstance = rxPermissionsFragment == null;
        if (isNewInstance) {
            rxPermissionsFragment = new RxResultFragment();
            FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(rxPermissionsFragment, TAG)
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return rxPermissionsFragment;
    }

    private RxResultFragment findRxRequestFragment(Activity activity) {
        return (RxResultFragment) activity.getFragmentManager().findFragmentByTag(TAG);
    }

    public Observable<ResultEntity> startActivity(Intent intent){
        PublishSubject<ResultEntity> subject = PublishSubject.create();
        rxRequestFragment.startForResult(intent,subject);
        return subject;
    }

}
