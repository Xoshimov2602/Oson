package uz.com.oson.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import uz.com.oson.R
import uz.com.oson.utils.MainContract

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<LoginViewModelImpl>()
        LoginScreenContent(eventDispatcher = viewModel::onEventDispatcher)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenContent(
    eventDispatcher: (LoginContract.Intent) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFFEEECEC)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Image(
            painter = painterResource(id = R.drawable.vector_oson),
            contentDescription = "Main Image",
            modifier = Modifier
                .padding(top = 80.dp)
                .size(160.dp)
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .weight(6f)
                .padding(top = 60.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 0.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_location),
                    contentDescription = "lock icon",
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = 10.dp)
                        .padding(start = 16.dp)
                        .size(24.dp)
                )

                Image(
                    painter = painterResource(R.drawable.img),
                    contentDescription = "icon uzb",
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 10.dp)
                        .size(24.dp)
                )

                Text(text = "Uzbekistan", modifier = Modifier.padding(start = 10.dp))
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 0.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ),

                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_phone),
                    contentDescription = "phone icon",
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 16.dp)
                        .size(24.dp)
                )

                Text(
                    text = "+998 | ", modifier = Modifier.padding(start = 10.dp), color = Color.Blue
                )
                TextField(
                    value = text,
                    onValueChange = {
                        if (it.length < 10)
                            text = it
                    },
                    placeholder = { Text(text = "00 000 00 00") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    textStyle = TextStyle(color = Color.Black),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 0.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_lock),
                    contentDescription = "lock icon",
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 16.dp)
                        .size(24.dp)
                )

                TextField(
                    value = password,
                    onValueChange = {
                        if (it.length < 9)
                        password = it
                    },
                    placeholder = { Text(text = "Your Password") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    textStyle = TextStyle(color = Color.Black),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            /*
            Row {
                var checked by rememberSaveable { mutableStateOf(false) }
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        if (it) checked = it
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Blue, uncheckedColor = Color.Blue
                    ),
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .clip(if (checked) RoundedCornerShape(3.dp) else RoundedCornerShape(10.dp))

                )
                Text(
                    text = stringResource(R.string.terms),
                    modifier = Modifier.align(Alignment.CenterVertically),
                    color = Color.Black
                )
            }
            */
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Support service",
                modifier = Modifier.padding(bottom = 10.dp),
                style = TextStyle(
                    fontSize = 14.sp, color = Color.Gray
                )
            )
            Text(
                text = "+998 71 207 80 80",
                modifier = Modifier.padding(bottom = 10.dp),
                style = TextStyle(
                    fontSize = 16.sp, color = Color.Gray
                )
            )
            Text(
                text = "V : 4.2.6", modifier = Modifier.padding(bottom = 10.dp), style = TextStyle(
                    fontSize = 16.sp, color = Color.Gray
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, end = 20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Sign Up",
                color = Color.Blue,
                modifier = Modifier.clickable {
                    eventDispatcher(LoginContract.Intent.OnClickSignUp)
                }
            )
        }


            Button(
                enabled = text.length == 9 && password.length == 8,
                onClick = { eventDispatcher(LoginContract.Intent.OnClickNext(phone = text, password = password)) },
                colors = ButtonDefaults.buttonColors(
                    disabledContainerColor = Color.Unspecified,
                    containerColor = Color.Blue
                ),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .padding(horizontal = 16.dp)
                    .height(50.dp),
            ) {
                Text(
                    text = "Next",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }

    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreenContent()
}