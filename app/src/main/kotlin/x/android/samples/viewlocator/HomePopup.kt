package x.android.samples.viewlocator

import android.app.Activity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import com.blankj.utilcode.util.ActivityUtils
import x.android.commons.constant.Global
import x.android.commons.context.ActivityX.getActivityDecorView
import x.android.commons.dialog.ToastX
import x.android.samples.R
import x.android.samples.viewlocator.ViewLocator.getActivityContentSize
import x.android.samples.viewlocator.ViewLocator.getActivityOffset
import x.android.samples.viewlocator.ViewLocator.getActivityWindowSize
import x.android.samples.viewlocator.ViewLocator.getApplicationSize
import x.android.samples.viewlocator.ViewLocator.getContentOffset
import x.android.samples.viewlocator.ViewLocator.getWindowOffset
import x.android.samples.viewlocator.ViewLocator.getWindowSize
import x.android.samples.viewlocator.ViewLocator.locationInActivity
import x.android.samples.viewlocator.ViewLocator.locationInApplication
import x.android.samples.viewlocator.ViewLocator.locationInParent
import x.android.samples.viewlocator.ViewLocator.locationInWindow
import x.android.samples.viewlocator.ViewLocator.locationOnScreen
import x.android.samples.viewlocator.ViewLocator.rectInActivity
import x.android.samples.viewlocator.ViewLocator.rectInParent
import x.android.samples.viewlocator.ViewLocator.rectInWindow
import x.android.samples.viewlocator.ViewLocator.rectOnScreen
import x.android.samples.viewlocator.ViewLocator.visibleRectToSelf

class HomePopup(val activity: Activity) : PopupWindow() {

    init {
        width = 400
        height = 400
        contentView = LayoutInflater.from(activity).inflate(R.layout.popup_home, null)
        val button = contentView.findViewById<View>(R.id.button)
        button.setOnClickListener {
            val app = Global.application
            val dialogActivity = activity
            val homeActivity = ActivityUtils.getActivityList().last()
            val popupContentView = contentView
            val dialogActivityContentView = dialogActivity.findViewById<View>(android.R.id.content)
            val homeActivityContentView = homeActivity.findViewById<View>(android.R.id.content)
            // test cases
            val windowSize01 = popupContentView.getWindowSize()
            val windowSize02 = dialogActivityContentView.getWindowSize()
            val windowSize03 = homeActivityContentView.getWindowSize()
            val windowSize04 = dialogActivity.getActivityContentSize()
            val windowSize05 = homeActivity.getActivityContentSize()
            val windowSize06 = dialogActivity.getActivityWindowSize()
            val windowSize07 = homeActivity.getActivityWindowSize()
            val windowSize08 = dialogActivity.getApplicationSize()
            val windowSize09 = homeActivity.getApplicationSize()
            val windowSize10 = dialogActivity.getApplicationSize()
            val windowSize11 = homeActivity.getApplicationSize()
            val windowSize12 = app.getApplicationSize()
            val location13 = popupContentView.getWindowOffset()
            val location14 = dialogActivityContentView.getWindowOffset()
            val location15 = homeActivityContentView.getWindowOffset()
            val location16 = popupContentView.getWindowOffset(dialogActivityContentView)
            val location17 = dialogActivity.getContentOffset()
            val location18 = homeActivity.getContentOffset()
            val location19 = dialogActivity.getActivityOffset()
            val location20 = homeActivity.getActivityOffset()
            val location21 = it.locationInParent()
            val location22 = popupContentView.locationInParent()
            val location23 = dialogActivityContentView.locationInParent()
            val location24 = homeActivityContentView.locationInParent()
            val location25 = it.locationInWindow()
            val location26 = popupContentView.locationInWindow()
            val location27 = dialogActivityContentView.locationInWindow()
            val location28 = homeActivityContentView.locationInWindow()
            val location29 = it.locationInActivity()
            val location30 = popupContentView.locationInActivity()
            val location31 = dialogActivityContentView.locationInActivity()
            val location32 = homeActivityContentView.locationInActivity()
            val location33 = it.locationInApplication()
            val location34 = popupContentView.locationInApplication()
            val location35 = dialogActivityContentView.locationInApplication()
            val location36 = homeActivityContentView.locationInApplication()
            val location37 = it.locationOnScreen()
            val location38 = popupContentView.locationOnScreen()
            val location39 = dialogActivityContentView.locationOnScreen()
            val location40 = homeActivityContentView.locationOnScreen()
            val location41 = it.visibleRectToSelf()
            val location42 = it.rectInParent()
            val location43 = it.rectInWindow()
            val location44 = it.rectInActivity()
            val location45 = it.rectOnScreen()
            val location46 = homeActivityContentView.rectInActivity()
            val location47 = homeActivityContentView.rectOnScreen()
            val location48 = homeActivity.getActivityDecorView().rectOnScreen()
            ToastX.show("")
        }
    }

    fun show() {
        val parentView = activity.findViewById<View>(android.R.id.content)
        HomePopup(activity).showAtLocation(parentView, Gravity.LEFT or Gravity.TOP, 100, 100)
    }
}