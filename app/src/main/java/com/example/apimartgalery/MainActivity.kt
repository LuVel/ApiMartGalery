package com.example.apimartgalery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apimartgalery.ui.screens.MarsViewModel
import com.example.apimartgalery.ui.theme.ApiMartGaleryTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ApiMartGaleryTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    val viewModel: MarsViewModel = viewModel()
                    MarsScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun MarsScreen(
    viewModel: MarsViewModel,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        viewModel.getMarsPhotos()
    }

    val photos = viewModel.marsPhotos

    Text(
        text = "Fotos: ${photos.size}",
        modifier = modifier
    )
}