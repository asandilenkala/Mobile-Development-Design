package com.example.home.model
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class LetterViewModel: ViewModel() {

    private val data = MutableLiveData<Char>()

    fun setData(char: Char){
        data.value=char
    }
    fun getData():Char?=data.value

    fun getLiveData():MutableLiveData<Char> =data



}