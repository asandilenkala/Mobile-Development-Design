package com.example.home.presentation

import com.example.home.R
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.home.model.LetterViewModel
import com.example.home.model.Sizes
import com.google.android.material.button.MaterialButton

class LettersRecycleViewAdapter(private var size:Int, private val fragment: Fragment) :
    RecyclerView.Adapter<LettersRecycleViewAdapter.ViewHolder>(){
    private val model = ViewModelProvider(fragment.requireActivity())[LetterViewModel::class.java]


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view  = LayoutInflater.from(parent.context).
        inflate(R.layout.letters,parent,false)
        val layoutParams:ViewGroup.LayoutParams = view.layoutParams
        layoutParams.height=(parent.height/size)
        view.layoutParams=layoutParams

        return  ViewHolder(view)
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alphabets = ('A'..'Z').toList()
         holder.button.text=alphabets[position]+""
        holder.button.setOnClickListener{
             model.setData(alphabets[position])
            NavHostFragment.findNavController(fragment).navigate(R.id.action_overview_letterPage)

        }
    }



    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int = Sizes.numberButtons

    @SuppressLint("ResourceAsColor")
    class ViewHolder( view: View) :  RecyclerView.ViewHolder(view){
        val  button:MaterialButton = view.findViewById(R.id.buttonId)
    }
}