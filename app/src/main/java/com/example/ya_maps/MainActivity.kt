package com.example.ya_maps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ya_maps.ui.CounterView
import com.example.ya_maps.ui.MainViewModel
import com.example.ya_maps.ui.theme.YA_MapsTheme

class MainActivity : ComponentActivity() {

    private val viewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            YA_MapsTheme {
                // A surface container using the 'background' color from the theme
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
    Column {
        Text(text = "YA_MAPS")
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "говномапс")
        Spacer(modifier = Modifier.padding(10.dp))

        XMLCounter(
            viewModel,
            onValueChanged = { viewModel.setMsg(it) }
        )

    }
}

@Composable
fun XMLCounter(
    viewModel: MainViewModel,
    onValueChanged: (Int) -> Unit
) {
    var resultState by remember { mutableStateOf(0) }
    AndroidView(
        factory = { context ->
            CounterView(context).apply {
                // Example of View -> Compose communication
                binding.up.setOnClickListener {
                    resultState = viewModel.msg.value?.plus(1) ?: 1
                    onValueChanged.invoke(resultState)
                }
                binding.down.setOnClickListener {
                    resultState =viewModel.msg.value?.minus(1) ?: -1
                    onValueChanged.invoke(resultState)
                }

            }
        },
        update = { counterView ->
            // Example of Compose -> View communication
            counterView.binding.result.text = resultState.toString()
        }
    )
}


@Composable
fun XmlYAMapsView(
    viewModel: MainViewModel,
    onValueChanged: (Int) -> Unit
) {

}
