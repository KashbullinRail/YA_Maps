package com.example.ya_maps

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.ya_maps.ui.CounterView
import com.example.ya_maps.ui.MainViewModel
import com.example.ya_maps.ui.theme.YA_MapsTheme
import androidx.compose.runtime.DisposableEffect as DisposableEffect1

class MainActivity : ComponentActivity() {

    private val PERMISSIONS_REQUEST_FINE_LOCATION = 1

    private val viewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestLocationPermission()

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

    private fun requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                "android.permission.ACCESS_FINE_LOCATION"
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf<String>("android.permission.ACCESS_FINE_LOCATION"),
                PERMISSIONS_REQUEST_FINE_LOCATION
            )
        }
    }

}


@Composable
private fun YAMapsScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
) {
    val state1 = viewModel.msg.collectAsState()
    val state2 = viewModel.userLoc.collectAsState()
    val state3 = viewModel.poligon.collectAsState()
    val mapViewState = viewModel.mapViewState.collectAsState()

    DisposableEffect1(key1 = viewModel) {
        viewModel.onStart()
        onDispose { viewModel.onStop() }
    }

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            Alignment.TopCenter,
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize()
            ) {
                YAMapsView(
                    modifier = Modifier,
                    state1, state2, state3, mapViewState
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Row() {
                Spacer(modifier = Modifier.weight(1f))

                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .width(100.dp),
                    onClick = {
                        viewModel.setMsg(!viewModel.msg.value)
                    }) {}

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .width(100.dp),
                    onClick = {
                        viewModel.userLocationOn(!viewModel.msg.value)
                    }) {}

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .width(100.dp),
                    onClick = {
                        viewModel.createPoligon(!viewModel.msg.value)
                    }) {}

                Spacer(modifier = Modifier.weight(1f))
            }

        }
    }
}

@Composable
fun YAMapsView(
    modifier: Modifier = Modifier,
    state1: State<Boolean>,
    state2: State<Boolean>,
    state3: State<Boolean>,
    mapViewState: State<Boolean>,
) {
    AndroidView(
        factory = { context ->
            CounterView(context).apply {

            }
        },
        update = { mapsView ->
            if (mapViewState.value) {
                mapsView.mapViewStart()
            } else {
                mapsView.mapViewStop()
            }
            if (state1.value) {
                mapsView.setPoint()
            }
            if (state2.value) {
                mapsView.userLocation()
            }
            if (state3.value) {
                mapsView.drawPoligon()
            }
        }
    )
}
