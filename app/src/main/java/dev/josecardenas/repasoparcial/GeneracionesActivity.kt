package dev.josecardenas.repasoparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.josecardenas.repasoparcial.adapter.GeneracionAdapter
import dev.josecardenas.repasoparcial.model.GeneracionModel

class GeneracionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_generaciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Configurar el RecyclerView
        val rvGeneraciones = findViewById<RecyclerView>(R.id.rvGeneraciones)
        rvGeneraciones.layoutManager = LinearLayoutManager(this)
        rvGeneraciones.adapter = GeneracionAdapter(getGeneraciones())


        val btnMenuPrincipal: Button = findViewById(R.id.btnMenuPrincipal)
        btnMenuPrincipal.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
    // Método para obtener la lista de generaciones
    private fun getGeneraciones(): List<GeneracionModel> {
        val generacionList: ArrayList<GeneracionModel> = ArrayList()
        generacionList.add(GeneracionModel(1, R.drawable.z, "Generación Z", "2001 - 2023"))
        generacionList.add(GeneracionModel(2, R.drawable.milenial, "Generación milenials", "1981 - 2000"))
        generacionList.add(GeneracionModel(3, R.drawable.x, "Generación X", "1965 - 1980"))
        generacionList.add(GeneracionModel(4, R.drawable.babyboomer, "Generación Baby Boomers", "1946 - 1964"))

        return generacionList
    }

}
