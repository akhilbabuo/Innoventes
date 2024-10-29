package com.blackbird.innoventes.extentions

import com.blackbird.innoventes.Constants


fun String.isValidPanNumber():Boolean{
    val pattern = Regex(Constants.PAN_NUMBER_REGEX)
    return pattern.matches(this)
}