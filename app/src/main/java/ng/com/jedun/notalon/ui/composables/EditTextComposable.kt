package ng.com.jedun.notalon.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ng.com.jedun.notalon.ui.theme.*

@Composable
fun SimpleOutlinedTextFieldSample() {
//    var text by remember { mutableStateOf("") }
//
//    OutlinedTextField(
//        modifier = Modifier
//            .border(
//                width = 0.5.dp,
//                shape = RoundedCornerShape(34.dp),
//                brush = Brush.horizontalGradient(listOf(Color.Green, Color.Green))
//            )
//            .fillMaxWidth(),
//        value = text,
//        onValueChange = { text = it },
//        label = { Text("Email") },
//        placeholder = {
//            "absc@gmail.com"
//        },
//    )
    Column(modifier = Modifier.padding(vertical = 20.dp)) {
        var textState by remember { mutableStateOf("") }
        val maxLength = 110
        val lightBlue = Color(0xffd8e6ff)
        val blue = Color(0xff76a9ff)

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textState,
            label = { Text(text = "Email") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colors.primary,
                backgroundColor = lightBlue,
                cursorColor = MaterialTheme.colors.primary,
                disabledLabelColor = lightBlue,
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = notalon_text_field_unfocused_stroke,
                focusedLabelColor = notalon_grey,
                unfocusedLabelColor = notalon_grey
            ),
            onValueChange = {
                if (it.length <= maxLength) textState = it
            },
            shape = RoundedCornerShape(24.dp),
            singleLine = true,
//            trailingIcon = {
//                if (textState.isNotEmpty()) {
//                    IconButton(onClick = { textState = "" }) {
//                        Icon(
//                            imageVector = Icons.Outlined.Close,
//                            contentDescription = null
//                        )
//                    }
//                }
//            }
        )
//        Text(
//            text = "${textState.length} / $maxLength",
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 4.dp),
//            textAlign = TextAlign.End,
//            color = blue
//        )
    }
}