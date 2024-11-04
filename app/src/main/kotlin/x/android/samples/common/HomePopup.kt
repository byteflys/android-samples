package x.android.samples.common

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.PopupWindow
import x.android.samples.R

class HomePopup(activity: Activity) : PopupWindow() {

    init {
        width = MATCH_PARENT
        height = MATCH_PARENT
        contentView = LayoutInflater.from(activity).inflate(R.layout.popup_home, null)
        isTouchable = true
        isOutsideTouchable = true
    }
}