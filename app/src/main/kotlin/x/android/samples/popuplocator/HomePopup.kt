package x.android.samples.popuplocator

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.PopupWindow
import x.android.samples.R

class HomePopup(activity: Activity) : PopupWindow() {

    init {
        width = WRAP_CONTENT
        height = WRAP_CONTENT
        contentView = LayoutInflater.from(activity).inflate(R.layout.popup_home, null)
        val view = contentView.findViewById<View>(R.id.view)
        view.setOnClickListener {
            view.layoutParams.width = 2000
            view.layoutParams.height = 1500
            update(2000, 1500)
        }
    }
}