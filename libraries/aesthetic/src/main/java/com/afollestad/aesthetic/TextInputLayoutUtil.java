package com.afollestad.aesthetic;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

import android.content.res.ColorStateList;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/** @author Aidan Follestad (afollestad) */
@RestrictTo(LIBRARY_GROUP)
final class TextInputLayoutUtil {

  static void setHint(@NonNull TextInputLayout view, @ColorInt int hintColor) {
    try {
      final Field mDefaultTextColorField =
          TextInputLayout.class.getDeclaredField("mDefaultTextColor");
      mDefaultTextColorField.setAccessible(true);
      mDefaultTextColorField.set(view, ColorStateList.valueOf(hintColor));
      final Method updateLabelStateMethod =
          TextInputLayout.class.getDeclaredMethod("updateLabelState", boolean.class, boolean.class);
      updateLabelStateMethod.setAccessible(true);
      updateLabelStateMethod.invoke(view, false, true);
    } catch (Throwable t) {
      throw new IllegalStateException(
          "Failed to set TextInputLayout hint (collapsed) color: " + t.getLocalizedMessage(), t);
    }
  }

  static void setAccent(@NonNull TextInputLayout view, @ColorInt int accentColor) {
    try {
      final Field mFocusedTextColorField =
          TextInputLayout.class.getDeclaredField("mFocusedTextColor");
      mFocusedTextColorField.setAccessible(true);
      mFocusedTextColorField.set(view, ColorStateList.valueOf(accentColor));
      final Method updateLabelStateMethod =
          TextInputLayout.class.getDeclaredMethod("updateLabelState", boolean.class, boolean.class);
      updateLabelStateMethod.setAccessible(true);
      updateLabelStateMethod.invoke(view, false, true);
    } catch (Throwable t) {
      throw new IllegalStateException(
          "Failed to set TextInputLayout accent (expanded) color: " + t.getLocalizedMessage(), t);
    }
  }
}
