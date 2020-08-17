package com.example.exercise_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.language_item_layout.view.*

interface RecyclerViewClickListener {

    fun onItemClicked(view: View, language: String)
    fun onItemClicked(view: View, index: Int, language: String)

}

class  LanguageRecycleAdapter(private val languageList: MutableList<String>) : RecyclerView.Adapter<LanguageViewHolder>(){

    lateinit var listener: RecyclerViewClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.language_item_layout,parent,false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        println("$position ${languageList[position]}")
        holder.orderNumber.text = (position + 1).toString()
        holder.languageName.text = languageList[position]

        holder.itemView.setOnClickListener{
            listener.onItemClicked(it,languageList[position])
        }

        holder.itemView.delete_button.setOnClickListener {
            listener.onItemClicked(it,position,languageList[position])
        }

//        holder.itemView.setOnClickListener( View.OnClickListener { languageList.removeAt(position) // remove the item from list
//        notifyItemRemoved(position) // notify the adapter about the removed item
//         })
    }

}


//class LanguageViewHolder(v:View): RecyclerView.ViewHolder(v), View.OnClickListener {
class LanguageViewHolder(v:View): RecyclerView.ViewHolder(v) {
    val orderNumber  = v.findViewById<TextView>(R.id.order_number)
    val languageName = v.findViewById<TextView>(R.id.language_name)

//     override fun onClick (p0: View?){
//         Toast.makeText(p0?.context,"${languageName.text}",Toast.LENGTH_SHORT).show()
}
