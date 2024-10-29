package com.blackbird.innoventes.login.binder


import android.graphics.Color
import android.text.InputFilter
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import com.blackbird.innoventes.extentions.getCurrentYear
import com.blackbird.innoventes.extentions.isValidPanNumber
import com.google.android.material.textfield.TextInputEditText
import java.time.LocalDate

@BindingAdapter("validatePan")
fun TextInputEditText.validatePan(binder: LoginBinder?) {
    doAfterTextChanged { finalEditable ->
        finalEditable.toString().let { finalText ->
            binder?.panNumberValid = finalText.isValidPanNumber()
            if (finalText.length == 10 && binder?.panNumberValid == false){
                error = "invalid pan"
            }
        }
    }
}

@BindingAdapter("setLargestInt","binder")
fun TextInputEditText.dateValidation(largestInt: Int,binder: LoginBinder?){
    filters = arrayOf(InputFilterMinMax(0,largestInt))
    binder?.let {
        doAfterTextChanged {
            if (binder.date.isNotBlank() && binder.month.isNotBlank() && binder.year.isNotBlank()){
                try {
                    val date = LocalDate.of(binder.year.toInt(),binder.month.toInt(),binder.date.toInt())
                    binder.dayValid = getCurrentYear() - date.year < 130
                }catch (e:Exception){
                    binder.dayValid = false
                    binder.dateValidationError = "invalid date"
                }
            }else{
                binder.dateValidationError = ""
                binder.dayValid = false
            }
        }
    }
}

@BindingAdapter("setError")
fun TextInputEditText.setError(error:String){
    if (error.isBlank()){
        setError(null)
    }else{
        setError(error)
    }
}


class InputFilterMinMax(private val min: Int, private val max: Int) : InputFilter {
    override fun filter(source: CharSequence?, start: Int, end: Int, dest: Spanned?, dstart: Int, dend: Int): CharSequence? {
        try {
            // Combine the old and new text to evaluate the full number
            val input = (dest?.toString() ?: "") + (source?.toString() ?: "")
            val number = input.toInt()
            if (number in min..max) return null // Accept input if within range
        } catch (e: NumberFormatException) {
            // Handle cases where input cannot be parsed to an integer
        }
        return "" // Reject input if out of range
    }
}