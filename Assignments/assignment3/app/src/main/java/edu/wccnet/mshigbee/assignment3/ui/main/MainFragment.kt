package edu.wccnet.mshigbee.assignment3.ui.main

import androidx.lifecycle.ViewModelProvider
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.wccnet.mshigbee.assignment3.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    interface MainButtonListener {
        fun onButtonClick(text: String): String}

    companion object {
        fun newInstance() = MainFragment()
    }

    private var activityCallback: MainButtonListener? = null

    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater,
            container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
                v: View -> buttonClicked()
        }
        if (viewModel != null){
            buttonClicked()}
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as MainButtonListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString()
                        + " must implement MainButtonListener"
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

//    @Deprecated("Deprecated in Java")
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//    }

    private fun buttonClicked(): String {
        val content = binding.EnterName.text.toString()
        Log.i("test", "button clicked fragment")
        val result = activityCallback?.onButtonClick(content).toString()
        binding.message.text = result
        return "Doesn't matter?"
    }
}


