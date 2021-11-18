package com.example.refactorsistecreditodiseocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import com.example.refactorsistecreditodiseocompose.OnBoarding.onBoarding
import com.example.refactorsistecreditodiseocompose.Presentacion.NavigationHost
import com.example.refactorsistecreditodiseocompose.ui.theme.RefactorTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RefactorTheme() {
                window.statusBarColor= MaterialTheme.colors.background.toArgb()
                window.navigationBarColor= MaterialTheme.colors.background.toArgb()

                Surface(color = MaterialTheme.colors.background,modifier = Modifier.fillMaxSize()) {
                    NavigationHost()
                }

                }
        }
    }
}