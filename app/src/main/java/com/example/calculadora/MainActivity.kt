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

            }
            else -> {
               binding.tvOperation.append(valueStr)
            }
        }
    }
}