package com.dijitart.fragmentnavigationproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.dijitart.fragmentnavigationproject.databinding.FragmentIkinciBinding

class IkinciFragment : Fragment() {

    private var _binding: FragmentIkinciBinding? = null
    private val binding get() = _binding!!

    // Used the navArgs delegate to safely access the arguments passed to this fragment
    private val args: IkinciFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIkinciBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Retrieved the username argument that was passed from BirinciFragment
        val username = args.username

        // 2. Set the text of the TextView to display the received username
        binding.textView.text = username
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
