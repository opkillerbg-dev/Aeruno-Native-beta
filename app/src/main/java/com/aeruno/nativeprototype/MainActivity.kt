package com.aeruno.nativeprototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aeruno.nativeprototype.ui.specimen.TypeSpecimenScreen
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
                // N02: the type specimen is the only screen. Prototype ships debug builds only,
                // so this is the debug-only path. N04 replaces it with the Today screen.
                TypeSpecimenScreen()
            }
        }
    }
}
