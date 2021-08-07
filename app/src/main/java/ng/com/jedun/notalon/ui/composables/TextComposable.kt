package ng.com.jedun.notalon.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ng.com.jedun.notalon.ui.theme.text_normal


@Composable
fun AnnotatedClickableText(text: String, span: String, onSpanClick: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "$text ")
        ClickableText(
            text = AnnotatedString(span),
            onClick = onSpanClick,
            style = TextStyle(color = MaterialTheme.colors.primary, fontSize = text_normal)
        )
    }
}