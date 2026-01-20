package com.example.scicalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.*

class SciCalcActivity : AppCompatActivity() {

    private var isRunning = false
    private var startTime = 0L
    private var elapsedTime = 0L
    private val handler = android.os.Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scicalc)

        val input = findViewById<TextView>(R.id.tvExpression)
        val result = findViewById<TextView>(R.id.tvResult)

        fun append(str: String) {
            input.text = input.text.toString() + str
        }

        fun calculate() {
            try {
                val expr = input.text.toString()
                val computed = evaluate(expr)
                result.text = computed.toString()
            } catch (e: Exception) {
                result.text = "Error"
            }
        }

        val buttons = listOf(
            R.id.btn0 to "0", R.id.btn1 to "1", R.id.btn2 to "2",
            R.id.btn3 to "3", R.id.btn4 to "4", R.id.btn5 to "5",
            R.id.btn6 to "6", R.id.btn7 to "7", R.id.btn8 to "8",
            R.id.btn9 to "9"
        )

        for ((btnId, value) in buttons) {
            findViewById<Button>(btnId).setOnClickListener { append(value) }
        }

        findViewById<Button>(R.id.btnPlus).setOnClickListener { append("+") }
        findViewById<Button>(R.id.btnMinus).setOnClickListener { append("-") }
        findViewById<Button>(R.id.btnMul).setOnClickListener { append("*") }
        findViewById<Button>(R.id.btnDiv).setOnClickListener { append("/") }
        findViewById<Button>(R.id.btnPow).setOnClickListener { append("^") }
        findViewById<Button>(R.id.btnMod).setOnClickListener { append("%") }
        findViewById<Button>(R.id.btnDot).setOnClickListener { append(".") }

        findViewById<Button>(R.id.btnOpen).setOnClickListener { append("(") }
        findViewById<Button>(R.id.btnClose).setOnClickListener { append(")") }

        findViewById<Button>(R.id.btnSin).setOnClickListener { append("sin(") }
        findViewById<Button>(R.id.btnCos).setOnClickListener { append("cos(") }
        findViewById<Button>(R.id.btnTan).setOnClickListener { append("tan(") }
        findViewById<Button>(R.id.btnLog).setOnClickListener { append("log(") }
        findViewById<Button>(R.id.btnLn).setOnClickListener { append("ln(") }
        findViewById<Button>(R.id.btnSqrt).setOnClickListener { append("sqrt(") }

        findViewById<Button>(R.id.btnPi).setOnClickListener { append("3.14159265") }
        findViewById<Button>(R.id.btnE).setOnClickListener { append("2.71828182") }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            input.text = ""
            result.text = ""
        }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            val text = input.text.toString()
            if (text.isNotEmpty()) input.text = text.substring(0, text.length - 1)
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener { calculate() }

        val stopwatchText = findViewById<TextView>(R.id.tvStopwatch)
        val startBtn = findViewById<Button>(R.id.btnStart)
        val stopBtn = findViewById<Button>(R.id.btnStop)
        val resetBtn = findViewById<Button>(R.id.btnReset)

        val runnable = object : Runnable {
            override fun run() {
                if (isRunning) {
                    val now = System.currentTimeMillis()
                    val total = elapsedTime + (now - startTime)

                    val minutes = (total / 1000) / 60
                    val seconds = (total / 1000) % 60
                    val millis = (total % 1000) / 10

                    stopwatchText.text = String.format("%02d:%02d.%02d", minutes, seconds, millis)
                    handler.postDelayed(this, 10)
                }
            }
        }

        startBtn.setOnClickListener {
            if (!isRunning) {
                startTime = System.currentTimeMillis()
                isRunning = true
                handler.post(runnable)
            }
        }

        stopBtn.setOnClickListener {
            if (isRunning) {
                elapsedTime += System.currentTimeMillis() - startTime
                isRunning = false
            }
        }

        resetBtn.setOnClickListener {
            isRunning = false
            elapsedTime = 0
            startTime = 0
            stopwatchText.text = "00:00.00"
        }
    }

    private fun evaluate(expr: String): Double {
        return object {
            var i = -1
            var ch = 0

            fun nextChar() {
                ch = if (++i < expr.length) expr[i].code else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.code) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (i < expr.length) throw RuntimeException("Unexpected: " + expr[i])
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    x = when {
                        eat('+'.code) -> x + parseTerm()
                        eat('-'.code) -> x - parseTerm()
                        else -> return x
                    }
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    x = when {
                        eat('*'.code) -> x * parseFactor()
                        eat('/'.code) -> x / parseFactor()
                        eat('%'.code) -> x % parseFactor()
                        else -> return x
                    }
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.code)) return parseFactor() // unary +
                if (eat('-'.code)) return -parseFactor() // unary -

                var x: Double
                val startPos = i

                if (eat('('.code)) {
                    x = parseExpression()
                    eat(')'.code)
                } else if (ch in '0'.code..'9'.code || ch == '.'.code) {
                    while (ch in '0'.code..'9'.code || ch == '.'.code) nextChar()
                    x = expr.substring(startPos, i).toDouble()
                } else if (ch in 'a'.code..'z'.code) {
                    while (ch in 'a'.code..'z'.code) nextChar()
                    val func = expr.substring(startPos, i)
                    x = parseFactor()
                    x = when (func) {
                        "sqrt" -> sqrt(x)
                        "sin" -> sin(Math.toRadians(x))
                        "cos" -> cos(Math.toRadians(x))
                        "tan" -> tan(Math.toRadians(x))
                        "log" -> log10(x)
                        "ln" -> ln(x)
                        else -> throw RuntimeException("Unknown function: $func")
                    }
                } else {
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }

                if (eat('^'.code)) x = x.pow(parseFactor())
                return x
            }
        }.parse()
    }
}
