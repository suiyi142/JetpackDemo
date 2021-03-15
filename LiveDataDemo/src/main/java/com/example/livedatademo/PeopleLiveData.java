package com.example.livedatademo;

import android.util.Log;

import androidx.lifecycle.LiveData;

/**
 * @CreateDate: 2021-3-10 8:50
 * @UpdateDate: 2021-3-10 8:50
 * @Description: activity在前台时2s人的age+1，在后台时停止长大
 * @Author: uidq2189
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PeopleLiveData extends LiveData<PeopleBean> {
    private static final String TAG = "PeopleLiveData";
    private final PeopleBean peopleBean;
    private boolean isRun = false;

    public PeopleLiveData(PeopleBean peopleBean) {
        this.peopleBean = peopleBean;
    }

    @Override
    protected void onActive() {
        Log.d(TAG, "onActive() called");
        super.onActive();
        isRun = true;
        new Thread(runnable).start();
    }

    @Override
    protected void onInactive() {
        Log.d(TAG, "onInactive() called");
        super.onInactive();
        isRun = false;
    }

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (isRun) {
                peopleBean.setAge(peopleBean.getAge() + 1);
                postValue(peopleBean);
//                setValue(peopleBean);//主线程才能用
                Log.d(TAG, "run() called peopleBean.getAge() = " + peopleBean.getAge());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

}
