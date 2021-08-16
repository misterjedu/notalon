package ng.com.jedun.notalon.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import ng.com.jedun.notalon.R
import ng.com.jedun.notalon.domain.FieldValidator
import ng.com.jedun.notalon.ui.composables.StandardNavigateUpAppBar
import ng.com.jedun.notalon.ui.theme.NotalonTheme


class EmailVerificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_email_verification, container, false)

        view.findViewById<ComposeView>(R.id.fragment_email_verification_compose_view).setContent {

            NotalonTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        //AppBar
                        StandardNavigateUpAppBar(stringResource(R.string.email_verification)) {
                            findNavController().popBackStack()
                        }

                        Column(
                            modifier = Modifier.padding(20.dp),
                        ) {
                            CenterText()
                        }

                    }
                }
            }
        }
        return view
    }


}

@Preview(showBackground = true)
@Composable
fun CenterText() {

//    var otpData = mutableListOf("")
    var otpSize = 5
    val otp by remember { mutableStateOf(MutableList(otpSize) { "" }) }
    val otpHash: MutableMap<Int, String> = mutableMapOf()

    Row {
        for (index in 0 until otpSize) {
            otpHash[index] = ""
            SinglePinView(otp[index]) {
                otpHash[index] = it
            }
        }
    }
}

@Composable
fun SinglePinView(data: String, onValueChange: (String) -> Unit) {

    Box(
        modifier = Modifier
            .padding(10.dp)
            .background(Color.White)
            .border(
                2.dp,
                Color.Green,
                RoundedCornerShape(5.dp)
            )
            .height(50.dp)
            .width(50.dp),
    ) {
        TextField(
            value = data,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            )
        )
    }

}