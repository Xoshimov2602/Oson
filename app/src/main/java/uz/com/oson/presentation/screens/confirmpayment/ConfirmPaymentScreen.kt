package uz.com.oson.presentation.screens.confirmpayment

import android.annotation.SuppressLint
import android.os.Parcelable
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import kotlinx.android.parcel.Parcelize
import uz.com.oson.R
import uz.com.oson.domain.remote.request.transfer.TransferRequest
import uz.com.oson.domain.remote.response.card.GetCardsResponse
import uz.com.oson.presentation.adapter.PaymentCardItem
import uz.com.oson.utils.CardsEnum

@Parcelize
class ConfirmPaymentScreen(private val items: ConfirmPaymentContract.ConfirmPaymentItems) : Screen,
    Parcelable {
    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    override fun Content() {
        val viewModel = getViewModel<ConfirmPaymentViewmodel>()
        viewModel.onEventDispatcher(ConfirmPaymentContract.Intent.GetCards)
        ConfirmPaymentContent(
            items,
            eventDispatcher = viewModel::onEventDispatcher,
            cards = viewModel.uiState.value.allCards
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ConfirmPaymentContent(
    items: ConfirmPaymentContract.ConfirmPaymentItems,
    eventDispatcher: (ConfirmPaymentContract.Intent) -> Unit = {},
    cards: List<GetCardsResponse> = emptyList()
) {
    Scaffold(content = {
        val titleFont = FontFamily(
            Font(R.font.gilroy_bold),
        )
        Log.d("ZZZZZZZZ", "list in screen: ${cards.size}")
        val pagerState = rememberPagerState(pageCount = {
            cards.size
        })

        val font = FontFamily(
            Font(R.font.gilroy_medium)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color(0XFFEEECEC))
                .padding(horizontal = 16.dp)
                .imePadding()
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
                        .size(36.dp)
                        .clip(CircleShape)
                        .clickable { }
                        .background(Color.White)
                        .padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
                    colorFilter = ColorFilter.tint(Color.Gray)
                )
                Text(
                    text = "Payment confirmation",
                    style = TextStyle(fontFamily = titleFont, fontSize = 18.sp),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(vertical = 10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        id =
                        when (items.cardType) {
                            CardsEnum.HUMO -> {
                                R.drawable.ic_humo
                            }

                            CardsEnum.UZCARD -> {
                                R.drawable.ic_uzcard
                            }
                        }
                    ),
                    contentDescription = "eye Icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(36.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFC0BFBF))
                        .padding(5.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Transfer to card",
                    style = TextStyle(
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontFamily = font,
                        fontSize = 16.sp
                    )
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Recipient",
                    style = TextStyle(fontFamily = font),
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = items.recipientName,
                    style = TextStyle(fontFamily = font),
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = "Recipient Card",
                    style = TextStyle(fontFamily = font),
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = items.recipientCardNumber.substring(0, 6) +
                            "*".repeat(12 - 6) +
                            items.recipientCardNumber.substring(12),
                    style = TextStyle(fontFamily = font),
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = "Amount to be received",
                    style = TextStyle(fontFamily = font),
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "${items.amountPayment} UZS",
                    style = TextStyle(fontFamily = font),
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = "Commission 1.0%",
                    style = TextStyle(fontFamily = font),
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "${((items.amountPayment.toDouble()) / 100)} UZS",
                    style = TextStyle(fontFamily = font),
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = "Total amount",
                    style = TextStyle(fontFamily = font),
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "${items.amountPayment.toInt() + ((items.amountPayment.toInt()) / 100)} UZS",
                    style = TextStyle(fontFamily = font),
                    fontSize = 20.sp,
                    color = Color.Blue,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Transfer limit without commission",
                        style = TextStyle(color = Color.Gray, fontFamily = font, fontSize = 12.sp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "0 UZS",
                        style = TextStyle(fontFamily = font),
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(end = 10.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_question_mark),
                        contentDescription = "question mark",
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color.DarkGray)
                            .padding(5.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color.LightGray)
                ) {

                }
            }
            Spacer(modifier = Modifier.weight(1f))


            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
            ) { pager ->
                cards[pager].isVisible = true
                PaymentCardItem(
                    name = cards[pager].name,
                    cardNumber = cards[pager].pan,
                    items.cardType,
                    amount = cards[pager].amount.toString(),
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(if (pager == 0) Color.Blue else Color(0xFF8D0616))
                )
            }

            Button(
                onClick = {
                    eventDispatcher(
                        ConfirmPaymentContract.Intent.OnClickNext(
                            TransferRequest(
                                "third-card",
                                senderId = cards[pagerState.currentPage].id.toString(),
                                receiverPan = items.recipientCardNumber,
                                amount = items.amountPayment.toInt()
                            )
                        )
                    )
                },
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(
                    text = "Pay",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = titleFont,
                        fontSize = 18.sp
                    )
                )
            }
        }
    })
}

@Composable
@Preview
fun ConfirmPaymentPreview() {
    ConfirmPaymentContent(
        ConfirmPaymentContract.ConfirmPaymentItems(
            CardsEnum.HUMO,
            "Abdurazzoq",
            "9860600404101971",
            "10000"
        )
    )
}