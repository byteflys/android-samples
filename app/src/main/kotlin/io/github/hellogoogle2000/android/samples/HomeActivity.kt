package io.github.hellogoogle2000.android.samples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.hellogoogle2000.android.samples.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {

    }
}