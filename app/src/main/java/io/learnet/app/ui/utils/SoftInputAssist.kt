package io.learnet.app.ui.utils

import android.R
import android.app.Activity
import android.graphics.Rect
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.compose.ui.res.dimensionResource
import com.ismaeldivita.chipnavigation.ChipNavigationBar


/**
 * @author Bizuwork Melesse
 * created on 10/2/21
 */
class SoftInputAssist(activity: Activity) {
    private var rootView: View? = null
    private var contentContainer: ViewGroup? = null
    private var viewTreeObserver: ViewTreeObserver? = null
    private val resizeListener: () -> Unit
    private val keyboardVisibilityListener: () -> Unit
    private val contentAreaOfWindowBounds = Rect()
    private val rootViewLayout: FrameLayout.LayoutParams
    private var usableHeightPrevious = 0
    private var defaultUserScreenSize = 0
    private var bottomNavHeight: Int = 0
    private val chipNavigationBar: ChipNavigationBar
    @Volatile var keyboardIsOpen = false

    init {
        contentContainer = activity.findViewById(R.id.content) as ViewGroup
        rootView = contentContainer!!.getChildAt(0)
        rootViewLayout = rootView!!.layoutParams as FrameLayout.LayoutParams
        rootView?.getWindowVisibleDisplayFrame(contentAreaOfWindowBounds)
        defaultUserScreenSize = contentAreaOfWindowBounds.height()
        resizeListener = { resizeContentHeight() }
        keyboardVisibilityListener = { keyboardListener() }
        chipNavigationBar = (activity.findViewById(io.learnet.app.R.id.bottom_nav) as ChipNavigationBar)
        bottomNavHeight =  chipNavigationBar.layoutParams.height
    }

    private fun keyboardListener() {
        val r = Rect()
        rootView?.getWindowVisibleDisplayFrame(r)
        val currScreenHeight = r.height()
        keyboardIsOpen = currScreenHeight < defaultUserScreenSize
    }

    fun onResume() {
        if (viewTreeObserver == null || viewTreeObserver?.isAlive == false) {
            viewTreeObserver = rootView?.viewTreeObserver
        }
        viewTreeObserver?.addOnGlobalLayoutListener(resizeListener)
        viewTreeObserver?.addOnGlobalLayoutListener(keyboardVisibilityListener)
    }

    fun onPause() {
        if (viewTreeObserver?.isAlive == true) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                viewTreeObserver?.removeOnGlobalLayoutListener(resizeListener)
                viewTreeObserver?.removeOnGlobalLayoutListener(keyboardVisibilityListener)
            } else {
                //noinspection deprecation
                viewTreeObserver?.removeGlobalOnLayoutListener(resizeListener)
                viewTreeObserver?.removeGlobalOnLayoutListener(keyboardVisibilityListener)
            }
        }
    }

    fun onDestroy() {
        keyboardIsOpen = false
    }

    private fun resizeContentHeight() {
        var offset = 0
        chipNavigationBar.visibility = View.VISIBLE
        if (keyboardIsOpen) {
            offset =  bottomNavHeight
            chipNavigationBar.visibility = View.INVISIBLE
        }
        contentContainer?.getWindowVisibleDisplayFrame(contentAreaOfWindowBounds)
        val usableHeightNow = contentAreaOfWindowBounds.height() + offset
        if (usableHeightNow != usableHeightPrevious) {
            rootViewLayout.height = usableHeightNow
            // Change the bounds of the root view to prevent gap between keyboard and content,
            // and top of content positioned above top screen edge.
            rootView?.layout(contentAreaOfWindowBounds.left, contentAreaOfWindowBounds.top,
                contentAreaOfWindowBounds.right, contentAreaOfWindowBounds.bottom)
            rootView?.requestLayout()

            usableHeightPrevious = usableHeightNow
        }
    }
}