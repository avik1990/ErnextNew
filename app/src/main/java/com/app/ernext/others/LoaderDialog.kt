package com.app.ernext.others

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.core.content.ContextCompat
import com.app.ernext.R
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.loader_layout.*


/**
 * Created by avik on 16/3/18.
 */
class LoaderDialog(val context: Context?) {

    private val dialog: Dialog

    var disposable: Disposable? = null

    init {
        dialog = Dialog(context)
        context?.let {
            dialog.window.requestFeature(Window.FEATURE_NO_TITLE)
            dialog.getWindow().setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context, R.color.transparent)))
            dialog.setContentView(R.layout.loader_layout)
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)

            dialog.setOnCancelListener {
                disposable?.dispose()
            }
        }


    }


    fun show() {
        dialog.show()
        dialog?.avi?.smoothToShow()
    }

    fun hide() {
        disposable?.dispose()
        dialog?.avi?.smoothToHide()
        //runBlocking {
         //   delay(100)
            try {
                if (dialog.isShowing) {
                    dialog.dismiss()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
       // }
    }
}