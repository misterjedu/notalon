package ng.com.jedun.notalon.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ng.com.jedun.notalon.R
import ng.com.jedun.notalon.ui.composables.*
import ng.com.jedun.notalon.ui.theme.NotalonTheme
import ng.com.jedun.notalon.ui.theme.text_normal

class WalkThroughFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_walkthrough, container, false)
        view.findViewById<ComposeView>(R.id.fragment_walk_through_compose_view).setContent {

            NotalonTheme {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight(0.7f)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            val image: Painter =
                                painterResource(id = R.drawable.walkthrough_img_holder)
                            Image(
                                painter = image,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(vertical = 20.dp)
                                    .fillMaxHeight(0.7f),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = stringResource(R.string.walk_through_text),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 20.dp),
                            )
                        }
                    }

                    Row {
                        Column {
                            NotalonButton(
                                onClick = { findNavController().navigate(R.id.signupFragment) },
                                buttonType = NotalonButtonType.MATCHPARENT,
                                text = stringResource(R.string.get_started)
                            )

                            ClickableText(
                                text = AnnotatedString(stringResource(R.string.log_in)),
                                onClick = { findNavController().navigate(R.id.loginFragment) },
                                style = TextStyle(
                                    color = MaterialTheme.colors.primary,
                                    fontSize = text_normal,
                                    textAlign = TextAlign.Center,
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 20.dp),
                            )
                        }
                    }
                }
            }
        }
        return view
    }


    private fun navigateToLoginFragment() {
        findNavController().navigate(R.id.loginFragment)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}