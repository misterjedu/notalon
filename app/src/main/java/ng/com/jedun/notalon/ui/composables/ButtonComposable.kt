package ng.com.jedun.notalon.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ng.com.jedun.notalon.ui.theme.NotalonTheme


enum class NotalonButtonType {
    MATCHPARENT, WRAPCONTENT
}

@Composable
fun NotalonButton(
    onClick: () -> Unit,
    buttonType: NotalonButtonType = NotalonButtonType.MATCHPARENT,
    enabled: Boolean = true,
    text: String,
) {

    var modifier: Modifier = Modifier
    if (buttonType == NotalonButtonType.MATCHPARENT) {
        modifier = Modifier
            .fillMaxWidth()
    }

    val colors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.primary
    )

    Button(
        onClick = onClick,
        enabled = enabled,
        colors = colors,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium
    )
    {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 10.dp),
            style = MaterialTheme.typography.button,
        )
    }
}

