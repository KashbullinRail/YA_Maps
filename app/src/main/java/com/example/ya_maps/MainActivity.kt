package com.example.ya_maps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ya_maps.ui.CounterView
import com.example.ya_maps.ui.MainViewModel
import com.example.ya_maps.ui.theme.YA_MapsTheme

class MainActivity : ComponentActivity() {

    private val viewModel by lazy { MainViewModel() }
//    private val counterView by lazy { CounterView(context = this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            YA_MapsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    YAMapsScreen(viewModel = viewModel)
                }
            }
        }
    }
}


@Composable
private fun YAMapsScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
) {
    val state = viewModel.msg.collectAsState()

    DisposableEffect(key1 = viewModel) {
        viewModel.onStart()
        onDispose { viewModel.onStop() }
    }
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxSize(),
            Alignment.TopCenter,
        ) {
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .wrapContentSize()
            ) {
                XMLCounter(
                    modifier = Modifier,
                    state,
                )
            }
            Text(text = "ГОВНОМАПС")
            Text(text = "говномапс")
            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                modifier = Modifier
                    .height(20.dp)
                    .width(100.dp),
                onClick = {
                    viewModel.setMsg(true)
                }) {
            }
        }
    }
}

@Composable
fun XMLCounter(
    modifier: Modifier = Modifier,
    state: State<Boolean>,
) {
    AndroidView(
        factory = { context ->
            CounterView(context).apply {

            }
        },
        update = { counterView ->
            if (state.value) {
                counterView.setPoint(state.value)
                counterView.invalidate()
            }

        }
    )
}
