package ng.com.jedun.notalon.ui.composables

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import ng.com.jedun.notalon.ui.theme.notalon_grey


enum class TextSize {
    EXTRA_LARGE, LARGE, MEDIUM, NORMAL, SMALL, EXTRA_SMALL
}

enum class TextColor {
    BLACK, LIGHT_BLACK, WHITE, PRIMARY, HINT
}


@Composable
fun NotalonText(
    text: String, textType: TextSize, textColor: TextColor, modifier: Modifier = Modifier
) {

    var fontSize: TextUnit = 16.sp
    var color: Color = MaterialTheme.colors.onBackground

    when (textType) {
        TextSize.EXTRA_LARGE -> {
            fontSize = 32.sp
        }
        TextSize.EXTRA_SMALL -> {
            fontSize = 12.sp
        }
        TextSize.LARGE -> {
            fontSize = 20.sp
        }
        TextSize.MEDIUM -> {
            fontSize = 18.sp
        }
        TextSize.NORMAL -> {
            fontSize = 16.sp
        }
        TextSize.SMALL -> {
            fontSize = 14.sp
        }
    }


    when (textColor) {
        TextColor.BLACK -> {
            color = MaterialTheme.colors.onBackground
        }
        TextColor.LIGHT_BLACK -> {
            color = notalon_grey
        }

        TextColor.WHITE -> {
            color = Color.White

        }
        TextColor.HINT -> {
            color = notalon_grey
        }
        TextColor.PRIMARY -> {
            color = MaterialTheme.colors.primary
        }
    }

    Text(
        text = text,
        color = color,
        textAlign = TextAlign.Center,
        fontSize = fontSize,
        modifier = modifier
    )
}