package edu.wccnet.mshigbee.assignment6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import edu.wccnet.mshigbee.assignment6.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.display1.setOnClickListener {
            val action: FirstFragmentDirections.ActionFirstFragmentToSecondFragment =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(R.mipmap.android_image_3_foreground, "Image 1")
            findNavController().navigate(action)
        }

        binding.display2.setOnClickListener {
            val action: FirstFragmentDirections.ActionFirstFragmentToSecondFragment =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(R.mipmap.android_image_3_foreground, "Image 2")
            findNavController().navigate(action)
        }

        binding.display3.setOnClickListener {
            val action: FirstFragmentDirections.ActionFirstFragmentToSecondFragment =
//                FirstFragmentDirections.actionFirstFragmentToSecondFragment(R.drawable.android_image_3_background, "Image 3")
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(R.mipmap.android_image_3_foreground, "Image 3")
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}