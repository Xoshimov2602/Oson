package uz.com.oson.presentation.adapter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.com.oson.R

@Composable
fun MainCardsItem(country : String, modifier: Modifier) {
    Column(
        modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
                .padding(top = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.vector_drawable_new_oson_white),
                contentDescription = "",
                modifier = Modifier
                    .height(20.dp)
                    .width(70.dp)
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_eye),
                contentDescription = ""
            )
            Text(
                text = "0",
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = country,
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 5.dp)
            )
        }
        Spacer(modifier = Modifier.height(6.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(text = "Top up", modifier = Modifier, color = Color.Blue)
        }
    }
}