package com.baonguyen.learnmath

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

enum class Operation(val number: Int) {
    Add(0),
    Subtraction(1),
    Multiplication(2),
    Device(3);

    internal fun calculate(first: Double, second: Double): Double {
        when (this) {
            Add -> { return first + second }
            Subtraction -> { return first - second }
            Multiplication ->  { return first * second }
            Device -> { return  first / second }
        }
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(view: View) {
        Toast.makeText(this, view.tag.toString(), Toast.LENGTH_SHORT).show()
        val first = editTextFirstNumber.text.toString().toDouble()
        val second = editTextSecondNumber.text.toString().toDouble()
        val tag = view.tag.toString().toInt()
        val operation = Operation.Add
        val result = operation.calculate(first, second)
        textViewResult.text = result.toString()
    }
}
