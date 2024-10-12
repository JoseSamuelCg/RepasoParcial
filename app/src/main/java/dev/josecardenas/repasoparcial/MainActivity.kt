package dev.josecardenas.repasoparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        title = "Regresar"
        val btnRegresar : Button = findViewById(R.id.btnRegresar)
        btnRegresar.setOnClickListener {
            val intent = Intent(this, LoginActvity::class.java)
            startActivity(intent)
            finish()
        }

        title = "IMC"
        val btnIMC : Button = findViewById(R.id.btnIMC)
        btnIMC.setOnClickListener {
            val intent = Intent(this, ImcActivity::class.java)
            startActivity(intent)
        }

        title = "Signo"
        val btnSigno : Button = findViewById(R.id.btnSigno)
        btnSigno.setOnClickListener {
            val intent = Intent(this, SignoActivity::class.java)
            startActivity(intent)
        }

        title = "Generaciones"
        val btnGeneraciones : Button = findViewById(R.id.btnGeneraciones)
        btnGeneraciones.setOnClickListener {
            val intent = Intent(this, GeneracionesActivity::class.java)
            startActivity(intent)
        }
    }
}