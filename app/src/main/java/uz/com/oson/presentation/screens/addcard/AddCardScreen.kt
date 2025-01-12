package uz.com.oson.presentation.screens.addcard

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import uz.com.oson.R
import uz.com.oson.domain.remote.request.card.AddCardRequest

class AddCardScreen : Screen {
    @Composable
    override fun Content() {
        val viewmodel = getViewModel<AddCardViewmodel>()
        AddCardContent(eventDispatcher = viewmodel::onEventDispatcher)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCardContent(
    eventDispatcher: (AddCardContract.Intent) -> Unit = {}
) {
    Scaffold(content = {
        val titleFont = FontFamily(
            Font(R.font.gilroy_bold),
        )

        val font = FontFamily(
            Font(R.font.gilroy_medium)
        )

        var cardNumber by remember { mutableStateOf("") }
        var cardDate by remember { mutableStateOf("") }
        var cardName by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color(0XFFEEECEC))
                .padding(horizontal = 16.dp)
                .imePadding(),
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "back",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .clickable {
                            eventDispatcher(
                                AddCardContract.Intent.MoveBack
                            )
                        }
                        .padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
                    colorFilter = ColorFilter.tint(Color.Gray)
                )
                Text(
                    text = "Add new card",
                    style = TextStyle(fontFamily = titleFont, fontSize = 18.sp),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Text(
                text = "Card Number",
                style = TextStyle(color = Color.Gray, fontFamily = font, fontSize = 16.sp),
                modifier = Modifier.padding(top = 30.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(56.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = cardNumber,
                    onValueChange = {
                        if (it.length <= 16)
                            cardNumber = it
                    },
                    placeholder = {
                        Text(
                            text = "0000 0000 0000 0000",
                            style = TextStyle(
                                color = Color.LightGray,
                                fontFamily = font,
                                fontSize = 16.sp
                            ),
                        )
                    },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp)
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .height(48.dp)
                        .border(
                            width = 0.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    textStyle = TextStyle(color = Color.Black),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_scanner),
                        contentDescription = "scanner",
                        modifier = Modifier
                            .size(40.dp)
                            .padding(8.dp),
                        colorFilter = ColorFilter.tint(Color.Blue)
                    )
                }
            }
            Text(
                text = "Expiration Date",
                style = TextStyle(color = Color.Gray, fontFamily = font, fontSize = 16.sp),
                modifier = Modifier.padding(top = 40.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Log.d("KLKLKLLLKL", "AddCardContent: $cardDate")
                TextField(
                    value = cardDate,
                    onValueChange = { input ->

                        val digitsOnly = input.replace("/", "")
                        if (digitsOnly.length <= 4) {
                            cardDate = when (digitsOnly.length) {
                                in 3..4 -> digitsOnly.substring(
                                    0,
                                    2
                                ) + "/" + digitsOnly.substring(2)

                                else -> digitsOnly
                            }
                        }
                    },
                    placeholder = {
                        Text(
                            text = "12/34",
                            style = TextStyle(
                                color = Color.LightGray,
                                fontFamily = font,
                                fontSize = 16.sp
                            ),
                        )
                    },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp)
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .height(48.dp)
                        .border(
                            width = 0.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    textStyle = TextStyle(
                        color =
                        if (cardDate.length == 5) {
                            if (cardDate.substring(0, 2).toInt() <= 12 && cardDate.substring(0, 2)
                                    .toInt() < 25
                            )
                                Color.Black
                            else Color.Red
                        } else Color.Red
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
            }
            Text(
                text = "Card Name",
                style = TextStyle(color = Color.Gray, fontFamily = font, fontSize = 16.sp),
                modifier = Modifier.padding(top = 40.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = cardName,
                    onValueChange = { input ->
                        cardName = input
                    },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp)
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .height(48.dp)
                        .border(
                            width = 0.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    textStyle = TextStyle(color = Color.Black),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            if (cardDate.length == 5 && cardNumber.length == 16 && cardName.isNotBlank()) {
                Button(
                    onClick = {
                        eventDispatcher(
                            AddCardContract.Intent.AddCard(
                                AddCardRequest(
                                    pan = cardNumber,
                                    expiredYear = "20${cardDate.split("/")[1]}",
                                    expiredMonth = cardDate.split("/")[0],
                                    name = cardName
                                )
                            )
                        )
                    },
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text(
                        text = "Continue",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = titleFont,
                            fontSize = 18.sp
                        )
                    )
                }
            } else {

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text(
                        text = "Continue",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = titleFont,
                            fontSize = 18.sp
                        )
                    )
                }
            }
        }
    })
}

@Preview
@Composable
fun AddCardPreview() {
    AddCardContent()
}