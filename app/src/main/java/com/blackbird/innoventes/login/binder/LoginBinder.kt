package com.blackbird.innoventes.login.binder

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.blackbird.innoventes.BR

class LoginBinder : BaseObservable() {

    @get:Bindable
    var panInput: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.panInput)
        }

    @get:Bindable
    var date: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.date)
        }

    @get:Bindable
    var month: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.month)
        }

    @get:Bindable
    var year: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.year)
        }


    @get:Bindable
    var dateValidationError: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.dateValidationError)
        }

    @get:Bindable
    var panNumberValid: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.panNumberValid)
            notifyChange()
            checkCredentials()
        }


    @get:Bindable
    var dayValid: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.dayValid)
            checkCredentials()
        }

    @get:Bindable
    var credentialsValid: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.credentialsValid)
        }

    private fun checkCredentials() {
        credentialsValid = panNumberValid && dayValid
    }

}