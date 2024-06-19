package com.example.fibonnacinumbers

import android.os.Binder
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fibonnacinumbers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        val fiboNumbersResult =fiboN(100)
        binding.rvnumbers.layoutManager = GridLayoutManager(this,2)
        val numAdapter = FibonacciRecycler(fiboNumbersResult)
        binding.rvnumbers.adapter = numAdapter
    }
    fun fiboN(t:Int):List<Int>{
        val numbers= mutableListOf(0,1)
        while (numbers.size<100){
            numbers.add(numbers[numbers.lastIndex]+numbers[numbers.lastIndex-1])
        }
        return numbers
    }
}