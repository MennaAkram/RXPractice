package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySecondBinding
import io.reactivex.rxjava3.subjects.BehaviorSubject

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var input : String? = null
        RXBus.behaviorSubject.subscribe {
                input = it.toString()
        }
        binding.TextView.text = input
        addCallbacks()
    }

    private fun addCallbacks() {
        binding.appCompatButton3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}