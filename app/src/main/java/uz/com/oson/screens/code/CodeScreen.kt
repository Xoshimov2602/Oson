package uz.com.oson.screens.code

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import uz.com.oson.presenter.CodeViewModelImpl
import uz.com.oson.screens.RoundedPlaceholder


class CodeScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel =getViewModel<CodeViewModelImpl>()
        CodeScreenContent({ viewModel.openPinCode() })
    }
}


@Composable
fun CodeScreenContent(
    onClickButton : () -> Unit = {},
    onBackClick : () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFFEEECEC))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back icon",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(30.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(Color.White)
                        .padding(start = 8.dp)
                        .padding(3.dp)
                        .clickable {
                            onBackClick
                        },
                    contentScale = ContentScale.Inside
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Confirmation code",
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
                Spacer(modifier = Modifier.width(50.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(6) {
                    RoundedPlaceholder()
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "1",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(top = 15.dp),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "2",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(top = 15.dp),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        lineHeight = 70.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "3",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(top = 15.dp),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "4",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(top = 15.dp),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "5",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(top = 15.dp),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        lineHeight = 70.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "6",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(top = 15.dp),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "7",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(top = 15.dp),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "8",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(top = 15.dp),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        lineHeight = 70.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "9",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(top = 15.dp),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "",
                    modifier = Modifier
                        .size(70.dp),
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "0",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White)
                        .padding(top = 15.dp),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        lineHeight = 70.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(R.drawable.ic_clear),
                    contentDescription = "clear",
                    modifier = Modifier
                        .size(70.dp)
                        .padding(16.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .padding(top = 15.dp)
                        .background(Color.Transparent),
                )

                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.weight(0.5f))
        }

        Button(
            onClick = onClickButton,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(50.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp),
        ) {
            Text(
                text = "Next",
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
private fun CodeScreenPreview() {
    CodeScreenContent()
}
