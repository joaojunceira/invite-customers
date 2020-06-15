package com.company.invite.util

import com.company.invite.exception.InvalidInputException

object InputValidators {
    fun validateDouble(str: String): Double {
        val number = str.toDoubleOrNull()
        if (number == null) {
            throw InvalidInputException("Input is not a number")
        } else {
            return number
        }
    }
}