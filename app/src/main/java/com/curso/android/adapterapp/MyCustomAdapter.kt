package com.curso.android.adapterapp

import android.content.Context
import android.view.LayoutInflater
import android.widget.BaseAdapter
import android.widget.TextView

class MyCustomAdapter(private var context: Context?,
                      private var items: List<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int,
                         convertView: android.view.View?,
                         parent: android.view.ViewGroup?): android.view.View {

        val view : android.view.View
        val viewHolder: ViewHolder;

        if(convertView == null) {
            view = LayoutInflater.from(context)
                .inflate(R.layout.my_list_items, parent, false)
            viewHolder = ViewHolder()
            viewHolder.textView = view.findViewById(R.id.textView)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.textView?.text = items[position]

        return view
    }

    class ViewHolder {
        var textView: TextView? = null
    }
}