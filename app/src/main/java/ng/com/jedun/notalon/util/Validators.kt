package ng.com.jedun.notalon.util

import ng.com.jedun.domain.Validator
import java.util.regex.Matcher
import java.util.regex.Pattern

//Validate Pin
fun validatePin(pin: String): Validator {
    return if (pin.length >= 6) {
        Validator("", true)
    } else {
        Validator("", false)
    }
}

fun validatePassword(password: String): Validator {
    return if (password.length >= 6) {
        Validator("", true)
    } else {
        Validator("Must be more than 6 letters", false)
    }
}

fun validateEmail(email: String): Validator {
    val pattern: Pattern =
        Pattern.compile("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})\$");
    val matcher: Matcher = pattern.matcher(email);
    val matchFound = matcher.matches()

    return if (email.trim().isNotEmpty() && matchFound) {
        Validator("", true)
    } else {
        Validator("Invalid Email", false)
    }
}