package com.nc.dragonbites.utils

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Detail: Screen("detail")
}