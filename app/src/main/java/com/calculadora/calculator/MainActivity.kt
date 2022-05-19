package com.calculadora.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder //importado para utilizar a biblioteca dos operadores(soma, subt)
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        //Adição dos valores nos botões 0 ao 9 e ponto
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
        num_ponto.setOnClickListener({AcrescentarUmaExpressao(umastr = ".", limpar_dados=true)})

        //Adição dos Operadores
        soma.setOnClickListener({AcrescentarUmaExpressao(umastr = "+", limpar_dados = false)})
        subtracao.setOnClickListener({AcrescentarUmaExpressao(umastr = "-", limpar_dados = false)})
        multiplicacao.setOnClickListener({AcrescentarUmaExpressao(umastr = "*", limpar_dados = false)})
        divisao.setOnClickListener({AcrescentarUmaExpressao(umastr = "/", limpar_dados = false)})

        //Faz a função limpar, limpeza da EXPRESSÃO e do RESULTADO digitado/mostrado na tela
        limpar.setOnClickListener(){
            expressao.text=""
            exp_resultado.text=""
        }

        // Realiza a função do backspace, apagando apenas um número por vez na "casa" expressão
        num_backspace.setOnClickListener(){
            val umvalor = expressao.text.toString()
            if (umvalor.isNotBlank()){
                expressao.text=umvalor.substring(0,umvalor.length-1)
            }
            exp_resultado.text=""
        }
        // resultado (botão igual) utilizado implementation 'net.objecthunter:exp4j:0.4.8'
        //para importar a biblioteca de expressionbuilder (utilização dos operadores) para fazer os calculos
        igual.setOnClickListener(){
            try{
                val expressao = ExpressionBuilder(expressao.text.toString()).build()

                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if(resultado == longResult.toDouble())
                    exp_resultado.text= longResult.toString()
                else
                    exp_resultado.text = resultado.toString()


            } catch (e: Exception){

            }
        }
    }

    fun AcrescentarUmaExpressao(umastr: String, limpar_dados: Boolean) {
        if (exp_resultado.text.isNotEmpty()) {
            expressao.text = ""
        }
        if (limpar_dados) {
            exp_resultado.text = ""
            expressao.append(umastr)
        } else {
            expressao.append(exp_resultado.text)
            expressao.append(umastr)
            exp_resultado.text = ""
        }
    }
}