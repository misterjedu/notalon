package ng.com.jedun.notalon.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import ng.com.jedun.notalon.R
import ng.com.jedun.notalon.ui.composables.SimpleOutlinedTextFieldSample
import ng.com.jedun.notalon.ui.composables.StandardNavigateUpAppBar
import ng.com.jedun.notalon.ui.theme.NotalonTheme

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.findViewById<ComposeView>(R.id.fragment_login_compose_view).setContent {
            NotalonTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    //AppBar
                    StandardNavigateUpAppBar(stringResource(R.string.sign_in)) {
                        findNavController().popBackStack()
                    }

                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        SimpleOutlinedTextFieldSample()
                        SimpleOutlinedTextFieldSample()
                        SimpleOutlinedTextFieldSample()
                    }

                }
            }
        }

        return view
    }

}

