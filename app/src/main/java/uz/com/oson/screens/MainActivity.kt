package uz.com.oson.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import dagger.hilt.android.AndroidEntryPoint
import uz.com.oson.screens.language.LanguageScreen
import uz.com.oson.screens.login.LoginScreen
import uz.com.oson.ui.theme.OsonTheme
import uz.gita.lesson56.navigation.AppNavigatorHandler
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigatorHandler: AppNavigatorHandler
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OsonTheme {
                BottomSheetNavigator{
                    Navigator(LanguageScreen()) { navigator : Navigator ->
                        LaunchedEffect(key1 = navigator) {
                            navigatorHandler.navigation.collect{
                                it(navigator)
                            }
                        }
                        CurrentScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun RoundedPlaceholder(number : String) {
    Text(
        text = number,
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .height(60.dp)
            .width(46.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
    )
}

@Composable
fun RoundedPinPlaceholder() {
    Text(
        text = "",
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .height(60.dp)
            .width(60.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
    )
}
