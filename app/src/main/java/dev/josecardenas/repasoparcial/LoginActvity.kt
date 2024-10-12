package dev.josecardenas.repasoparcial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_actvity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        title = "Ingresar"
        val emailSuccess : String = "admin@smartapp.com"
        val passwordSuccess : String = "admin123"
        val etEmail : EditText = findViewById(R.id.etEmail)
        val etPassword : EditText = findViewById(R.id.etPassword)
        val btnIngresar : Button = findViewById(R.id.btnIngresar)

        btnIngresar.setOnClickListener {
            val email: String = etEmail.text.trim().toString()
            val password: String = etPassword.text.trim().toString()
            if (email == emailSuccess && password == passwordSuccess) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Correo y/o clave inválida", Toast.LENGTH_LONG).show()
            }
        }
    }
}