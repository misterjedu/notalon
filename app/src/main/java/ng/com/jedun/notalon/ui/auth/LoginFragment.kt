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
import ng.com.jedun.domain.FieldValidator
import ng.com.jedun.notalon.R
import ng.com.jedun.notalon.ui.composables.*
import ng.com.jedun.notalon.ui.theme.NotalonTheme
import ng.com.jedun.notalon.util.validateMultipleTextFields
import ng.com.jedun.notalon.util.validateEmail
import ng.com.jedun.notalon.util.validatePassword

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.findViewById<ComposeView>(R.id.fragment_login_compose_view).setContent {

            var email by rememberSaveable { mutableStateOf(FieldValidator()) }
            var password by rememberSaveable { mutableStateOf(FieldValidator()) }

            var allFieldsValidated by rememberSaveable { mutableStateOf(false) }

            val allFields: Array<FieldValidator> = arrayOf(
                email, password
            )

            validateMultipleTextFields(allFields)

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
                        StandardNavigateUpAppBar(stringResource(R.string.log_in)) {
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
                                    email.message.trim(),
                                    placeholder = "abc@gmail.com",
                                    keyboardType = KeyboardType.Email,
                                    validator = validateEmail(email.message)
                                ) {
                                    email =
                                        if (validateEmail(email.message).isValidated) FieldValidator(
                                            it, true
                                        )
                                        else FieldValidator(it, false)

                                    allFieldsValidated = validateMultipleTextFields(
                                        arrayOf(email, password)
                                    )
                                }

                                //Password
                                SimpleOutlinedTextFieldSample(
                                    "Password",
                                    password.message,
                                    true,
                                    placeholder = "*********",
                                    keyboardType = KeyboardType.Password,
                                    validator = validatePassword(password.message)
                                ) {
                                    password =
                                        if (validatePassword(password.message).isValidated) FieldValidator(
                                            it, true
                                        ) else FieldValidator(it, false)

                                    allFieldsValidated = validateMultipleTextFields(
                                        arrayOf(email, password)
                                    )
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
                                Toast.makeText(
                                    requireContext(),
                                    "Hello",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            buttonType = NotalonButtonType.MATCHPARENT,
                            enabled = allFieldsValidated,
                            text = stringResource(R.string.log_in)
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

