package x.android.samples.viewlocator

import android.content.Context
import android.graphics.Rect
import android.util.Size
import android.view.View
import android.view.WindowManager
import androidx.annotation.UiContext
import x.android.commons.context.ActivityX.getActivityRootView
import x.android.commons.ui.Location

object ViewLocator {

    fun View.getWindowSize(): Size {
        return Size(rootView.measuredWidth, rootView.measuredHeight)
    }

    @UiContext
    fun Context.getActivitySize(): Size {
        val activityRootView = getActivityRootView()
        return Size(activityRootView.measuredWidth, activityRootView.measuredHeight)
    }

    fun Context.getApplicationSize(): Size {
        val windowManager = getSystemService(WindowManager::class.java)
        val bounds = windowManager.currentWindowMetrics.bounds
        return Size(bounds.width(), bounds.height())
    }

    fun Context.getScreenSize(): Size {
        val windowManager = getSystemService(WindowManager::class.java)
        val bounds = windowManager.maximumWindowMetrics.bounds
        return Size(bounds.width(), bounds.height())
    }

    // offset from current activity to application
    @UiContext
    fun View.getActivityOffset(): Location {
        val windowManager = context.getSystemService(WindowManager::class.java)
        val applicationBound = windowManager.currentWindowMetrics.bounds
        val activityLocation = getActivityRootView().locationOnScreen()
        val dx = activityLocation.x - applicationBound.left
        val dy = activityLocation.y - applicationBound.top
        return Location(dx = dx, dy = dy)
    }

    // offset from current window to parent window
    @UiContext
    fun View.getWindowOffset(): Location {
        val activityRootView = getActivityRootView()
        val viewLocationOnScreen = locationOnScreen()
        val activityLocationOnScreen = activityRootView.locationOnScreen()
        val dx = viewLocationOnScreen.x - activityLocationOnScreen.x
        val dy = viewLocationOnScreen.y - activityLocationOnScreen.y
        return Location(dx = dx, dy = dy)
    }

    // must in same activity
    @UiContext
    fun View.getWindowOffset(anotherView: View): Location {
        val thisLocation = rootView.locationInActivity()
        val anotherLocation = anotherView.locationInActivity()
        val dx = thisLocation.x - anotherLocation.x
        val dy = thisLocation.y - anotherLocation.y
        return Location(dx = dx, dy = dy)
    }

    fun View.locationInParent(): Location {
        return Location(left, top)
    }

    fun View.locationInWindow(): Location {
        val out = IntArray(2)
        getLocationInWindow(out)
        return Location(out[0], out[1])
    }

    @UiContext
    fun View.locationInActivity(): Location {
        val locationInWindow = locationInWindow()
        val windowOffset = getWindowOffset()
        return Location(locationInWindow.x + windowOffset.dx, locationInWindow.y + windowOffset.dy)
    }

    @UiContext
    fun View.locationInApplication(): Location {
        val locationInActivity = locationInActivity()
        val activityOffset = getActivityOffset()
        return Location(locationInActivity.x + activityOffset.dx, locationInActivity.y + activityOffset.dy)
    }

    fun View.locationOnScreen(): Location {
        val out = IntArray(2)
        getLocationOnScreen(out)
        return Location(out[0], out[1])
    }

    fun View.visibleRectToSelf(): Rect {
        val rect = Rect()
        getLocalVisibleRect(rect)
        return rect
    }

    fun View.rectInParent(): Rect {
        val location = locationInParent()
        return Rect(location.x, location.y, location.x + measuredWidth, location.y + measuredHeight)
    }

    fun View.rectInWindow(): Rect {
        val rect = Rect()
        getGlobalVisibleRect(rect)
        return rect
    }

    @UiContext
    fun View.rectInActivity(): Rect {
        val location = locationInActivity()
        return Rect(location.x, location.y, location.x + measuredWidth, location.y + measuredHeight)
    }

    // pixel size may be scaled in multi-window mode
    // right and bottom not equal to hardware pixels in this situation
    fun View.rectOnScreen(): Rect {
        val location = locationOnScreen()
        return Rect(location.x, location.y, location.x + measuredWidth, location.y + measuredHeight)
    }
}