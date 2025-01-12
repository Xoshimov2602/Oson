package uz.com.oson.presentation.tabs.scanner

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
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.com.oson.R

object ScannerTab : Tab {
    override val options: TabOptions
        @Composable get() {
            val title = ""
            val icon = painterResource(id = R.drawable.ic_scanner)
            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun Content() {
        Scaffold(content = {
            Column (modifier = Modifier.fillMaxSize().background(Color.Unspecified)) { }
        })
    }
}

@Composable
fun ScannerContent (){

}