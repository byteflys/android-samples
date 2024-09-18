package x.android.samples.popuplocator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import x.android.commons.context.ActivityX.immersive
import x.android.commons.ui.DockPoint
import x.android.samples.databinding.ActivityHomeBinding
import x.android.samples.popuplocator.PopupLocator.getWindowLocation
import x.android.samples.popuplocator.PopupLocator.show

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var popup: HomePopup

    override fun onCreate(savedInstanceState: Bundle?) {
        immersive()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.button.setOnClickListener {
            popup = HomePopup(this)
            val windowLocation = popup.getWindowLocation(binding.root, DockPoint.CENTER, DockPoint.CENTER)
            popup.show(windowLocation, this)
        }
    }
}