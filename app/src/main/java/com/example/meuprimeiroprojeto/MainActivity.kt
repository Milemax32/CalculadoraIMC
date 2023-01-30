package com.example.meuprimeiroprojeto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edittext_peso)
        val edtAltura: EditText = findViewById(R.id.edittext_altura)

        btnCalcular.setOnClickListener {

            val pesostr = edtPeso.text.toString()
            val alturastr = edtAltura.text.toString()
            if (alturastr.isNotEmpty() && pesostr.isNotEmpty()) {
                val altura: Float = alturastr.toString().toFloat()
                val alturafinal: Float = altura * altura
                val peso: Float = pesostr.toString().toFloat()
                val IMC: Float = peso / alturafinal

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", IMC)
                    }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_SHORT).show()
            }

        }




    }
}