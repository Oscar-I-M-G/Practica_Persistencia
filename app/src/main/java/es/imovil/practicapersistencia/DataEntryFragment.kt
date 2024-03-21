package es.imovil.practicapersistencia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import es.imovil.practicapersistencia.databinding.FragmentDataEntryBinding


class DataEntryFragment : Fragment() {

    private var _binding: FragmentDataEntryBinding? = null
    private val bookViewModel:BookViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDataEntryBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            bookViewModel.addBook(getData())
            Navigation.findNavController(it).popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getData(): Book {
        lateinit var autor: String
        var titulo :String = ""
        var isbntmp: String? = null
        var editorial: String? = null
        var pricetmp: Float = 0.0f
        with(binding){
            autor = authorEdit.text.toString()
            titulo = titleEdit.text.toString()
            editorial=editorEdit.text.toString()
            isbntmp=isbn.text.toString()
            pricetmp=price.text.toString().toFloatOrNull() ?: 0.0f
        }
        return Book(titulo, autor, isbntmp, editorial, pricetmp)
    }
}