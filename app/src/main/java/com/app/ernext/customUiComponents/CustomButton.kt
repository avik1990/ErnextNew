package com.app.ernext.customUiComponents

import android.content.Context
import android.graphics.Typeface
import androidx.appcompat.widget.AppCompatButton
import android.util.AttributeSet
import android.util.Log
import com.app.ernext.R

class CustomButton : AppCompatButton {

    fun setCustomFont(context: Context, customFont: String, isBold:Boolean) {
        try {
            var typeface = Typeface.createFromAsset(context.assets, customFont)
            if (isBold)
                setTypeface(typeface, Typeface.BOLD)
            else
                setTypeface(typeface)
        } catch (exception: Exception) {
            Log.e("CustomButton", exception.toString())
        }
    }

    constructor(context: Context) : super(context) {
        setCustomFont(context, context.getString(R.string.quicksandMedium), false)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        setCustomFont(context, context.getString(R.string.quicksandMedium),false)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(context, attributeSet, defStyle) {
        setCustomFont(context, context.getString(R.string.quicksandMedium),false)
    }
}