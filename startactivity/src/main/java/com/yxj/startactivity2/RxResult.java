package com.yxj.startactivity2;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;

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

    public void startActivity(Intent intent,RxCallback callback){
        rxRequestFragment.startForResult(intent,callback);
    }

    public void startActivity(Class<? extends Activity> clazz,RxCallback callback){
        Intent intent = new Intent(rxRequestFragment.getActivity(),clazz);
        rxRequestFragment.startForResult(intent,callback);
    }

}
