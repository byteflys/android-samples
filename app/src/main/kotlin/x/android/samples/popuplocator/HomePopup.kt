package x.android.samples.popuplocator

import android.app.Activity
import android.view.LayoutInflater
import android.widget.PopupWindow
import x.android.samples.R

class HomePopup(activity: Activity) : PopupWindow() {

    init {
        width = 400
        height = 400
        contentView = LayoutInflater.from(activity).inflate(R.layout.popup_home, null)
    }
}