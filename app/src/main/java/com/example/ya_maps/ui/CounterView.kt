package com.example.ya_maps.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.ya_maps.databinding.ComponentCounterBinding
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.map.SublayerManager
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.user_location.UserLocationLayer


class CounterView(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val TARGET_LOCATION = Point(55.763740752167465, 37.40582814075713)
    private val CAMERA_TARGET = Point(59.951029, 30.317181)
    private val ANIMATED_PLACEMARK_CENTER = Point(55.763482082898018, 37.405733146029167)
    private val PERMISSIONS_REQUEST_FINE_LOCATION = 1

    private lateinit var mapView: MapView
    private lateinit var userLocationLayer: UserLocationLayer
    private lateinit var sublayerManager: SublayerManager
    private lateinit var mapObjects: MapObjectCollection
    private lateinit var mapObjects2: MapObjectCollection

    var binding: ComponentCounterBinding

    init {
        binding = ComponentCounterBinding.inflate(LayoutInflater.from(context), this, true)
    }




//    mapView = binding.mapview.findViewById(R.id.mapview)
//
//    mapView.map.mapType = MapType.VECTOR_MAP
//
//    mapView.map.addTapListener(this)
//    mapView.map.addInputListener(this)
//
//    binding.fabPoligons.setOnClickListener {
//        mapView.map.move(
//            CameraPosition(TARGET_LOCATION, 16.0f, 0.0f, 45.0f)
//        )
//
//        sublayerManager = mapView.map.sublayerManager
//        mapObjects = mapView.map.mapObjects
//
//        val circle = Circle(TARGET_LOCATION, 100f)
//        mapObjects.addCircle(circle, Color.BLUE, 2f, Color.MAGENTA.alpha)
//
//        val points = ArrayList<Point>()
//        points.add(Point(59.949911, 30.316560))
//        points.add(Point(59.949121, 30.316008))
//        points.add(Point(59.949441, 30.318132))
//        points.add(Point(59.949441, 30.319532))
//        points.add(Point(59.950075, 30.316915))
//        points.add(Point(59.949911, 30.316560))
//        points.add(Point(59.948511, 30.314560))
//        val polygon = Polygon(LinearRing(points), ArrayList())
//        val polygonMapObject: PolygonMapObject = mapObjects.addPolygon(polygon)
//        polygonMapObject.fillColor = 0x3300FF00
//        polygonMapObject.strokeWidth = 3.0f
//        polygonMapObject.strokeColor = Color.CYAN
//    }


}