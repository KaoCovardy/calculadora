package com.calculadora.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

    }
    fun AcrescentarUmaExpressao(umastring: String, limpar_dados: Boolean){
        if(resultado.text.isNotEmpty()){
            expressao.text = ""
        }
        if(limpar_dados){
            resultado.text=""
            expressao.append(umastring)
        }else(){
            expressao.append(resultado.text)
            expressao.append(umastring)
            resultado.text=""
        }
    }
}