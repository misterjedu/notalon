package ng.com.jedun.notalon.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ng.com.jedun.domain.FieldValidator
import ng.com.jedun.notalon.R
import ng.com.jedun.notalon.ui.theme.*

@Composable
fun SimpleOutlinedTextFieldSample(
    label: String,
    value: String,
    isPassword: Boolean = false,
    placeholder: String = "",
    keyboardType: KeyboardType,
    validator: FieldValidator,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = Modifier.padding(vertical = 10.dp)) {

        var passwordVisibility by remember { mutableStateOf(false) }

        val icon = if (passwordVisibility) {
            painterResource(id = R.drawable.design_ic_visibility)
        } else {
            painterResource(id = R.drawable.design_ic_visibility_off)
        }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colors.primary,
                backgroundColor = MaterialTheme.colors.primary,
                cursorColor = MaterialTheme.colors.primary,
                disabledLabelColor = notalon_grey,
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = notalon_text_field_unfocused_stroke,
                focusedLabelColor = notalon_grey,
                unfocusedLabelColor = notalon_grey,
                placeholderColor = Color.Green,
                errorLabelColor = Color.Red
            ),
            onValueChange = onValueChange,
            shape = RoundedCornerShape(24.dp),
            singleLine = true,
            trailingIcon = {
                if (isPassword) {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(
                            painter = icon,
                            contentDescription = ""
                        )
                    }
                }
            },
            visualTransformation = if (passwordVisibility && isPassword) PasswordVisualTransformation()
            else VisualTransformation.None,

            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),

            isError = (!validator.isValidated && value.isNotBlank()),
        )

        if (!validator.isValidated && value.isNotBlank()) {
            Text(
                text = validator.message,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}


//Text(
//text = "Caption",
//modifier = Modifier
//.fillMaxWidth()
//.padding(bottom = 4.dp),
//textAlign = TextAlign.Start,
//color = blue
//)
//TextField(
//modifier = Modifier.fillMaxWidth(),
//value = textState,
//colors = TextFieldDefaults.textFieldColors(
//backgroundColor = lightBlue,
//cursorColor = Color.Black,
//disabledLabelColor = lightBlue,
//focusedIndicatorColor = Color.Transparent,
//unfocusedIndicatorColor = Color.Transparent
//),
//onValueChange = {
//    if (it.length <= maxLength) textState = it
//},
//shape = RoundedCornerShape(8.dp),
//singleLine = true,
//trailingIcon = {
//    if (textState.isNotEmpty()) {
//        IconButton(onClick = { textState = "" }) {
//            Icon(
//                imageVector = Icons.Outlined.Close,
//                contentDescription = null
//            )
//        }
//    }
//}
//)
//Text(
//text = "${textState.length} / $maxLength",
//modifier = Modifier
//.fillMaxWidth()
//.padding(top = 4.dp),
//textAlign = TextAlign.End,
//color = blue
//)
