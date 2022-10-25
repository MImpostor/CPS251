package edu.wccnet.mshigbee.assignment5.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import edu.wccnet.mshigbee.assignment5.R
import edu.wccnet.mshigbee.assignment5.databinding.FragmentMainBinding
import edu.wccnet.mshigbee.assignment5.BR.myViewModel
import edu.wccnet.mshigbee.assignment5.DemoObserver


class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.setVariable(myViewModel, viewModel)
        lifecycle.addObserver(DemoObserver())
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.setVariable(myViewModel, DemoObserver().observerViewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}
