package x.android.samples.popuplocator

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import x.android.samples.R

class HomePopup(activity: Activity, button: View) : PopupWindow() {

    init {
        width = 500
        height = 500
        contentView = LayoutInflater.from(activity).inflate(R.layout.popup_home, null)
        val view = contentView.findViewById<View>(R.id.view)
        view.setOnClickListener {
            update(2000, 500)
        }
        isTouchable = true
        isOutsideTouchable = true
    }
}