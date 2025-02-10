package com.example.tp1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivityNoXML : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        val phone = intent.getStringExtra("Phone")
        val layout_v : LinearLayout = LinearLayout(this).apply{
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            LinearLayout.LayoutParams.MATCH_PARENT
        }
        val textView : TextView = TextView(this).apply {
            text = String.format("+$phone")
            gravity = Gravity.CENTER
        }

        val btn_call : Button = Button(this).apply {
            text = java.lang.String(getString(R.string.phone))
            gravity = Gravity.CENTER
            setOnClickListener{
                val uri = Uri.parse("tel:$phone")
                val intent = Intent(Intent.ACTION_DIAL, uri)
                startActivity(intent)
            }
        }

        val imageView = ImageView(this).apply {
            setImageResource(R.drawable.phone)
        }

        layout_v.addView(imageView)
        layout_v.addView(textView)
        layout_v.addView(btn_call)
        setContentView(layout_v)
    }
}