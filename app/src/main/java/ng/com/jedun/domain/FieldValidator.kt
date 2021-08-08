package ng.com.jedun.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FieldValidator(
    var message: String = "",
    var isValidated: Boolean = false
) : Parcelable
