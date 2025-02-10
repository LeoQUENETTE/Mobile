package com.example.tp1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FormXML : AppCompatActivity(){
    private lateinit var editNom : EditText
    private lateinit var editPrenom : EditText
    private lateinit var editAge : EditText
    private lateinit var btnValidation : Button


    override fun onCreate(savedInstace : Bundle?){
        super.onCreate(savedInstace)
        setContentView(R.layout.main_activity)


        editNom = findViewById(R.id.editNom)
        editPrenom = findViewById(R.id.editPrenom)
        editAge = findViewById(R.id.editAge)
        btnValidation = findViewById(R.id.btnValidation)

    }
}