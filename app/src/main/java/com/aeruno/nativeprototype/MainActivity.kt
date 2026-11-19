package com.aeruno.nativeprototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aeruno.nativeprototype.ui.specimen.TypeSpecimenScreen
import com.aeruno.nativeprototype.ui.theme.AerunoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AerunoTheme {
                // N02: the type specimen is the only screen. Prototype ships debug builds only,
                // so this is the debug-only path. N04 replaces it with the Today screen.
                TypeSpecimenScreen()
            }
        }
    }
}
