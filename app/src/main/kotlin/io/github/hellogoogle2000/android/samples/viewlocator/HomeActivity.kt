package io.github.hellogoogle2000.android.samples.viewlocator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.hellogoogle2000.android.commons.context.ActivityX.fullscreen
import io.github.hellogoogle2000.android.samples.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        fullscreen()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.button.setOnClickListener {
            HomePopup(this).show()
        }
    }
}