package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn0 = findViewById<TextView>(R.id.btn_0)
        btn0.setOnClickListener { setSymbol("0") }
        val btn1 = findViewById<TextView>(R.id.btn_1)
        btn1.setOnClickListener { setSymbol("1") }
        val btn2 = findViewById<TextView>(R.id.btn_2)
        btn2.setOnClickListener { setSymbol("2") }
        val btn3 = findViewById<TextView>(R.id.btn_3)
        btn3.setOnClickListener { setSymbol("3") }
        val btn4 = findViewById<TextView>(R.id.btn_4)
        btn4.setOnClickListener { setSymbol("4") }
        val btn5 = findViewById<TextView>(R.id.btn_5)
        btn5.setOnClickListener { setSymbol("5") }
        val btn6 = findViewById<TextView>(R.id.btn_6)
        btn6.setOnClickListener { setSymbol("6") }
        val btn7 = findViewById<TextView>(R.id.btn_7)
        btn7.setOnClickListener { setSymbol("7") }
        val btn8 = findViewById<TextView>(R.id.btn_8)
        btn8.setOnClickListener { setSymbol("8") }
        val btn9 = findViewById<TextView>(R.id.btn_9)
        btn9.setOnClickListener { setSymbol("9") }
        val btnLBracket = findViewById<TextView>(R.id.btn_l_bracket)
        btnLBracket.setOnClickListener { setSymbol("(") }
        val btnRBracket = findViewById<TextView>(R.id.btn_r_bracket)
        btnRBracket.setOnClickListener { setSymbol(")") }
        val btnDev = findViewById<TextView>(R.id.btn_dev)
        btnDev.setOnClickListener { setSymbol("/") }
        val btnMulti = findViewById<TextView>(R.id.btn_multi)
        btnMulti.setOnClickListener { setSymbol("*") }
        val btnAdd = findViewById<TextView>(R.id.btn_add)
        btnAdd.setOnClickListener { setSymbol("+") }
        val btnSub = findViewById<TextView>(R.id.btn_sub)
        btnSub.setOnClickListener { setSymbol("-") }
        val btnDot = findViewById<TextView>(R.id.btn_dot)
        btnDot.setOnClickListener { setSymbol(".") }

        val btnAC = findViewById<TextView>(R.id.btn_ac)
        val mathOp = findViewById<TextView>(R.id.math_operation)
        val resText = findViewById<TextView>(R.id.result_text)
        btnAC.setOnClickListener {
            mathOp.text = ""
            resText.text = ""
        }
        val btnBack= findViewById<TextView>(R.id.btn_back)
        btnBack.setOnClickListener {
            val text = mathOp.text.toString()
            if (text.isNotEmpty())
                mathOp.text = text.substring(0, text.length - 1)
            resText.text = ""
        }
        val btnEqually = findViewById<TextView>(R.id.btn_equally)
        btnEqually.setOnClickListener{
            try {
                val ex = ExpressionBuilder(mathOp.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    resText.text = longRes.toString()
                else
                    resText.text = result.toString()
            } catch (e: Exception) {
                Log.d("Ошибка", "Сообщение ${e.message}")
            }

        }

    }

    private fun setSymbol(str: String) {
        val resText = findViewById<TextView>(R.id.result_text)
        val mathOp = findViewById<TextView>(R.id.math_operation)
        if (resText.text != "") {
            mathOp.text = resText.text
            resText.text = ""
        }
        mathOp.append(str)
    }
}