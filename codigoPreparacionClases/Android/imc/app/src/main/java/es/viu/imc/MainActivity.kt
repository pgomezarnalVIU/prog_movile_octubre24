package es.viu.imc

import android.os.Bundle
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

        //Capturar boton, editTxts, txtResultado
        val edtPeso : EditText = findViewById<EditText>(R.id.edtPeso)
        val edtAltura : EditText = findViewById<EditText>(R.id.edtAltura)
        val txtResult : TextView = findViewById<TextView>(R.id.txtResult)
        val btnCalcular : Button = findViewById<Button>(R.id.btnCalcular)

        //Listener sobre el boton
        btnCalcular.setOnClickListener {
            //Calculos del IMC
            val pesoNum:Float?=edtPeso.text.toString().toFloatOrNull()
            val alturaNum:Float?=edtAltura.text.toString().toFloatOrNull()
            if(pesoNum!=null && alturaNum!=null) {
                val imc = pesoNum / (alturaNum * alturaNum)
                //Devolucion por el TextView
                txtResult.text = imc.toString()
            }else{
                txtResult.text = " ME ESTAS VACILANDO BRO? REVISA LOS DATOS"
            }
        }
    }
}