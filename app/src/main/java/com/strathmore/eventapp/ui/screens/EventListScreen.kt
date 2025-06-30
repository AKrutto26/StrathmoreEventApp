package com.strathmore.eventapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import com.strathmore.eventapp.viewmodel.EventViewModel
import com.strathmore.eventapp.ui.navigation.NavRoutes
import android.net.Uri

@Composable
fun EventListScreen(
    navController: NavController,
    viewModel: EventViewModel = viewModel()
) {
    val events by viewModel.events.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Upcoming Events") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(events) { event ->
                EventCard(
                    eventName = event.title,
                    eventDate = event.date,
                    imageUrl = event.imageUrl,
                    onClick = {
                        navController.navigate(
                            "${NavRoutes.EventDetail}/" +
                                    "${Uri.encode(event.title)}/" +
                                    "${Uri.encode(event.description)}/" +
                                    "${Uri.encode(event.date)}/" +
                                    "${Uri.encode(event.location)}/" +
                                    "${Uri.encode(event.imageUrl ?: "")}"
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun EventCard(
    eventName: String,
    eventDate: String,
    imageUrl: String?,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (!imageUrl.isNullOrEmpty()) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Text(text = eventName, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = eventDate, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

