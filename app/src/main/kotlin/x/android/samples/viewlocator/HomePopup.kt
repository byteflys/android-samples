package x.android.samples.viewlocator

import android.app.Activity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import com.blankj.utilcode.util.ActivityUtils
import io.github.hellogoogle2000.android.commons.constant.Global
import io.github.hellogoogle2000.android.commons.dialog.ToastX
import io.github.hellogoogle2000.android.samples.R

class HomePopup(val activity: Activity) : PopupWindow() {

    init {
        width = 400
        height = 400
        setBackgroundDrawable(activity.getDrawable(io.github.hellogoogle2000.android.commons.R.color.black_percent_15))
        contentView = LayoutInflater.from(activity).inflate(R.layout.popup_home, null)
        val button = contentView.findViewById<View>(R.id.button)
        button.setOnClickListener {
            val app = Global.application
            val activity = activity
            val homeActivity = ActivityUtils.getActivityList().last()
            val windowView = contentView
            val activityView = activity.findViewById<View>(android.R.id.content)
            val homeActivityView = homeActivity.findViewById<View>(android.R.id.content)
            ToastX.show("hello")
        }
    }

    fun show() {
        val parentView = activity.findViewById<View>(android.R.id.content)
        HomePopup(activity).showAtLocation(parentView, Gravity.LEFT or Gravity.TOP, 100, 100)
    }
}