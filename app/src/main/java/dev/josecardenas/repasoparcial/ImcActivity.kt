package dev.josecardenas.repasoparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnCalcular : Button = findViewById(R.id.btnCalcular)
        val etPeso : EditText = findViewById(R.id.etPeso)
        val etEstatura : EditText = findViewById(R.id.etEstatura)
        val tvResultado : TextView = findViewById(R.id.tvResultado)
        val tvCategoria : TextView = findViewById(R.id.tvCategoria)
        val btnMenuPrincipal : Button = findViewById(R.id.btnMenuPrincipal)

        btnCalcular.setOnClickListener {
            val pesoStr = etPeso.text.toString()
            val estaturaStr = etEstatura.text.toString()

            if (pesoStr.isNotEmpty() && estaturaStr.isNotEmpty()) {
                val peso = pesoStr.toFloat()
                val estatura = estaturaStr.toFloat()

                if (estatura > 0) {
                    val imc = peso / (estatura * estatura)
                    tvResultado.text = String.format("Resultado: %.2f", imc)

                    if (imc < 18.5) {
                        tvCategoria.text = "Categoría: Bajo peso"
                    } else if (imc < 24.9) {
                        tvCategoria.text = "Categoría: Normal"
                    } else if (imc < 29.9) {
                        tvCategoria.text = "Categoría: Sobrepeso"
                    } else if (imc < 34.9) {
                        tvCategoria.text = "Categoría:Obesidad"
                    }
                } else {
                    tvResultado.text = "La estatura no puede ser 0"
                }
            } else {
                tvResultado.text = "Ingrese valores válidos"
            }
        }
        btnMenuPrincipal.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}