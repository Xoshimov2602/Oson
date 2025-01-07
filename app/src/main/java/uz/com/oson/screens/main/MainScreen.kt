package uz.com.oson.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import uz.com.oson.R

class MainScreen : Screen {
    @Composable
    override fun Content() {
        MainScreenContent()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        var searchText by remember { mutableStateOf("") }
        var isActive by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        ) {
            SearchBar(
                query = searchText,
                onQueryChange = { searchText = it },
                onSearch = {},
                active = isActive,
                onActiveChange = { isActive = it },
                placeholder = { Text("Search...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
                trailingIcon = {
                    if (searchText.isNotEmpty()) {
                        IconButton(onClick = { searchText = "" }) {
                            Icon(Icons.Default.Close, contentDescription = "Close Icon")
                        }
                    }
                }
            ) {
                Text("Search here")
            }
            Image(
                painter = painterResource(id = R.drawable.ic_noticifation),
                contentDescription = "Notification Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp, 56.dp)
                    .padding(top = 10.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .background(Color.White)
            )
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreenContent()
}