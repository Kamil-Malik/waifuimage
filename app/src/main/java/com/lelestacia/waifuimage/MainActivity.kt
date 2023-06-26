package com.lelestacia.waifuimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lelestacia.waifuimage.core.common.route.Dashboard
import com.lelestacia.waifuimage.core.theme.WaifuImageTheme
import com.lelestacia.waifuimage.feature.waifu.WaifuImageScreen
import com.lelestacia.waifuimage.feature.waifu.WaifuImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaifuImageTheme {

                val navController = rememberNavController()

                Surface {
                    NavHost(navController = navController, startDestination = Dashboard.route) {
                        composable(Dashboard.route) {
                            val viewModel: WaifuImageViewModel = hiltViewModel()
                            LaunchedEffect(key1 = Unit, block = {
                                viewModel.getWaifus()
                            })
                            val waifuResource by viewModel.waifu.collectAsState()
                            WaifuImageScreen(
                                waifuResource = waifuResource,
                                onWaifuClicked = {},
                                onRetry = viewModel::getWaifus
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WaifuImageTheme {
        Greeting("Android")
    }
}