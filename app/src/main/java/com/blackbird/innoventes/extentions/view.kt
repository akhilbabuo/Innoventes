package com.blackbird.innoventes.extentions

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.appcompat.widget.AppCompatTextView

fun AppCompatTextView.setClickableSpan(input: String, spanText: String,onclick:()->Unit) {
    val spannableString = SpannableString(input)
    val clickableSpan = object : ClickableSpan() {
        override fun onClick(widget: android.view.View) {
            onclick.invoke()
        }

        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.color = Color.BLUE
            ds.isUnderlineText = true
        }
    }

    val start = input.indexOf(spanText)
    spannableString.setSpan(
        clickableSpan,
        start,
        start + spanText.length,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    text = spannableString
    movementMethod = LinkMovementMethod.getInstance()
}