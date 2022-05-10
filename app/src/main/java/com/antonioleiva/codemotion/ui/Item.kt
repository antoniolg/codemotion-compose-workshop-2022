package com.antonioleiva.codemotion.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlusOne
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.antonioleiva.codemotion.Screen

data class Item(val title: String, val subtitle: String)

val items = (1..1000).map { Item("Title $it", "Subtitle $it") }

@Composable
fun Main() {
    Screen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Codemotion") },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        }
                    })
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.PlusOne, contentDescription = null)
                }
            }
        ) {
            LazyColumn {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(MaterialTheme.colors.secondary)
                    ) {

                    }
                }
                items(items) { item ->
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = item.title)
                        Text(text = item.subtitle)
                    }
                    Divider()
                }
            }
        }

    }
}
