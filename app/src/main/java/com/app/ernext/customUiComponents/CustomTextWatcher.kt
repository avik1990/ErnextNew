package com.app.ernext.customUiComponents

import android.text.Editable
import android.text.TextWatcher

class CustomTextWatcher: TextWatcher {

    var editText:CustomEditText
    var listener:TextWatcherListener

    constructor(editText: CustomEditText, listener:TextWatcherListener){
        this.editText = editText
        this.listener = listener

        editText.addTextChangedListener(this)
    }

    /* For normal EditText */
    interface TextWatcherListener{
        fun onType(text:String, length:Int)
    }

    override fun afterTextChanged(editable: Editable?) {
        if (editable.toString().length>0){
            listener.onType(editable.toString(), editable.toString().length)
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }
}