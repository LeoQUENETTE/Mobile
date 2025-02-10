package com.example.tp1


import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class FormNoXML : AppCompatActivity(){
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)


        val layout_vertical : LinearLayout = LinearLayout(this).apply{
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            LinearLayout.LayoutParams.MATCH_PARENT
        }


        val editNom : EditText = EditText(this).apply {
            hint = getString(R.string.nom)
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,100
            )
        }
        val editAge : EditText = EditText(this).apply {
            hint = getString(R.string.age)
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,100
            )
        }
        val editPrenom : EditText = EditText(this).apply {
            hint = getString(R.string.prenom)
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,100
            )
        }
        val editNumero : EditText = EditText(this).apply {
            hint = getString(R.string.numero)
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,100
            )
        }
        val button : Button = Button(this).apply {
            text = getString(R.string.btn_validation)
            setOnClickListener{
                showDialog2(negativeAns = {
                    editPrenom.setText("")
                    editNom.setText("")
                    editAge.setText("")
                }, positiveAns = {
                    val intent = Intent(this@FormNoXML, SecondActivtyNoXML::class.java)
                    intent.putExtra("First Name", editPrenom.text.toString())
                    intent.putExtra("Last Name", editNom.text.toString())
                    intent.putExtra("Age", editAge.text.toString())
                    intent.putExtra("Phone", editNumero.text.toString())
                    editPrenom.setText("")
                    editNom.setText("")
                    editAge.setText("")
                    editNumero.setText("")
                    startActivity(intent)
                })
            }
        }

        layout_vertical.addView(editPrenom)
        layout_vertical.addView(editNom)
        layout_vertical.addView(editAge)
        layout_vertical.addView(editNumero)
        layout_vertical.addView(button)

        setContentView(layout_vertical)

    }

    private fun showDialog2(negativeAns: () -> Unit, positiveAns: () -> Unit){
        val dialog = android.app.AlertDialog.Builder(this)
        dialog.setTitle(getString(R.string.alerte))
        dialog.setMessage(getString(R.string.dialog_confirmation))
        dialog.setPositiveButton(getString(R.string.ok)) { d, _ ->
            positiveAns()
            d.dismiss()
        }
        dialog.setNegativeButton(R.string.cancel) { d, _ ->
            negativeAns()
            d.dismiss()
        }
        dialog.show()
    }

    private fun setLocale(localeCode: String) {
        val locale = Locale(localeCode)
        Locale.setDefault(locale)

        val config = resources.configuration
        config.setLocale(locale)

        // Apply the configuration to the current context
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}