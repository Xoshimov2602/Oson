package uz.com.oson.presentation.adapter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.com.oson.R
import uz.com.oson.utils.CardsEnum

@Composable
fun PaymentCardItem(
    name: String,
    cardNumber: String,
    card: CardsEnum,
    amount : String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
    ) {
        val titleFont = FontFamily(
            Font(R.font.gilroy_bold),
        )
        val font = FontFamily(
            Font(R.font.gilroy_medium),
        )

        Image(
            painter = when (card) {
                CardsEnum.UZCARD -> painterResource(R.drawable.ic_uzcard)
                CardsEnum.HUMO -> painterResource(R.drawable.ic_humo)
            },
            contentDescription = "",
            modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(start = 10.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(10.dp),
            colorFilter = (if (card == CardsEnum.UZCARD) Color.Blue else null)?.let {
                ColorFilter.tint(it)
            }
        )


        Column(
            modifier = Modifier
                .padding(10.dp)
                .weight(1f)
                .fillMaxHeight()
        ) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = name,
                    style = TextStyle(fontFamily = font),
                    fontSize = 16.sp,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "**** ${cardNumber.substring(cardNumber.length - 4)}",
                    style = TextStyle(fontFamily = font),
                    fontSize = 16.sp,
                    color = Color.White,
                )
            }
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = amount,
                    style = TextStyle(fontFamily = titleFont),
                    fontSize = 20.sp,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "UZS",
                    style = TextStyle(fontFamily = titleFont),
                    fontSize = 18.sp,
                    color = Color.White,
                )
            }
        }

    }
}

@Composable
@Preview
fun PaymentCardPreview() {
    PaymentCardItem(
        "abdurazzoq\'s", "7894564545681971", CardsEnum.HUMO, "", modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(
                Color.Blue
            )
    )
}