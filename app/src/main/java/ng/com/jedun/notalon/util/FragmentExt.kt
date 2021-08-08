package ng.com.jedun.notalon.util

import android.widget.Toast
import androidx.fragment.app.Fragment
import ng.com.jedun.domain.FieldValidator


fun Fragment.toast(message: String) {
    Toast.makeText(this.requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Fragment.validateMultipleTextFields(allFields: Array<FieldValidator>): Boolean {
    println(allFields.toList())
    return allFields.none { validator -> !validator.isValidated }
}