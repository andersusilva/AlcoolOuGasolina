package br.com.developforweb.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    var valorGasolina = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Carregar os componentes
        val seekbar = findViewById<SeekBar>(R.id.seekBar)
        val txtGasolina = findViewById<TextView>(R.id.txtValorGasolina)
        val txtResultado = findViewById<TextView>(R.id.textResultado)
        val btn = findViewById<Button>(R.id.btnCalcular)
        // Tamanho da Seekbar
        seekbar.max = 1000

        // Definir um Listener para a Seekbar
        seekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valorGasolina = progress
                var texto = "R$ "
                texto += formataValor(valorGasolina/100.0)
                txtGasolina.text = texto
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                txtResultado.text = "Selecione o valor da Gasolina"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                txtResultado.text = "Clique em Calcular para saber o Resultado"
            }

        })
        btn.setOnClickListener {
            var valorResultado = (valorGasolina * 0.7)/100.0
            var texto = "Abasteça com Alcool se ele custar até: R$ "
            texto += formataValor(valorResultado)
            txtResultado.text = texto
        }
    }

    private fun formataValor(valor: Double): Any? {
        return String.format(Locale.FRANCE, format = "%.2f", valor)
    }
}