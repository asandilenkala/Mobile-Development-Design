package com.example.home.model

import android.content.Context
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.home.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.imageview.ShapeableImageView

class ButtonActions(val context:Context,
                    val fragment: Fragment,
                    val bottomNavBar: BottomNavigationView,
                    val image: ShapeableImageView,
                    val letterViewModel: LetterViewModel,
                    val images:List<Int>,
                    val letter:List<Char>) {

    init {
        letterViewModel.getData()?.let { it ->
            val picIndex=it.code-'A'.code
           clickedLetter(picIndex)
        }
        bottomNavListeners()
    }


    private fun clickedLetter(index:Int){
        if(index in 0..25) {
            image.setBackgroundResource(images[index])
        }

    }

    private fun bottomNavListeners(){
        bottomNavBar.setOnItemSelectedListener (){item: MenuItem ->
            when(item.itemId){
                R.id.home-> {
                    NavHostFragment.findNavController(fragment).navigate(R.id.action_letterPage_to_navigation_home2)

                }
                R.id.first->{
                    letterViewModel.getData()?.let {
                        update(letterViewModel,letter,0)

                    }
                }
                R.id.previous->{
                    letterViewModel.getData()?.let {
                        val index:Int=  it.code-'A'.code -1
                        update(letterViewModel,letter,index)

                    }
                }
                R.id.next->{
                    letterViewModel.getData()?.let {
                        val index:Int=  it.code-'A'.code +1
                        update(letterViewModel,letter,index)

                    }
                }
                R.id.last->{
                    letterViewModel.getData()?.let {
                        update(letterViewModel,letter,25)
                    }
                }
            }
            true
        }
    }

    private  fun update(letterViewModel: LetterViewModel, letter:List<Char>, index:Int){
        if (index in 0..25) {
            letterViewModel.setData(letter[index])
            clickedLetter(index)
        }
    }


}