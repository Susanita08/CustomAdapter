package com.curso.android.adapterapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //AdapterView
        val listView: ListView = findViewById(R.id.listView)

        val dataSource = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        val dataSource2 = listOf("Venezuela", "Peru", "EEUU", "Canada", "España")

        //val arrayAdapter = ArrayAdapter(this,
        //    android.R.layout.simple_list_item_1, dataSource)

        //listView.adapter = arrayAdapter

        //TypeOf Adapter
        val baseAdapter : BaseAdapter = MyCustomAdapter(this, dataSource2)
        listView.adapter = baseAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}