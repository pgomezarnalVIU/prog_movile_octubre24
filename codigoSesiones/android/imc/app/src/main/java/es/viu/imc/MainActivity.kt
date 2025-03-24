package es.viu.imc

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Cargaria las vistas en el espacio seguro
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Capturamos los views
        val edtPeso : EditText = findViewById<EditText>(R.id.edtPeso)
        val edtAltura : EditText = findViewById<EditText>(R.id.edtAltura)
        val txtResult : TextView = findViewById<TextView>(R.id.txtResult)
        val btnCalcular : Button = findViewById<Button>(R.id.btnCalcular)

        //Listener sobre el boton Calcular
        btnCalcular.setOnClickListener {
            Log.i("IMC_INFO","SE HA APRETADO EL BOTON")
            //Recoger los datos del EditText
            val pesoNum:Float?=edtPeso.text.toString().toFloatOrNull()
            val alturaNum:Float?=edtAltura.text.toString().toFloatOrNull()

            if(pesoNum!=null && alturaNum!=null){
                val imc = pesoNum/(alturaNum*alturaNum)
                //Sacar el resultado
                txtResult.text = imc.toString()
            } else {
                txtResult.text = "TE HAS EQUIVOCADO"
            }
        }

    }
}