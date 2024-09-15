package io.github.hellogoogle2000.android.samples.viewlocator

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import io.github.hellogoogle2000.android.commons.context.ActivityX.fullscreen
import io.github.hellogoogle2000.android.samples.databinding.ActivityHomeBinding

class DialogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        fullscreen()
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val flag = WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
        window.setFlags(flag, flag)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        binding.root.setBackgroundColor(Color.parseColor("#110000FF"))
        setContentView(binding.root)
        initView()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            val lp = window.attributes
            lp.width = 1000
            lp.height = 1000
            lp.gravity = Gravity.CENTER
            window.attributes = lp
        }
    }

    private fun initView() {
        binding.button.setOnClickListener {
            HomePopup(this).show()
        }
    }
}