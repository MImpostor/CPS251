package edu.wccnet.mshigbee.assignment5

import android.util.Log
import androidx.lifecycle.*
import edu.wccnet.mshigbee.assignment5.ui.main.MainViewModel
import java.sql.Timestamp

class DemoObserver: LifecycleObserver  {


    var observerViewModel: MainViewModel = MainViewModel.newInstance()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i("TAG", "Resumed")
    observerViewModel.addName("onResume was fired on " + Timestamp(System.currentTimeMillis()).toString() + "\n**********\n")
        Log.i("TAG", observerViewModel.getName().value.toString())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i("TAG", "Paused")
        observerViewModel.addName("onPause was fired on " + Timestamp(System.currentTimeMillis()).toString() + "\n**********\n")
        Log.i("TAG", observerViewModel.getName().value.toString())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i("TAG", "Created")
        observerViewModel.addName("onCreate was fired on " + Timestamp(System.currentTimeMillis()).toString() + "\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i("TAG", "Started")
        observerViewModel.addName("onStart was fired on " + Timestamp(System.currentTimeMillis()).toString() + "\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i("TAG", "Stopped")
        observerViewModel.addName("onStop was fired on " + Timestamp(System.currentTimeMillis()).toString() + "\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i("TAG", "Destroyed")
        observerViewModel.addName("onDestroy was fired on " + Timestamp(System.currentTimeMillis()).toString() + "\n**********\n")
        Log.i("TAG", observerViewModel.getName().value.toString())
    }

}