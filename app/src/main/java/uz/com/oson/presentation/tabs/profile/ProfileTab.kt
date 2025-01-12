package uz.com.oson.presentation.tabs.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.com.oson.R

object ProfileTab : Tab {
    override val options: TabOptions
        @Composable get() {
            val title = "Profile"
            val icon = painterResource(id = R.drawable.ic_user)
            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        ProfileContent()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileContent () {
    Scaffold(content = {
        Column (modifier = Modifier.fillMaxSize().background(Color.Magenta)) { }
    })
}

@Composable
@Preview
fun ProfilePreview () {
    ProfileContent()
}