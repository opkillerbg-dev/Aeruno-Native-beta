package com.aeruno.nativeprototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aeruno.nativeprototype.ui.topblur.TopBlurTestScreen
import com.aeruno.nativeprototype.ui.theme.AerunoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Light theme: dark status/navigation icons. The default (auto) follows the phone's dark mode,
        // which gave white icons on the cream background.
        val transparent = android.graphics.Color.TRANSPARENT
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(transparent, transparent),
            navigationBarStyle = SystemBarStyle.light(transparent, transparent),
        )
        setContent {
            AerunoTheme {
                // N04: the top-blur test is the only screen. The N02 specimen and the N03 card test stay in
                // the repo, unused. To see N03 again, swap this call for CardTestScreen() (and its import).
                TopBlurTestScreen()
            }
        }
    }
}
