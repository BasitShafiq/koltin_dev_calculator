package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var stringToEvaluate: TextView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        stringToEvaluate = findViewById<TextView>(R.id.stringToEvaluate)
    }


    fun onDigit(view: View) {
        var btn = view as Button;
        if (isOperatorAddded(stringToEvaluate?.text.toString())) {
            if (!isOperator(btn.text.toString())) {
                stringToEvaluate?.append(btn.text.toString())
            }
        } else {
            stringToEvaluate?.append(btn.text.toString())
        }

    }

    fun isOperator(op: String): Boolean {
        return if (op == "+" || op == "-" || op == "*" || op == "/") true
        else false
    }

    fun isOperatorAddded(exp: String): Boolean {
        return if (exp.contains("+") || exp.contains("-") || exp.contains("/") || exp.contains("*")) {
            true
        } else {
            false
        }
    }

    fun clearInput(view: View) {
        stringToEvaluate?.text = "";
    }

    fun evluateExpression(view: View) {
        val expression = stringToEvaluate?.text.toString()
        if (expression.contains("+")) {
            val operands = expression.split("+")
            if (operands.size == 2) {
                val operand1 = operands[0].trim().toDoubleOrNull()
                val operand2 = operands[1].trim().toDoubleOrNull()

                if (operand1 != null && operand2 != null) {
                    val result = operand1 + operand2
                    stringToEvaluate?.text = result.toString()
                } else {
                    stringToEvaluate?.text = "Error"
                }
            } else {
                stringToEvaluate?.text = "Error"
            }
        }
        if (expression.contains("-")) {
            val operands = expression.split("-")
            if (operands.size == 2) {
                val operand1 = operands[0].trim().toDoubleOrNull()
                val operand2 = operands[1].trim().toDoubleOrNull()

                if (operand1 != null && operand2 != null) {
                    val result = operand1 - operand2
                    stringToEvaluate?.text = result.toString()
                } else {
                    stringToEvaluate?.text = "Error"
                }
            } else {
                stringToEvaluate?.text = "Error"
            }
        }
        if (expression.contains("/")) {
            val operands = expression.split("/")
            if (operands.size == 2) {
                val operand1 = operands[0].trim().toDoubleOrNull()
                val operand2 = operands[1].trim().toDoubleOrNull()

                if (operand1 != null && operand2 != null) {
                    val result = operand1 / operand2
                    stringToEvaluate?.text = result.toString()
                } else {
                    stringToEvaluate?.text = "Error"
                }
            } else {
                stringToEvaluate?.text = "Error"
            }
        }
        if (expression.contains("*")) {
            val operands = expression.split("*")
            if (operands.size == 2) {
                val operand1 = operands[0].trim().toDoubleOrNull()
                val operand2 = operands[1].trim().toDoubleOrNull()

                if (operand1 != null && operand2 != null) {
                    val result = operand1 * operand2
                    stringToEvaluate?.text = result.toString()
                } else {
                    stringToEvaluate?.text = "Error"
                }
            } else {
                stringToEvaluate?.text = "Error"
            }
        }

    }

    fun isOperator() {

    }
}