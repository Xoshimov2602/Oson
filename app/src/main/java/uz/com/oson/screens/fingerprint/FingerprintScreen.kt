package uz.com.oson.screens.fingerprint

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import uz.com.oson.R
import uz.com.oson.presenter.FingerprintViewModelImpl


class FingerprintScreen : Screen{
    @Composable
    override fun Content() {
        val viewModel = getViewModel<FingerprintViewModelImpl>()
        FingerprintComponent{viewModel.openMain()}
    }

}

@Composable
fun FingerprintComponent(onButtonClick : () -> Unit = {}) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            Row(
                modifier = Modifier.padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Fingerprint",
                    modifier = Modifier,
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(R.drawable.img_face),
                    contentDescription = "clear",
                    modifier = Modifier
                        .size(150.dp),
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Secure with a fingerprint or Face ID scanner",
                    modifier = Modifier.padding(horizontal = 17.dp),
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(0.5f))

                Text(
                    text = "To avoid entering a PIN code every single time, you can enable login with a fingerprint a Face ID scanner",
                    modifier = Modifier.padding(horizontal = 17.dp),
                    color = Color.Gray,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Row() {
                Button(
                    onClick = {
//                navigator.navigate(Screens.CODE)
                        onButtonClick
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .height(50.dp)
                        .weight(1f)
                        .padding(start = 16.dp)
                        .padding(end = 8.dp)
                        .border(
                            width = 2.dp,
                            color = Color.Blue,
                            shape = RoundedCornerShape(26.dp)
                        ),
                ) {
                    Text(
                        text = "Skip",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Blue,
                        textAlign = TextAlign.Center,
                    )
                }
                Button(
                    onClick = onButtonClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue
                    ),
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .height(50.dp)
                        .weight(1f)
                        .padding(end = 16.dp)
                        .padding(start = 8.dp),
                ) {
                    Text(
                        text = "Yes",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun FingerPrintPreview () {
    FingerprintComponent()
}