package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SecondActivtyNoXML : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        val first_name = intent.getStringExtra("First Name")
        val last_name = intent.getStringExtra("Last Name")
        val age = intent.getStringExtra("Age")
        val phone = intent.getStringExtra("Phone")

        val layout_h : LinearLayout = LinearLayout(this).apply{
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            LinearLayout.LayoutParams.MATCH_PARENT
        }

        val btn_ok = Button(this).apply {
            text = getString(R.string.ok)
            setOnClickListener{
                val intent = Intent(this@SecondActivtyNoXML, ThirdActivityNoXML::class.java)
                intent.putExtra("Phone", phone)
                startActivity(intent)
            }
        }
        val btn_cancel = Button(this).apply {
            text = getString(R.string.cancel)
            setOnClickListener{
                startActivity(Intent(this@SecondActivtyNoXML, FormNoXML::class.java))
            }
        }

        layout_h.addView(btn_cancel)
        layout_h.addView(btn_ok)
        setContentView(layout_h)
    }
}