package com.example.calkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var num1:Double=0.0
    private var num2:Double=0.0
    private var operacion:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener{numeroPresionado("1")}
        btn2.setOnClickListener{numeroPresionado("2")}
        btn3.setOnClickListener{numeroPresionado("3")}
        btn4.setOnClickListener{numeroPresionado("4")}
        btn5.setOnClickListener{numeroPresionado("5")}
        btn6.setOnClickListener{numeroPresionado("6")}
        btn7.setOnClickListener{numeroPresionado("7")}
        btn8.setOnClickListener{numeroPresionado("8")}
        btn9.setOnClickListener{numeroPresionado("9")}
        btn0.setOnClickListener{numeroPresionado("0")}

        btnSumar.setOnClickListener{operacionPresionada(SUMA)}
        btnRestar.setOnClickListener{operacionPresionada(RESTA)}
        btnMultiplicar.setOnClickListener{operacionPresionada(MULTIPLICACION)}
        btnDividir.setOnClickListener { operacionPresionada(DIVISION) }

        btnClear.setOnClickListener {
            num1=0.0
            num2=0.0
            tvwResultado.text=""
            operacion= NO_OPERACION
        }

        btnResultado.setOnClickListener {
            var resultado = when(operacion){
                SUMA -> num1+num2
                RESTA -> num1-num2
                MULTIPLICACION -> num1*num2
                DIVISION -> num1/num2
                else -> 0
            }
            num1 = resultado as Double

            tvwResultado.text = if("$resultado".endsWith(".0")) { "$resultado".replace(".0","") } else { "%.2f".format(resultado) }
        }
    }

    private fun numeroPresionado(digito:String){

        if(tvwResultado.text == "0" && digito != ".") {
            tvwResultado.text = "$digito"
        } else {
            tvwResultado.text = "${tvwResultado.text}$digito"
        }

        if (operacion== NO_OPERACION){
            num1=tvwResultado.text.toString().toDouble()
        }else{
            num2=tvwResultado.text.toString().toDouble()
        }


    }

    private  fun operacionPresionada(operacion:Int){
        this.operacion = operacion
        tvwResultado.text=""
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION =3
        const val  DIVISION = 4
        const val NO_OPERACION =0
    }
}