package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickButton(view: View){
        val valueStr = (view as Button).text.toString()

        when(view.id){
            R.id.btnDelete -> {
             val length = binding.tvOperation.length()
             if (length > 0) {
                 val newOperation = binding.tvOperation.text.toString().substring(0, length-1)
                 binding.tvOperation.text = newOperation
             }
            }
            R.id.btnClear -> {
             binding.tvOperation.text = ""
             binding.tvResult.text = ""
            }
            R.id.btnResolve -> {
              tryResolve(binding.tvOperation.text.toString())
            }
            else -> {
               binding.tvOperation.append(valueStr)
            }
        }
    }

    private fun tryResolve(operationRef: String) {
      val operator = getOperator(operationRef)

      var values = arrayOfNulls<String>(0)

      values = operationRef.split(operator).toTypedArray()

        val numberOne = values[0]
        val numberTwo = values[1]



    }

    private fun getOperator(operation: String): String {
       var operator = ""

       if(operation.contains(OPERATOR_MULTI)){
           operator = OPERATOR_MULTI
       } else if (operation.contains(OPERATOR_DIV)){
           operator = OPERATOR_DIV
       } else if (operation.contains(OPERATOR_SUM)){
           operator = OPERATOR_SUM
       } else if (operation.contains(OPERATOR_SUB)){
           operator = OPERATOR_SUB
       }


       return operator
    }

    companion object {
        const val OPERATOR_MULTI = "x"
        const val OPERATOR_DIV = "÷"
        const val OPERATOR_SUB = "-"
        const val OPERATOR_SUM = "+"
        const val OPERATOR_NULL = "null"
        const val POINT = "."

    }
}