package uz.com.oson.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import uz.com.oson.R
import javax.inject.Inject



class Splash : Screen {
    @Composable
    override fun Content() {
        val viewmodel = getViewModel<SplashViewmodel>()
        SplashContent(viewmodel::onEventDispatcher)
    }
}

@Composable
fun SplashContent(eventDispatcher : () -> Unit = {} ) {
    Scaffold(content = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color(0XFFEEECEC))
        ) {
            Image(
                painter = painterResource(R.drawable.vector_oson),
                contentDescription = "oson image",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(200.dp)
            )
        }
        eventDispatcher()
    })
}

@Composable
@Preview
fun SplashPreview() {
    SplashContent()
}