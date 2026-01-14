package com.dijitart.fragmentnavigationproject

import android.R.attr.button
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dijitart.fragmentnavigationproject.databinding.FragmentBirinciBinding


class BirinciFragment : Fragment() {


    private var _binding: FragmentBirinciBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //onCreateView fonksiyonu ile fragmentin görünümünü oluşturuyoruz.
    //LayoutInflater ıle FragmentBirinciBinding sınıfımızı bağlıyoruz.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Correctly inflate the layout using the generated binding class
        _binding = FragmentBirinciBinding.inflate(inflater, container, false)
        // The root view is accessed via the binding object
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Fragmentlarde görünür işleri override ettiğimiz fonksiyonun içine yazıyoruz.
        //RecyclerView deki en büyük fark burası.
        binding.editTextText.setText("")
        binding.button.setOnClickListener {
           sonraki(it)
        }
    }

    fun sonraki (view: View) {
        //nav_graph.xml'deki verinin iletildiği fragmenttaki arguments teki tür ve isimle aynı olmalıdır.
        //Bundan dolayı kullaniciAdi isimli bir değişken tanımladık.
        val kullaniciAdi = binding.editTextText.text.toString()
        val action = BirinciFragmentDirections.actionBirinciFragmentToIkinciFragment(kullaniciAdi)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up the binding reference to avoid memory leaks
        _binding = null
    }
}
