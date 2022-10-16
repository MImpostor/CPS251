package edu.wccnet.mshigbee.assignment3.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    companion object {
        fun newInstance() = MainViewModel().apply{} }

    private var names: String = ""

    fun getNames(): String {
        if (names=="") {
            Log.i("test", "no names given")
            return "No names to display"
        }
        Log.i("Test", "Called names")
        return names
    }

    fun addName(name: String) {
        if (name != "") {
        names += name + "\n"}
    }
}