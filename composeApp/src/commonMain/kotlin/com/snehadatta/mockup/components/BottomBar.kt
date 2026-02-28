package com.snehadatta.mockup.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable

@Composable
fun BottomBar() {

    NavigationBar {

        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(Icons.Default.Home, null) }
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.ShoppingCart, null) }
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Star, null) }
        )
    }
}