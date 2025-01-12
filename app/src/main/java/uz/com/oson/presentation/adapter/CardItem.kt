package uz.com.oson.presentation.adapter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun CardItem(
    name: String,
    card: CardsEnum,
    modifier: Modifier = Modifier,
    expiredYear: String,
    expiredMonths: String,
    pan: String,
    amount : String
) {
    Column(
        modifier
    ) {
        val fontFamily = FontFamily(
            Font(R.font.gilroy_semibold),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                modifier = Modifier
                    .height(20.dp)
                    .width(70.dp),
                style = TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(R.drawable.ic_humo),
                contentDescription = "humo icon",
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(40.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_eye),
                contentDescription = ""
            )
            Text(
                text = amount,
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp),
                style = TextStyle(fontFamily = fontFamily)
            )
            Text(
                text = "UZS",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 5.dp),
                style = TextStyle(fontFamily = fontFamily)
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
        ) {
            Text(text = "**** ${pan.takeLast(4)}", modifier = Modifier, color = Color.White)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "$expiredMonths/$expiredYear", style = TextStyle(Color.White))
        }
    }
}


@Preview
@Composable
fun CardPreview() {
    CardItem("main", CardsEnum.HUMO, expiredYear =  "", expiredMonths =  "", pan =  "", amount = "12000")
}