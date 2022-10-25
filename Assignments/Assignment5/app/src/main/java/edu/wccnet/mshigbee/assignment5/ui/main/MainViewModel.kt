package edu.wccnet.mshigbee.assignment5.ui.main


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    companion object {
        fun newInstance() = MainViewModel().apply{} }

    private var name: MutableLiveData<String> = MutableLiveData("")

    fun getName(): MutableLiveData<String>{
        return name
    }

    fun addName(String: String) {
        name.value = name.value + String
    }
}