package edu.wccnet.mshigbee.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import edu.wccnet.mshigbee.assignment4.databinding.ActivityMainBinding
import edu.wccnet.mshigbee.assignment4.ui.main.MainFragment
import edu.wccnet.mshigbee.assignment4.ui.main.MainViewModel

class MainActivity : FragmentActivity() {
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

}

