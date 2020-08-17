package com.example.exercise_view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LanguageViewModel : ViewModel(){

    var languageList = mutableListOf<String>("Java","Python")
    val languagesLiveData: MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

    fun addLanguage(name: String){
        languageList.add(name)
        languagesLiveData.value = languageList
        println(languagesLiveData.value?.joinToString())
    }

    fun removeLanguage(position: Int) {
        languageList.removeAt(position)
        languagesLiveData.value = languageList
        println(languagesLiveData.value?.joinToString())
    }
}