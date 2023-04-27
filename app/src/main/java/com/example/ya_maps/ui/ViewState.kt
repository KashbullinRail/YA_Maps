package com.example.ya_maps.ui


data class ViewState(
    val isSetPoint: Boolean,
    val isUserLocal: Boolean,
    val isPoligon: Boolean,
    val mapsType: MapsType
)

enum class MapsType {
    MAP,
    SATELLITE,
    HYBRID,
    VECTOR_MAP
}