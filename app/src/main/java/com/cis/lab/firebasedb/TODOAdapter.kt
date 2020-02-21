package com.cis.lab.firebasedb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView

class TODOAdapter(context:Context,itemList:MutableList<TodoItem>):BaseAdapter(){
    var item = itemList
    val mInflater = LayoutInflater.from(context)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val objID = item.get(position).objID as String
        val todoName = item.get(position).todoName as String
        val status = item.get(position).status as Boolean
        val view:View
        val vh: ListRowHolder
        if(convertView==null){
            view = mInflater.inflate(R.layout.list_item,parent,false)
            vh = ListRowHolder(view)
            view.tag = vh
        }else{
            view = convertView
            vh = view.tag as ListRowHolder
        }
        vh.label.text = todoName
        vh.checkbox.isChecked = status
        return view
    }

    private class ListRowHolder(row: View?){
        val label = row!!.findViewById<TextView>(R.id.textView)
        val checkbox: CheckBox = row!!.findViewById<TextView>(R.id.checkBox) as CheckBox
        val deleteButton = row!!.findViewById<TextView>(R.id.imageButton)
    }

    override fun getItem(position: Int): Any {
        return item.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return item.size
    }

}