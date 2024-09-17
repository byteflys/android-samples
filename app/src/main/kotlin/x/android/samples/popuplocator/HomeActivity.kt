package x.android.samples.popuplocator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import x.android.commons.constant.Global.handler
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
        binding.button.setOnClickListener { showEach() }
    }

    private fun showEach() {
        val pairs = mutableListOf<DockPointPair>()
        val values = DockPoint.values()
        for (dst in values) {
            val pair = DockPointPair()
            pair.dstDockPoint = dst
            pair.srcDockPoint = DockPoint.BOTTOM_RIGHT
            pairs.add(pair)
        }
        for (i in pairs.indices) {
            val pair = pairs[i]
            handler.postDelayed({
                if (this::popup.isInitialized) {
                    popup.dismiss()
                }
                popup = HomePopup(this, binding.button)
                val windowLocation = popup.getWindowLocation(binding.button, pair.dstDockPoint, pair.srcDockPoint)
                popup.show(windowLocation)
            }, i * 2000L)
        }
    }
}

data class DockPointPair(
    var dstDockPoint: DockPoint = DockPoint.TOP_LEFT,
    var srcDockPoint: DockPoint = DockPoint.TOP_LEFT
)