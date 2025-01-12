package uz.com.oson.presentation.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
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
import cafe.adriel.voyager.core.screen.Screen
import uz.com.oson.R
import uz.com.oson.utils.CardsEnum


class AddCardBottomSheet : Screen {
    var onDismiss: () -> Unit = {}
    var onSelected: (card: CardsEnum) -> Unit = {}

    @Composable
    override fun Content() {
        BottomSheetContent(onDismiss, onSelected)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetContent(onDismiss: () -> Unit = {}, onSelected: (CardsEnum) -> Unit = {}) {
    val fontFamily = FontFamily(
        Font(R.font.gilroy_bold),
    )

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        contentColor = Color.White,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Choose type",
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = fontFamily,
                        fontSize = 18.sp
                    )
                )
                Button(
                    onClick = {onSelected(CardsEnum.UZCARD)},
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF053B79)
                    ),

                    ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "UZCARD",
                            style = TextStyle(
                                Color.White,
                                fontFamily = fontFamily,
                                fontSize = 16.sp
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(R.drawable.ic_uzcard),
                            contentDescription = "uzcard",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
                Button(
                    onClick = {onSelected(CardsEnum.HUMO)},
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff043927)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "HUMO",
                            style = TextStyle(
                                Color.White,
                                fontFamily = fontFamily,
                                fontSize = 16.sp
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(R.drawable.ic_humo),
                            contentDescription = "humo",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.height(200.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun BottomSheetPreview() {
    BottomSheetContent()
}