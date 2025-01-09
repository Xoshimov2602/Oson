package uz.com.oson.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import uz.com.oson.R
import uz.com.oson.presentation.adapter.MainCardsItem
import kotlin.math.absoluteValue

class MainScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<MainViewModelImpl>()
        MainScreenContent(
            eventDispatcher = viewModel::onEventDispatcher
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreenContent(
    eventDispatcher: (MainContract.Intent) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0XFFEEECEC)),
    ) {
        val fontFamily = FontFamily(
            Font(R.font.gilroy_semibold),
        )
        var searchText by remember { mutableStateOf("") }
        var isActive by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 10.dp)
        ) {
            /*     SearchBar(
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
                },
                modifier = Modifier
            ) {
                Text("Search here", modifier = Modifier)
            }

        */

            MySearchBar(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 20.dp)
                    .background(Color.White, shape = RoundedCornerShape(16.dp)),
                hint = "Search..."
            )

            Image(
                painter = painterResource(id = R.drawable.ic_noticifation),
                contentDescription = "Notification Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(5.dp)
            )
        }
        val pagerState = rememberPagerState(pageCount = {
            2
        })
        HorizontalPager(state = pagerState, modifier = Modifier.padding(vertical = 16.dp)) { page ->
            if (page == 0)
                MainCardsItem("UZS",
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.Blue)
                        .graphicsLayer {
                            val pagerOffset = (
                                    (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                                    ).absoluteValue
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pagerOffset.coerceIn(0f, 1f)
                            )
                        }
                )
            else if (page == 1)
                MainCardsItem("KAZ",
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.Blue)
                        .graphicsLayer {
                            val pagerOffset = (
                                    (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                                    ).absoluteValue
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pagerOffset.coerceIn(0f, 1f)
                            )
                        }
                )
        }
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.Blue else Color.Gray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(6.dp)
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 8.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_send),
                        contentDescription = "send",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Transfer", style = TextStyle(
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = fontFamily,
                            fontSize = 16.sp
                        )
                    )
                }
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp, end = 16.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_wallet),
                        contentDescription = "send",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(24.dp),
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Payment", style = TextStyle(
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = fontFamily,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.White)
                .height(160.dp)
        ) {
            Text(
                text = "eSIM",
                modifier = Modifier
                    .padding(start = 10.dp, top = 16.dp),
                style = TextStyle(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontFamily = fontFamily,
                    fontSize = 16.sp
                )
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 16.dp)
                    .padding(bottom = 10.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color(0XFFEEECEC)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "add eSIM",
                        modifier = Modifier.size(36.dp),
                        alignment = Alignment.Center
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Add eSIM",
                        style = TextStyle(
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            fontFamily = fontFamily,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun MySearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {},
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    Box(
        modifier = modifier
            .height(36.dp)
    ) {
        TextField(value = text, onValueChange = {
            text = it
            onSearch(it)
        }, leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        }, maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true && text.isEmpty()
                })
        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.Gray,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 50.dp)
                    .padding(top = 10.dp)
            )
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreenContent()
}