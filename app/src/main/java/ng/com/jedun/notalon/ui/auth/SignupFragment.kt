package ng.com.jedun.notalon.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import ng.com.jedun.notalon.R
import ng.com.jedun.notalon.ui.composables.*
import ng.com.jedun.notalon.ui.theme.NotalonTheme
import ng.com.jedun.notalon.util.*


class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signup, container, false)

        view.findViewById<ComposeView>(R.id.fragment_signup_compose_view).setContent {
            var email by rememberSaveable { mutableStateOf("") }
            var name by rememberSaveable { mutableStateOf("") }
            var username by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            var phoneNumber by rememberSaveable { mutableStateOf("") }


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
                        StandardNavigateUpAppBar(stringResource(R.string.sign_up)) {
                            findNavController().popBackStack()
                        }

                        Column(
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column(
                                modifier = Modifier.padding(20.dp),
                            ) {

                                //Email
                                SimpleOutlinedTextFieldSample(
                                    "Email",
                                    email,
                                    placeholder = "abc@gmail.com",
                                    keyboardType = KeyboardType.Email,
                                    validator = validateEmail(email)
                                ) {
                                    email = it
                                }

                                //Full name
                                SimpleOutlinedTextFieldSample(
                                    "Full name",
                                    name,
                                    placeholder = "Ada Moyo",
                                    keyboardType = KeyboardType.Text,
                                    validator = validateFullName(name)
                                ) {
                                    name = it
                                }

                                //Username
                                SimpleOutlinedTextFieldSample(
                                    "Username",
                                    username,
                                    placeholder = "adayo",
                                    keyboardType = KeyboardType.Text,
                                    validator = validateUserName(username)
                                ) {
                                    username = it
                                }

                                //Password
                                SimpleOutlinedTextFieldSample(
                                    "Password",
                                    password,
                                    true,
                                    placeholder = "********",
                                    keyboardType = KeyboardType.Password,
                                    validator = validatePassword(password)
                                ) {
                                    password = it
                                }

                                //Phone Number
                                SimpleOutlinedTextFieldSample(
                                    "Phone number",
                                    phoneNumber,
                                    placeholder = "08012345678",
                                    keyboardType = KeyboardType.Phone,
                                    validator = validatePhoneNumber(phoneNumber)
                                ) {
                                    phoneNumber = it
                                }

                                //Forgot password
                                Text(
                                    text = stringResource(R.string.forgot_password),
                                    textAlign = TextAlign.End,
                                    style = MaterialTheme.typography.body1,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 10.dp),
                                )
                            }
                        }
                    }


                    Column(modifier = Modifier.padding(20.dp)) {

                        NotalonButton(
                            onClick = {
                                findNavController().navigate(R.id.emailVerificationFragment)
                            },
                            buttonType = NotalonButtonType.MATCHPARENT,
                            text = stringResource(R.string.sign_up)
                        )

                        AnnotatedClickableText(
                            stringResource(id = R.string.dont_have_account_sign_up),
                            stringResource(id = R.string.sign_up),
                        ) {
                            Toast.makeText(requireContext(), "Span", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }


        }

        return view
    }


}