
\package com.example.home.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.home.databinding.FragmentLetterPageBinding
import com.example.home.model.LetterViewModel
import com.example.home.model.ButtonActions
import com.example.home.model.Images
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.imageview.ShapeableImageView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LetterPage.newInstance] factory method to
 * create an instance of this fragment.
 */
class LetterPage : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentLetterPageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLetterPageBinding.inflate(inflater)


        return  binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavBar:BottomNavigationView = binding.navView
        val image:ShapeableImageView = binding.letterImageId
        val alphabets = ('A'..'Z').toList()
        val images = Images.files();
        val letterViewModel = ViewModelProvider(requireActivity())[LetterViewModel::class.java]

        bottomNavSelected(bottomNavBar,image,letterViewModel,alphabets,images)


    }


    @SuppressLint("ResourceAsColor")
    private fun  bottomNavSelected(bottomNavBar:BottomNavigationView,
                                   image:ShapeableImageView,
                                   letterViewModel: LetterViewModel,
                                   letter:List<Char>,
                                   images:List<Int>

    ) {
        ButtonActions(
            context = requireContext(), fragment = this, bottomNavBar = bottomNavBar,
            image = image, letterViewModel = letterViewModel, images = images, letter = letter
        )

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LetterPage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LetterPage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}