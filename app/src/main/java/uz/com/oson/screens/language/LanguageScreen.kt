package uz.com.oson.screens.language

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import cafe.adriel.voyager.hilt.getViewModel
import uz.com.oson.R
import uz.com.oson.presenter.LanguageViewmodelImpl
import uz.com.oson.utils.MainContract

class LanguageScreen : Screen {
    @Composable
    override fun Content() {
        val viewmodel = getViewModel<LanguageViewmodelImpl>()
        LanguageContent(
            eventDispatcher = { viewmodel.onEventDispatcher(MainContract.Intent.OpenLogin) },
            languageListener = { language -> viewmodel.saveLanguage(language) }
        )
    }
}

@Composable
fun LanguageContent(
    eventDispatcher: (MainContract.Intent) -> Unit = {},
    languageListener: (String) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0XFFEEECEC))
    ) {

        val fontFamily = FontFamily(
            Font(R.font.gilroy_semibold),
        )

        var selectedLanguage by remember { mutableStateOf("") }

        Image(
            painter = painterResource(R.drawable.vector_oson),
            contentDescription = "oson image",
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.TopCenter)
        )

        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(top = 45.dp)
                .align(Alignment.Center)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .background(Color.White)
            ) {


                Row(
                    modifier = Modifier
                        .padding(vertical = 3.dp)
                        .clickable { selectedLanguage = "uzb" },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_uzb_circle),
                        contentDescription = "icon uzb",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically)
                            .size(34.dp)
                    )
                    Text(
                        text = "O'zbek",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically),
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = fontFamily
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    RadioButton(
                        selected = selectedLanguage == "uzb",
                        onClick = { selectedLanguage = "uzb" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Blue,
                            unselectedColor = Color.Gray
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .clickable { selectedLanguage = "ru" }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_ru),
                        contentDescription = "icon ru",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically)
                            .size(34.dp)
                    )
                    Text(
                        text = "Русский",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically),
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = fontFamily
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    RadioButton(
                        selected = selectedLanguage == "ru",
                        onClick = { selectedLanguage = "ru" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Blue,
                            unselectedColor = Color.Gray
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .clickable { selectedLanguage = "en" },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_usa),
                        contentDescription = "icon en",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically)
                            .size(34.dp)
                    )
                    Text(
                        text = "English",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically),
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = fontFamily
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    RadioButton(
                        selected = selectedLanguage == "en",
                        onClick = { selectedLanguage = "en" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Blue,
                            unselectedColor = Color.Gray
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .clickable { selectedLanguage = "kaz" }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_kaz),
                        contentDescription = "icon kaz",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically)
                            .size(34.dp)
                    )
                    Text(
                        text = "Қазақша",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically),
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = fontFamily
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    RadioButton(
                        selected = selectedLanguage == "kaz",
                        onClick = { selectedLanguage = "kaz" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Blue,
                            unselectedColor = Color.Gray
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .clickable { selectedLanguage = "kar" }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_kar),
                        contentDescription = "icon kar",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically)
                            .size(34.dp)
                    )
                    Text(
                        text = "Karakalpak",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically),
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = fontFamily
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    RadioButton(
                        selected = selectedLanguage == "kar",
                        onClick = { selectedLanguage = "kar" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Blue,
                            unselectedColor = Color.Gray
                        )
                    )
                }
            }
        }

        if (selectedLanguage.isNotEmpty()) {
            Button(
                onClick = {
                    eventDispatcher(MainContract.Intent.OpenLogin)
                    languageListener(selectedLanguage)
                },
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
                    modifier = Modifier,
                    style = TextStyle(
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontFamily = fontFamily
                    )
                )
            }
        }

    }
}

@Composable
@Preview
fun LanguagePreview() {
    LanguageContent()
}