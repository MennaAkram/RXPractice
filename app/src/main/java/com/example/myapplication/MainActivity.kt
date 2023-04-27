package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import io.reactivex.rxjava3.subjects.BehaviorSubject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addCallbacks()
    }

    private fun addCallbacks() {
        var Counter = 0
        binding.appCompatButton2.setOnClickListener {
            Counter++
        }
        binding.appCompatButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            RXBus.behaviorSubject.onNext(Counter)
            startActivity(intent)
        }
    }
}