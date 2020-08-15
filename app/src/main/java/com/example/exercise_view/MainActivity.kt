package com.example.exercise_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var languageList = mutableListOf<String>("Java","Python","C","Swift","PHP","Javascript","Dart","C#","Objective C","Node Js")
    lateinit var languageRecycleAdapter: LanguageRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycleView.layoutManager = LinearLayoutManager(this)
        languageRecycleAdapter = LanguageRecycleAdapter(languageList)
        language_recycleView.adapter = languageRecycleAdapter
    }

    fun addLanguage(view:View){
        val languageName:String = language_name_input.text.toString()
        languageList.add(languageName)
        language_recycleView.adapter?.notifyDataSetChanged()
    }
}