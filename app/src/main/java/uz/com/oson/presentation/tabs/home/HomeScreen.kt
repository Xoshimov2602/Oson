package uz.com.oson.presentation.tabs.home


import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import uz.com.oson.presentation.tabs.cards.CardsTab
import uz.com.oson.presentation.tabs.history.HistoryTab
import uz.com.oson.presentation.tabs.main.MainTab
import uz.com.oson.presentation.tabs.profile.ProfileTab
import uz.com.oson.presentation.tabs.scanner.ScannerTab

class MainScreen : Screen {
    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    override fun Content() {
        val navigationBarHeight =
            WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
        TabNavigator(
            tab = MainTab,
            tabDisposable = {
                TabDisposable(navigator = it, tabs = listOf(MainTab, CardsTab))
            }

        ) {
            Scaffold(
                content = {
                    it
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(bottom = it.calculateBottomPadding())
                    ) {
                        CurrentTab()
                    }
                },

                bottomBar = {
                    Column {
                        BottomAppBar(
                            actions = {
                                TabNavigationItem(tab = MainTab)
                                TabNavigationItem(tab = CardsTab)
                                TabNavigationItem(tab = ScannerTab)
                                TabNavigationItem(tab = HistoryTab)
                                TabNavigationItem(tab = ProfileTab)
                            },
                            modifier = Modifier.height(70.dp + navigationBarHeight),
                            containerColor = Color.White
                        )
                    }
                }

            )
        }
    }

    @Composable
    @Preview
    private fun PreviewMainScreen() {
        Content()
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .weight(1f)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { tabNavigator.current = tab },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val textColor = animateColorAsState(
            targetValue =
            if (tabNavigator.current == tab) Color.Blue else Color(0xFFb2b7cb), label = ""
        )
        Icon(
            modifier = Modifier.size(32.dp),
            painter = tab.options.icon!!,
            contentDescription = tab.options.title,
            tint = textColor.value
        )

        Text(
            text = tab.options.title,
            color = textColor.value
        )
    }
}

