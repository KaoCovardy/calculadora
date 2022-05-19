package com.calculadora.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        //Adição dos valores nos botões 0 ao 9!
        num_zero.setOnClickListener({ AcrescentarUmaExpressao(umastr = "0", limpar_dados = true) })
        num_um.setOnClickListener({ AcrescentarUmaExpressao(umastr = "1", limpar_dados = true) })
        num_dois.setOnClickListener({ AcrescentarUmaExpressao(umastr = "2", limpar_dados = true) })
        num_tres.setOnClickListener({ AcrescentarUmaExpressao(umastr = "3", limpar_dados = true) })
        num_quatro.setOnClickListener({ AcrescentarUmaExpressao(umastr = "4", limpar_dados = true) })
        num_cinco.setOnClickListener({ AcrescentarUmaExpressao(umastr = "5", limpar_dados = true) })
        num_seis.setOnClickListener({ AcrescentarUmaExpressao(umastr = "6", limpar_dados = true) })
        num_sete.setOnClickListener({ AcrescentarUmaExpressao(umastr = "7", limpar_dados = true) })
        num_oito.setOnClickListener({ AcrescentarUmaExpressao(umastr = "8", limpar_dados = true) })
        num_nove.setOnClickListener({ AcrescentarUmaExpressao(umastr = "9", limpar_dados = true) })
    }

    fun AcrescentarUmaExpressao(umastr: String, limpar_dados: Boolean) {
        if (resultado.text.isNotEmpty()) {
            expressao.text = ""
        }
        if (limpar_dados) {
            resultado.text = ""
            expressao.append(umastr)
        } else {
            expressao.append(resultado.text)
            expressao.append(umastr)
            resultado.text = ""
        }
    }
}