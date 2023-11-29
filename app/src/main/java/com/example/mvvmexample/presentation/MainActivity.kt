package com.example.mvvmexample.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvvmexample.presentation.list.ListScreen
import com.example.mvvmexample.presentation.ui.theme.MVVMExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // Annotacja oznaczająca klase setupu ("wejściową") dla Hilta
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMExampleTheme {
                ListScreen()
            }
        }
    }
}
