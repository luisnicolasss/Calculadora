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

            }
            R.id.btnClear -> {

            }
            R.id.btnResolve -> {

            }
            else -> {
               binding.tvOperation.append(valueStr)
            }
        }
    }
}