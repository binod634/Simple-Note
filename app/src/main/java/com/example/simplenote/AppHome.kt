package com.example.simplenote

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.simplenote.ui.theme.CardContainerColor
import com.example.simplenote.ui.theme.CardContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHome() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Simple Note",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            })
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            Box(
                modifier = Modifier.padding(8.dp)
            ){
                LazyColumn {
                    items(10) {
                        ShowCard()
                    }
                }
            }
        }
    }
}

@Composable
fun ShowCard() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { /* Null */ },
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardContainerColor,
            contentColor = CardContentColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .padding(horizontal = 8.dp),
                imageVector = Icons.Filled.Edit,
                contentDescription = null,
                tint = CardContentColor
            )
            Column {
                Text(text = "Some title", fontWeight = FontWeight.Bold)
                Row {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "This is some description")
                }
            }
        }
    }
}