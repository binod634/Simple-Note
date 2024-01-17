package com.example.simplenote.appScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNote(onDismiss: () -> Unit, onAdd: () -> Unit) {
    val titleData = remember {
        mutableStateOf("")
    }
    val descriptionData = remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Add Note",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            })
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = titleData.value,
                    onValueChange = { data -> titleData.value = data },
                    label = {
                        Text(text = "Title")
                    })
                OutlinedTextField(
                    value = descriptionData.value,
                    onValueChange = { data -> descriptionData.value = data },
                    label = {
                        Text(text = "Description")
                    })
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = { onDismiss() }) {
                        Text(text = "Dismiss", color = MaterialTheme.colorScheme.onSurface)
                    }
                    Spacer(modifier = Modifier.width(32.dp))
                    Button(onClick = { onAdd() }) {
                        Text(text = "Add", color = MaterialTheme.colorScheme.onSurface)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ShowAddNote() {
    AddNote(onDismiss = { /* Null */ }, onAdd = { /* null */ })
}