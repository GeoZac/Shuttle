package com.simplecity.multisheetview.ui.behavior;

import android.content.Context;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {

    private static final String TAG = "CustomBottomSheetBehavi";

    private boolean allowDragging = true;

    public CustomBottomSheetBehavior() {
    }

    public CustomBottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAllowDragging(boolean allowDragging) {
        this.allowDragging = allowDragging;
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!allowDragging) {
            return false;
        }

        return super.onInterceptTouchEvent(parent, child, event);
    }


}