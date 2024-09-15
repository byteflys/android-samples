package io.github.hellogoogle2000.android.samples

import android.app.Activity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import io.github.hellogoogle2000.android.commons.constant.Global
import io.github.hellogoogle2000.android.commons.dialog.ToastEx

class HomePopup(val activity: Activity) : PopupWindow() {

    init {
        width = 600
        height = 600
        setBackgroundDrawable(activity.getDrawable(io.github.hellogoogle2000.android.commons.R.color.black_percent_15))
        contentView = LayoutInflater.from(activity).inflate(R.layout.popup_home, null)
        val button = contentView.findViewById<View>(R.id.button)
        button.setOnClickListener {
            val context = Global.application
            val activity = activity
            val view = contentView
            val parentView = activity.findViewById<View>(android.R.id.content)
            ToastEx.show("hello")
        }
    }

    fun show() {
        val parentView = activity.findViewById<View>(android.R.id.content)
        HomePopup(activity).showAtLocation(parentView, Gravity.NO_GRAVITY, 200, 200)
    }
}