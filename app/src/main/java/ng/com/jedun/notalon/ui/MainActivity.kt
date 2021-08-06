package ng.com.jedun.notalon.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ng.com.jedun.notalon.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = layoutInflater.inflate(R.layout.activity_main, null)
        setContentView(view)
    }
}