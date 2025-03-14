package com.example.navigationcomponents

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class SampleViewModel: ViewModel() {
    val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name
    private val _age = MutableLiveData<String>()
    val age: LiveData<String> = _age

    val _numOfChar = MutableLiveData<Int>()

    fun updateNumOfChar(txt: String?){
        _numOfChar.value = txt?.length ?: 0
    }

    fun updateName(name :String){
        _name.value=name
    }
    fun updateAge(age: String){
        _age.value=age
    }

    override fun onCleared() {
        super.onCleared()
    }
}