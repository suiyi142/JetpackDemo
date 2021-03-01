package com.example.myapplication;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @CreateDate: 2021-3-1 19:21
 * @UpdateDate: 2021-3-1 19:21
 * @Description:
 * @Author: uidq2189
 * @UpdateRemark:
 * @Version: 1.0
 */
public class MyLifecycle implements LifecycleObserver {
    private static final String TAG = "MyLifecycle";
    private Lifecycle lifecycle;

    public MyLifecycle(Lifecycle lifecycle){
        this.lifecycle = lifecycle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void create(){
        Log.d(TAG, "create: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void start(){
        Log.d(TAG, "start: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resume(){
        Log.d(TAG, "resume: ");
    }
    
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pause(){
        Log.d(TAG, "pause: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void stop(){
        Log.d(TAG, "stop: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void destroy(){
        Log.d(TAG, "destroy: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    private void anyState(){
        Log.d(TAG, "anyState: "+lifecycle.getCurrentState());
    }
}
