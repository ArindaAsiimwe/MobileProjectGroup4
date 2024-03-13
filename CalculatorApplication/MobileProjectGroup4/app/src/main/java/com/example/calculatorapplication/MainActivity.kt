package com.example.calculatorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText;
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var zero: Button
    private var isNweOp = true
    private var oldNumber = ""
    private var op = "+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize EditText
        editText = findViewById(R.id.editText)
    }


    fun numberEvent(view: View) {
        if (isNweOp)
            editText.setText("")
        isNweOp = false
        var buclick = editText.text.toString()
        val buselect = view as Button
        when (buselect.id) {
            R.id.one -> buclick += "1"
            R.id.two -> buclick += "2"
            R.id.three -> buclick += "3"
            R.id.four -> buclick += "4"
            R.id.five -> buclick += "5"
            R.id.six -> buclick += "6"
            R.id.seven -> buclick += "7"
            R.id.eight -> buclick += "8"
            R.id.nine -> buclick += "9"
            R.id.zero -> buclick += "0"
            R.id.point -> buclick += "."
            R.id.minusPlusButton -> buclick = "-$buclick"
        }
        editText.setText(buclick)
    }


    fun operatorEvent(view: View){
        isNweOp = true
        oldNumber = editText.text.toString()
        val buselect = view as Button
        when(buselect.id){
            R.id.divButton -> {op = "/"}
            R.id.multiButton -> {op = "*"}
            R.id.plusButton -> {op = "+"}
            R.id.minusButton -> {op = "-"}
            R.id.buBracketsOpen -> {op = "("}
            R.id.buBracketsClose -> {op = ")"}
        }

        editText.setText(op.toString())

    }

    fun equalEvent(view: View) {
        var newNumber = editText.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newNumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newNumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newNumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newNumber.toDouble()}


        }
        editText.setText(result.toString())
    }

    fun clearEvent(view: View) {
        editText.setText("")
        isNweOp = true
    }




}
