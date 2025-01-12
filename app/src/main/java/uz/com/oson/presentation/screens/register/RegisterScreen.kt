package uz.com.oson.presentation.screens.register

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
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
import uz.com.oson.presentation.screens.register.components.DatePickerComponent
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale


class RegisterScreen : Screen {
    @Composable
    override fun Content() {
        val viewmodel = getViewModel<RegisterViewModelImpl>()
        RegisterScreenContent(viewmodel::onEventDispatcher)
    }
}

@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreenContent(
    eventDispatcher: (RegisterContract.Intent) -> Unit = {}
) {
    var showDatePicker by remember { mutableStateOf(false) }
    var birthDay by remember { mutableStateOf("") }
    var bornDate : Long = 0
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0XFFEEECEC)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var phone by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var name by remember { mutableStateOf("") }
        var lastName by remember { mutableStateOf("") }

        Image(
            painter = painterResource(id = R.drawable.vector_oson),
            contentDescription = "Main Image",
            modifier = Modifier
                .padding(top = 80.dp)
                .size(160.dp)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp)),

            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_name),
                contentDescription = "name icon",
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 16.dp)
                    .size(24.dp),
                colorFilter = ColorFilter.tint(Color(0xff1e68fe))
            )

            TextField(
                value = name,
                onValueChange = { newValue ->
                    name = newValue
                },
                placeholder = { Text(text = "Your Name", style = TextStyle(fontSize = 14.sp)) },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                textStyle = TextStyle(color = Color.Black, fontSize = 14.sp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp)),

            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_name),
                contentDescription = "lastname icon",
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 16.dp)
                    .size(24.dp),
                colorFilter = ColorFilter.tint(Color(0xff1e68fe))
            )

            TextField(
                value = lastName,
                onValueChange = { newValue ->
                    lastName = newValue
                },
                placeholder = {
                    Text(
                        text = "Your Last Name",
                        style = TextStyle(fontSize = 14.sp)
                    )
                },
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

        Row(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp))
                .clickable {
                    showDatePicker = true
                },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_birthday),
                contentDescription = "birthday icon",
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 16.dp)
                    .size(24.dp),
                colorFilter = ColorFilter.tint(Color(0xff1e68fe))
            )
            Text(
                text = if (birthDay.isNotBlank()) birthDay else "Your Birthday",
                modifier = Modifier.padding(start = 16.dp),
                style = TextStyle(fontSize = 14.sp, color = Color.Black)
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp)),

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
                value = phone,
                onValueChange = { newValue ->
                    phone = newValue
                },
                placeholder = { Text(text = "00 000 00 00", style = TextStyle(fontSize = 14.sp)) },
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

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp)),

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
                onValueChange = { newValue ->
                    password = newValue
                },
                placeholder = { Text(text = "Your Password", style = TextStyle(fontSize = 14.sp)) },
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

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, end = 20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Sign In",
                color = Color.Blue,
                modifier = Modifier.clickable {
                    eventDispatcher(RegisterContract.Intent.OpenLogin)
                }
            )
        }

        if (birthDay.isNotBlank() && name.isNotBlank() && lastName.isNotBlank() && phone.isNotBlank() && password.isNotBlank()) {
            Button(
                onClick = {
                    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    val date = LocalDate.parse(birthDay, formatter)
                    val timestamp = date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
                    Log.d("MMMMM", "RegisterScreenContent: $timestamp")

                    eventDispatcher(RegisterContract.Intent.OpenVerify(
                    RegisterContract.RegisterBundle(
                        name = name,
                        lastName = lastName,
                        birthDate = bornDate.toString(),
                        phone = phone,
                        password = password
                    )
                )) },
                colors = ButtonDefaults.buttonColors(
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
        } else {
            Button(
                onClick = { },
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
    if (showDatePicker) {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        DatePickerComponent(
            onDateSelected = {
                if (it != null) {
                    bornDate = it
                }
                if (it != null){
                    birthDay = formatter.format(it)
                    showDatePicker = false
                }
            },
            onDismiss = { showDatePicker = false }
        )
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    RegisterScreenContent()
}