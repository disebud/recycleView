package com.example.exercise_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_view.viewmodel.LanguageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),RecyclerViewClickListener{

    val languageViewModel by viewModels<LanguageViewModel>()
    private lateinit var adapter: LanguageRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycleView.layoutManager = LinearLayoutManager(this)
        adapter = LanguageRecycleAdapter(languageViewModel.languagesLiveData.value!!)
        adapter.listener = this
        language_recycleView.adapter = adapter

        languageViewModel
            .languagesLiveData.observe(this, Observer {
                (language_recycleView.adapter as LanguageRecycleAdapter).notifyDataSetChanged()
        })

    }

    fun handleAddLanguage(view: View) {
        val languageName = language_name_input.text.toString()

        if (languageName.isEmpty()) {
            Toast.makeText(this, "Input cannot be empty!", Toast.LENGTH_SHORT).show()
        } else {
            languageViewModel.addLanguage(languageName)
        }
    }

    override fun onItemClicked(view: View, language: String) {
        Toast.makeText(this, "$language clicked!", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(view: View, index: Int, language: String) {
        Toast.makeText(this, "$language deleted!", Toast.LENGTH_SHORT).show()
        languageViewModel.removeLanguage(index)
    }
}
