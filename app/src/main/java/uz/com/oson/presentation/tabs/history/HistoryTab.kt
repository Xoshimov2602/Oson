package uz.com.oson.presentation.tabs.history

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.com.oson.R
import uz.com.oson.domain.remote.response.transfer.HistoryResponse
import uz.com.oson.presentation.adapter.HistoryItem

object HistoryTab : Tab {
    private fun readResolve(): Any = HistoryTab
    override val options: TabOptions
        @Composable get() {
            val title = "History"
            val icon = painterResource(id = R.drawable.ic_clock)
            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    override fun Content() {
        val viewmodel = getViewModel<HistoryViewmodel>()
        LaunchedEffect (null) {
            viewmodel.clickEvents(HistoryContract.Action.GetAllHistory)
        }
        HistoryContent(historyList = viewmodel.uiState.value.historyList)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HistoryContent(historyList: HistoryResponse = HistoryResponse(10, 1, 1, emptyList())) {
    Scaffold(content = {
        var isOutcomeSelected by remember { mutableStateOf(true) }
        val titleFont = FontFamily(
            Font(R.font.gilroy_bold),
        )

        val font = FontFamily(
            Font(R.font.gilroy_medium)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color(0XFFEEECEC))
                .padding(horizontal = 16.dp)
                .imePadding(),
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "History",
                    style = TextStyle(fontFamily = titleFont, fontSize = 18.sp),
                    modifier = Modifier.align(Alignment.Center)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_filter),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(8.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .height(48.dp)
                    .background(Color.White, shape = RoundedCornerShape(22.dp))
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(22.dp))
                        .background(
                            if (isOutcomeSelected) Color.Blue else Color.White,
                            shape = RoundedCornerShape(22.dp)
                        )
                        .clickable { isOutcomeSelected = true },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Outcoming",
                        color = if (isOutcomeSelected) Color.White else Color.Black,
                        style = TextStyle(fontSize = 16.sp, fontFamily = font)
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(22.dp))
                        .background(
                            if (isOutcomeSelected) Color.White else Color.Blue,
                            shape = RoundedCornerShape(22.dp)
                        )
                        .clickable { isOutcomeSelected = false },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Incoming",
                        color = if (isOutcomeSelected) Color.Black else Color.White,
                        style = TextStyle(fontSize = 16.sp, fontFamily = font)
                    )
                }
            }
            if (isOutcomeSelected) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(vertical = 10.dp)
                ) {
                    items(historyList.child.size) { index ->
                        HistoryItem(
                            modifier = Modifier
                                .height(100.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.White),
                            from = historyList.child[index].from,
                            to = historyList.child[index].to,
                            amount = historyList.child[index].amount,
                            time = historyList.child[index].time
                        )
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Text(
                        text = "Incoming list is empty",
                        modifier = Modifier.align(Alignment.Center),
                        style = TextStyle(fontFamily = font, color = Color.Gray, fontSize = 16.sp)
                    )
                }
            }
        }
    })
}

@Composable
@Preview
fun HistoryPreview() {
    HistoryContent()
}