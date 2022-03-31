package com.example.cvhoang_test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cvhoang_test.databinding.ActivityMainBinding
import java.util.TimerTask

import java.util.Timer

import android.text.Editable

import android.text.TextWatcher

import android.R
import android.view.View

import android.widget.EditText
import androidx.core.widget.addTextChangedListener


class MainActivity : AppCompatActivity() {
    private val pattern = Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edtTitle2.getFocus().addTextChangedListener {
            binding.btnMessage.isEnabled =  test(it.toString(),binding.edtTitle.getText().toString())
        }
        binding.edtTitle.getFocus().addTextChangedListener {
            binding.btnMessage.isEnabled = test(binding.edtTitle2.getText().toString(),it.toString())
        }

    }
    fun test(text1:String,text2:String):Boolean{
        return text1.isNotEmpty() && pattern.matches(text2)
    }
}