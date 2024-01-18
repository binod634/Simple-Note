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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.simplenote.database.NoteData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewNote(noteData: NoteData,dismiss:() -> Unit, deleteNote:() -> Unit) {
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
            Box(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = noteData.title,
                        onValueChange = { /* Null */ },
                        label = {
                            Text(text = "Title")
                        })
                    OutlinedTextField(
                        value = noteData.description,
                        onValueChange = { /* Null */ },
                        label = {
                            Text(text = "Description")
                        })
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = { dismiss() }) {
                            Text(text = "Dismiss", color = MaterialTheme.colorScheme.onSurface)
                        }
                        Spacer(modifier = Modifier.width(32.dp))
                        Button(onClick = { deleteNote();dismiss() }) {
                            Text(text = "Delete Note", color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                }
            }
        }
    }
}