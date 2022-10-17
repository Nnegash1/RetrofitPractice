package com.example.retrofitpractice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofitpractice.R
import com.example.retrofitpractice.databinding.ActivityMainBinding
import com.example.retrofitpractice.viewmodel.ShibeViewModel
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val vm: ShibeViewModel by viewModels()
    private val adapter = ShibeAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launchWhenResumed {
            vm.shibeState.collect {
                adapter.updateScreen(it)
            }
        }
        initAdapter()
        vm.getShibe("20")
    }

    private fun initAdapter() {
        binding.recycler.layoutManager = GridLayoutManager(this, 2)
        binding.recycler.adapter = adapter
    }
}