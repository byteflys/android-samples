package x.android.samples.viewlocator

import android.app.Activity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import com.blankj.utilcode.util.ActivityUtils
import x.android.commons.constant.Global
import x.android.commons.dialog.ToastX
import x.android.samples.R
import x.android.samples.viewlocator.ViewLocator.getActivityOffset

class HomePopup(val activity: Activity) : PopupWindow() {

    init {
        width = 400
        height = 400
        setBackgroundDrawable(activity.getDrawable(x.android.commons.R.color.black_percent_15))
        contentView = LayoutInflater.from(activity).inflate(R.layout.popup_home, null)
        val button = contentView.findViewById<View>(R.id.button)
        button.setOnClickListener {
            val app = Global.application
            val activity = activity
            val homeActivity = ActivityUtils.getActivityList().last()
            val windowView = contentView
            val activityView = activity.findViewById<View>(android.R.id.content)
            val homeActivityView = homeActivity.findViewById<View>(android.R.id.content)
            val offset1 = activityView.getActivityOffset()
            val offset2 = homeActivityView.getActivityOffset()
            ToastX.show("hello")
        }
    }

    fun show() {
        val parentView = activity.findViewById<View>(android.R.id.content)
        HomePopup(activity).showAtLocation(parentView, Gravity.LEFT or Gravity.TOP, 100, 100)
    }
}