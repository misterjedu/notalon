package ng.com.jedun.notalon.util

import ng.com.jedun.domain.FieldValidator
import java.util.regex.Matcher
import java.util.regex.Pattern

fun validatePassword(password: String): FieldValidator {
    return if (password.length >= 6) {
        FieldValidator("", true)
    } else {
        FieldValidator("Must be more than 6 letters", false)
    }
}

fun validateEmail(email: String): FieldValidator {
    val pattern: Pattern =
        Pattern.compile("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})\$");
    val matcher: Matcher = pattern.matcher(email);
    val matchFound = matcher.matches()

    return if (email.trim().isNotEmpty() && matchFound) {
        FieldValidator("", true)
    } else {
        FieldValidator("Invalid Email", false)
    }
}

/** Validating phone number field */
fun validatePhoneNumber(number: String): FieldValidator {
    val pattern: Pattern = Pattern.compile("[789][01][0-9]{8}")
    val matcher: Matcher = pattern.matcher(number.trim())
    val matchFound = matcher.matches()
    return if (matchFound) {
        FieldValidator("", true)
    } else {
        FieldValidator("Invalid Phone Number", false)
    }
}


fun validateFullName(name: String): FieldValidator {
    val fullName = name.split(" ")
    var firstName = ""
    var lastName = ""

    if (fullName.size >= 2) {
        firstName = fullName[0]
        lastName = fullName[1]
    }
    return if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
        FieldValidator("", true)
    } else {
        FieldValidator("Please, enter full name separated by a space", false)
    }
}


/** Validating Name field */
fun validateUserName(name: String): FieldValidator {
    return if (name.trim().length >= 3) {
        FieldValidator("", true)
    } else {
        FieldValidator("Username must have 3 or more characters", false)
    }
}
