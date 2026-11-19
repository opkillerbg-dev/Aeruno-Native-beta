package com.aeruno.nativeprototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aeruno.nativeprototype.ui.cardtest.CardTestScreen
import com.aeruno.nativeprototype.ui.theme.AerunoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Light theme: dark status/navigation icons. The default (auto) follows the phone's dark mode,
        // which gave white icons on the cream background.
        val transparent = android.graphics.Color.TRANSPARENT
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(transparent, transparent),
            // N03: the card-test background ends in deep forest, so the navigation bar gets light icons.
            navigationBarStyle = SystemBarStyle.dark(transparent),
        )
        setContent {
            AerunoTheme {
                // N03: the card test is the only screen (the N02 type specimen stays in the repo,
                // unused). Prototype ships debug builds only. N04 replaces this with the Today screen.
                CardTestScreen()
            }
        }
    }
}
