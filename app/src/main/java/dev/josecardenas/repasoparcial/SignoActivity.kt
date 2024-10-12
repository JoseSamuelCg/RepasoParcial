package dev.josecardenas.repasoparcial

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class SignoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etFechaNacimiento: EditText = findViewById(R.id.etFechaNacimiento)
        val btnMenuPrincipal: Button = findViewById(R.id.btnMenuPrincipal)

        // Configurar el evento de clic para mostrar el DatePickerDialog
        etFechaNacimiento.setOnClickListener {
            // Obtener la fecha actual para mostrarla como predeterminada en el DatePicker
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Crear el DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Mostrar la fecha seleccionada en el EditText
                    val fechaSeleccionada = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    etFechaNacimiento.setText(fechaSeleccionada)
                },
                year, month, day
            )

            // Mostrar el DatePickerDialog
            datePickerDialog.show()
        }

        fun calcularEdad(anioNacimiento: Int, mesNacimiento: Int, diaNacimiento: Int): Int {
            val hoy = Calendar.getInstance()

            val anioActual = hoy.get(Calendar.YEAR)
            val mesActual = hoy.get(Calendar.MONTH)
            val diaActual = hoy.get(Calendar.DAY_OF_MONTH)

            var edad = anioActual - anioNacimiento

            // Restar 1 si aún no ha cumplido años este año
            if (mesNacimiento > mesActual || (mesNacimiento == mesActual && diaNacimiento > diaActual)) {
                edad--
            }

            return edad
        }
        fun obtenerSignoZodiacal(dia: Int, mes: Int): String {
            return when (mes) {
                1 -> if (dia >= 20) "Acuario" else "Capricornio"
                2 -> if (dia >= 19) "Piscis" else "Acuario"
                3 -> if (dia >= 21) "Aries" else "Piscis"
                4 -> if (dia >= 20) "Tauro" else "Aries"
                5 -> if (dia >= 21) "Géminis" else "Tauro"
                6 -> if (dia >= 21) "Cáncer" else "Géminis"
                7 -> if (dia >= 23) "Leo" else "Cáncer"
                8 -> if (dia >= 23) "Virgo" else "Leo"
                9 -> if (dia >= 23) "Libra" else "Virgo"
                10 -> if (dia >= 23) "Escorpio" else "Libra"
                11 -> if (dia >= 22) "Sagitario" else "Escorpio"
                12 -> if (dia >= 22) "Capricornio" else "Sagitario"
                else -> "Signo desconocido"
            }
        }
        val etFechNacimiento: EditText = findViewById(R.id.etFechaNacimiento)
        val tvEdad: TextView = findViewById(R.id.tvEdad)
        val tvSignoZodiacal: TextView = findViewById(R.id.tvSigno)

        etFechNacimiento.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Mostrar la fecha seleccionada en el EditText
                    val fechaSeleccionada = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    etFechNacimiento.setText(fechaSeleccionada)

                    // Calcular edad
                    val edad = calcularEdad(selectedYear, selectedMonth, selectedDay)
                    tvEdad.text = "Edad: $edad años"

                    // Obtener signo zodiacal
                    val signoZodiacal = obtenerSignoZodiacal(selectedDay, selectedMonth + 1)
                    tvSignoZodiacal.text = "Signo: $signoZodiacal"
                },
                year, month, day
            )

            datePickerDialog.show()
        }
        btnMenuPrincipal.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}