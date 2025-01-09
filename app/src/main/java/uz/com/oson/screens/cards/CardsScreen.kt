package uz.com.oson.screens.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import uz.com.oson.R
import uz.com.oson.presentation.adapter.CardItem
import uz.com.oson.utils.CardsEnum

class CardsScreen : Screen {
    @Composable
    override fun Content() {

    }


    @Composable
    fun CardsContent() {
        Scaffold(content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(Color(0XFFEEECEC)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val fontFamily = FontFamily(
                    Font(R.font.gilroy_semibold),
                )

                Text(
                    text = "All cards",
                    style = TextStyle(
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontFamily = fontFamily,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(top = 16.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(vertical = 10.dp, horizontal = 16.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = Color.White)
                ) {
                    Text(
                        text = "Total balance",
                        style = TextStyle(
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontFamily = fontFamily,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(start = 16.dp, top = 16.dp)
                    )

                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 16.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "0",
                            style = TextStyle(
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontFamily = fontFamily,
                                fontSize = 24.sp
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "UZS",
                            style = TextStyle(
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp
                            )
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_eye),
                        contentDescription = "Image",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 16.dp)
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFD1DEEA))
                            .padding(6.dp),
                        colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Blue)
                    )
                }
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(4) { index ->
                        CardItem(
                            "card${index + 1}",
                            CardsEnum.HUMO,
                            Modifier
                                .height(160.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(
                                    if (index == 0) Color.Blue else
                                        Color(0xFF8D0616)
                                )

                        )
                    }
                }
            }
        },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        // Handle click action here
                    },
                    containerColor = Color.Blue,
                    shape = CircleShape
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "add icon",
                        tint = Color.White
                    )
                }
            }
        )
    }

    @Preview
    @Composable
    fun CardsScreenPreview() {
        CardsContent()
    }
}