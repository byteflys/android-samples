package x.android.samples.viewlocator

import android.content.Context
import android.graphics.Rect
import android.util.Size
import android.view.View
import android.view.WindowManager
import androidx.annotation.UiContext
import x.android.commons.context.ActivityX.getActivityContentView
import x.android.commons.context.ActivityX.getActivityDecorView
import x.android.commons.context.ActivityX.getWindowDecorView
import x.android.commons.ui.Location

// android sdk only provides these info
// location to parent, location in window, location on screen
// view bounds, app bounds, screen bounds
// other info can only be inferred from these
object ViewLocator {

    fun View.getWindowSize(): Size {
        val decorView = getWindowDecorView()
        return Size(decorView.measuredWidth, decorView.measuredHeight)
    }

    @UiContext
    fun Context.getActivityContentSize(): Size {
        val activityContentView = getActivityContentView()
        return Size(activityContentView.measuredWidth, activityContentView.measuredHeight)
    }

    @UiContext
    fun Context.getActivityWindowSize(): Size {
        val activityDecorView = getActivityDecorView()
        return Size(activityDecorView.measuredWidth, activityDecorView.measuredHeight)
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

    // offset from current window to parent window
    @UiContext
    fun View.getWindowOffset(): Location {
        val activityDecorView = getActivityDecorView()
        return getWindowOffset(activityDecorView)
    }

    // must in same activity
    @UiContext
    fun View.getWindowOffset(anotherView: View): Location {
        val thisLocation = getWindowDecorView().locationOnScreen()
        val anotherLocation = anotherView.getWindowDecorView().locationOnScreen()
        val dx = thisLocation.x - anotherLocation.x
        val dy = thisLocation.y - anotherLocation.y
        return Location(dx = dx, dy = dy)
    }

    // offset from activity content to activity window
    @UiContext
    fun Context.getContentOffset(): Location {
        val activityContentView = getActivityContentView()
        return activityContentView.locationInWindow()
    }

    // offset from current activity to application
    @UiContext
    fun Context.getActivityOffset(): Location {
        val windowManager = getSystemService(WindowManager::class.java)
        val applicationBound = windowManager.currentWindowMetrics.bounds
        val activityLocation = getActivityDecorView().locationOnScreen()
        val dx = activityLocation.x - applicationBound.left
        val dy = activityLocation.y - applicationBound.top
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
        val activityOffset = context.getActivityOffset()
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
    fun View.rectOnScreen(): Rect {
        val location = locationOnScreen()
        return Rect(location.x, location.y, location.x + measuredWidth, location.y + measuredHeight)
    }
}