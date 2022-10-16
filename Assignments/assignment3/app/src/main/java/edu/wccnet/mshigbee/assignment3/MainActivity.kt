package edu.wccnet.mshigbee.assignment3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import edu.wccnet.mshigbee.assignment3.databinding.ActivityMainBinding
import edu.wccnet.mshigbee.assignment3.ui.main.MainFragment
import edu.wccnet.mshigbee.assignment3.ui.main.MainViewModel

class MainActivity : FragmentActivity(), MainFragment.MainButtonListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).
            get(MainViewModel::class.java)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun onButtonClick(text: String): String {
//        val fragModel = supportFragmentManager.
//        findFragmentById(R.id.container) as MainFragment
        viewModel.addName(text)
        return viewModel.getNames()


    }
}