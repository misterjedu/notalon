package ng.com.jedun.notalon.ui.composables

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ng.com.jedun.notalon.R

@Composable
fun StandardNavigateUpAppBar(text: String, onNavigateUpIconClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = text)
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = onNavigateUpIconClick) {
                Icon(
                    painter = painterResource(id = R.drawable.navigation_back_arrow),
                    contentDescription = ""
                )
            }
        }
    )
}