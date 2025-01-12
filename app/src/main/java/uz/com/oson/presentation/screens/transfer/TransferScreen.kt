package uz.com.oson.presentation.screens.transfer

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import uz.com.oson.presentation.screens.confirmpayment.ConfirmPaymentContract
import uz.com.oson.utils.CardsEnum

class TransferScreen : Screen {
    @Composable
    override fun Content() {
        val viewmodel = getViewModel<TransferViewmodel>()
        TransferContent(viewmodel::onEventDispatcher)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferContent(
    eventDispatcher: (TransferContract.Intentt) -> Unit = {}
) {
    Scaffold(content = {
        val titleFont = FontFamily(
            Font(R.font.gilroy_bold),
        )

        val font = FontFamily(
            Font(R.font.gilroy_medium)
        )

        val fontUzb = FontFamily(
            Font(R.font.gilroy_semibold)
        )

        var cardNumber by remember { mutableStateOf("") }
        var cardAmount by remember { mutableStateOf("") }
        var cardText by remember { mutableStateOf("") }
        var commentState by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .background(Color(0XFFEEECEC))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
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
                            .clickable { }
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
                        colorFilter = ColorFilter.tint(Color.Gray)
                    )
                    Text(
                        text = "Transfer",
                        style = TextStyle(fontFamily = titleFont, fontSize = 18.sp),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Text(
                    text = "Country",
                    style = TextStyle(color = Color.Gray, fontFamily = font, fontSize = 16.sp),
                    modifier = Modifier.padding(top = 30.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(56.dp)
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(16.dp)),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_uzb_circle),
                        contentDescription = "icon uzb",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(36.dp)
                    )

                    Text(
                        text = "Uzbekistan",
                        modifier = Modifier
                            .padding(start = 10.dp),
                        style = TextStyle(color = Color.Black, fontFamily = font, fontSize = 16.sp),
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(R.drawable.ic_down),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(24.dp)
                            .padding(1.dp),
                        colorFilter = ColorFilter.tint(Color.DarkGray)
                    )
                }
                Text(
                    text = "Recipient",
                    style = TextStyle(color = Color.Gray, fontFamily = font, fontSize = 16.sp),
                    modifier = Modifier.padding(top = 40.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .height(48.dp)
                        .border(
                            width = 0.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(32.dp)
                            .background(Color.Blue, shape = CircleShape)
                            .padding(4.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_card),
                            contentDescription = "card icon",
                            modifier = Modifier
                                .size(32.dp)
                                .align(Alignment.Center)
                                .padding(2.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }
                    TextField(
                        value = cardNumber,
                        onValueChange = {
                            if (it.length <= 16)
                                cardNumber = it
                        },
                        placeholder = {
                            Text(
                                text = "Card/phone number",
                                style = TextStyle(
                                    color = Color.LightGray,
                                    fontFamily = font,
                                    fontSize = 14.sp
                                ),
                            )
                        },
                        singleLine = true,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 10.dp),
                        textStyle = TextStyle(color = Color.Black),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        trailingIcon = {
                            if (cardNumber.isNotEmpty()) {
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(CircleShape)
                                        .background(Color.DarkGray)
                                        .clickable(onClick = { cardNumber = "" })
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = "Clear text",
                                        tint = Color.White,
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .padding(5.dp)
                                    )
                                }
                            }
                        }
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_user),
                        contentDescription = "user icon",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(3.dp),
                        colorFilter = ColorFilter.tint(Color(0xff1138F7))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(1.dp)
                            .background(Color.Gray)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Image(
                        painter = painterResource(R.drawable.ic_clock),
                        contentDescription = "user icon",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(24.dp)
                            .padding(3.dp)
                    )
                }
                val textColor =
                    if (cardNumber.isBlank() || cardAmount.isBlank()) {
                        Color.Gray
                    } else {
                        when {
                            cardNumber.length == 16 && cardAmount.toInt() >= 5000 -> Color.Gray
                            cardNumber.length < 16 && cardAmount.toInt() >= 5000 -> Color.Red
                            cardNumber.length == 16 && cardAmount.toInt() < 5000 -> Color.Red
                            else -> Color.Red
                        }
                    }
                val text =
                    if (cardNumber.isBlank() || cardAmount.isBlank()) {
                        "Amount"
                    } else {
                        Log.d("PPPP", "TransferContent: $cardAmount")
                        Log.d("PPPP", "TransferContent: $cardNumber")
                        when {
                            cardNumber.length == 16 && cardAmount.toInt() >= 5000 ->
                                "Amount"

                            cardNumber.length < 16 && cardAmount.toInt() >= 5000 ->
                                "Maximum amount 0"

                            cardNumber.length == 16 && cardAmount.toInt() < 5000 ->
                                "Minimum amount 5 000"

                            else -> "Maximum amount 0"
                        }
                    }
                Text(
                    text = text,
                    style = TextStyle(
                        color = textColor,
                        fontFamily = font,
                        fontSize = 16.sp
                    ),
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
                        value = cardAmount,
                        onValueChange = { input ->
                            cardAmount = input
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
                        placeholder = {
                            Text(
                                text = "5 000 - 10 000 000",
                                style = TextStyle(
                                    color = Color.LightGray,
                                    fontFamily = font,
                                    fontSize = 14.sp
                                ),
                            )
                        },
                        textStyle = TextStyle(
                            if (cardNumber.length >= 9 && cardAmount.toInt() >= 5000) {
                                Color.Black
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
                        ),
                        trailingIcon = {
                            if (cardAmount.isNotEmpty()) {
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(CircleShape)
                                        .background(Color.DarkGray)
                                        .clickable(onClick = { cardAmount = "" })
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = "Clear text",
                                        tint = Color.White,
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .padding(5.dp)
                                    )
                                }
                            }
                        }
                    )
                    Box(
                        modifier = Modifier
                            .height(48.dp)
                            .width(60.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White),
                    ) {
                        Text(
                            text = "UZS",
                            modifier = Modifier.align(Alignment.Center),
                            style = TextStyle(color = Color.Gray, fontSize = 18.sp),
                        )
                    }
                }

                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(if (commentState) Color.Blue else Color.Transparent)
                            .border(
                                width = 2.dp,
                                color = if (commentState) Color.Transparent else Color.Blue,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Checkbox(
                            checked = commentState,
                            onCheckedChange = { commentState = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.Transparent,
                                uncheckedColor = Color.Transparent,
                                checkmarkColor = Color.White
                            )
                        )
                    }
                    Text(
                        text = "Comment",
                        style = TextStyle(color = Color.Gray, fontFamily = font, fontSize = 16.sp),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }

                if (commentState) {
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .height(56.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = cardText,
                            onValueChange = {
                                if (it.length <= 16)
                                    cardText = it
                            },
                            placeholder = {
                                Text(
                                    text = "Text",
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
                                keyboardType = KeyboardType.Text
                            )
                        )
                    }
                }


            }
            if (cardNumber.length == 16 && cardAmount.toInt() >= 5000) {
                Button(
                    onClick = {eventDispatcher(
                        TransferContract.Intentt.OpenConfirmPayment(
                            ConfirmPaymentContract.ConfirmPaymentItems(
                                cardType =
                                if (cardNumber.startsWith("9860")) CardsEnum.HUMO
                                else CardsEnum.UZCARD,
                                recipientName = "Abdurazzoq Xoshimov",
                                recipientCardNumber = cardNumber,
                                amountPayment = cardAmount
                            )
                        )
                    )},
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 5.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .align(Alignment.BottomCenter),
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
                    onClick = {

                    },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 5.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    Text(
                        text = "Next",
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

@Composable
@Preview
fun TransferPreview() {
    TransferContent()
}