package edu.wccnet.mshigbee.assignment5.ui.main


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    companion object {
        var name: MutableLiveData<String> = MutableLiveData("")
        fun addName(String: String) {
            name.value = name.value + String
        }}

    fun getName(): MutableLiveData<String>{
        return name
    }

}