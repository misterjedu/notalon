package ng.com.jedun.notalon.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FieldValidator(
    var message: String = "",
    var isValidated: Boolean = false
) : Parcelable
