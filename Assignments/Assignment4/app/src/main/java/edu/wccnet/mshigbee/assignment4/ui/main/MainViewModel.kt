package edu.wccnet.mshigbee.assignment4.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
        companion object {
            fun newInstance() = MainViewModel().apply{} }

        private var names: MutableLiveData<String> = MutableLiveData("No names to display")

        private var name: MutableLiveData<String> = MutableLiveData("")

        fun getNames(): MutableLiveData<String> {
            return names
        }

        fun getName(): MutableLiveData<String>{
            return name
        }

        fun addName() {
            if (names.value.toString().equals("No names to display")) {
                    names.setValue(name.value + "\n")
                }
                else {names.setValue(names.value + name.value + "\n")}
            }

}