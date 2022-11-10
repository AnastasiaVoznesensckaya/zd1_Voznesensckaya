package com.example.zad1_voznesensckaya

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var sharedd: SharedPreferences
    lateinit var userName: TextView
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        userName=findViewById(R.id.NameUser)
        result=findViewById(R.id.Result)
        spinner=findViewById(R.id.sp)
        sharedd=getSharedPreferences("ACCOUNT_FILMS", MODE_PRIVATE)
        var l=sharedd.getString("MY_LOGIN_FILM","NONE")
        userName.setText(l).toString()
        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this, R.array.filmNames,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val choose = resources.getStringArray(R.array.filmNames)
                result.setText(choose[position]).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}