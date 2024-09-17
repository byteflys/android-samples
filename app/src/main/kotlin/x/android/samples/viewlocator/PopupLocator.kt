package x.android.samples.viewlocator

import android.content.Context
import android.graphics.Rect
import x.android.commons.context.ActivityX
import x.android.commons.ui.DockPoint
import x.android.commons.ui.ViewLocator.getActivityDecorView

object PopupLocator {

    // default way is drop down
    fun show(
        dstRect: Rect = Rect(),
        dstDockPoint: DockPoint = DockPoint.BOTTOM_CENTER,
        srcDockPoint: DockPoint = DockPoint.TOP_CENTER,
        windowContext: Context = ActivityX.getFrontActivity()
    ) {
        val parentView = windowContext.getActivityDecorView()
    }
}