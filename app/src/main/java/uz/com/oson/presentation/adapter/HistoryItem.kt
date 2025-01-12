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
import uz.com.oson.utils.formatTimestampToDateTime

@Composable
fun HistoryItem(
    modifier: Modifier = Modifier,
    from: String,
    to: String,
    amount: Int,
    time: Long
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
            painter =
            painterResource(R.drawable.ic_card),
            contentDescription = "",
            modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(start = 10.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(10.dp),
            colorFilter = ColorFilter.tint(Color.Blue)
        )


        Column(
            modifier = Modifier
                .padding(10.dp)
                .weight(1f)
                .fillMaxHeight()
        ) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = to,
                    style = TextStyle(fontFamily = font),
                    fontSize = 16.sp,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = formatTimestampToDateTime(time),
                    style = TextStyle(fontFamily = font),
                    fontSize = 16.sp,
                    color = Color.Black,
                )
            }
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = from.substring(0, 6) + "*".repeat(7) + to.substring(13),
                    style = TextStyle(fontFamily = titleFont),
                    fontSize = 16.sp,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = amount.toString(),
                    style = TextStyle(fontFamily = titleFont),
                    fontSize = 20.sp,
                    color = Color.Black,
                )
                Text(
                    text = " UZS",
                    style = TextStyle(fontFamily = titleFont),
                    fontSize = 20.sp,
                    color = Color.Black,
                )
            }
        }

    }
}

@Composable
@Preview
fun HistoryPreview() {
    HistoryItem(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White),
        from = "9860601111111971",
        to = "Someone",
        amount = 12000,
        time = 732600000

    )
}