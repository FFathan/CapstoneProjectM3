package com.example.capstoneprojectm3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.capstoneprojectm3.ui.component.HomeTopBar
import com.example.capstoneprojectm3.ui.component.NoteCard
import com.example.capstoneprojectm3.ui.data.Note
import com.example.capstoneprojectm3.ui.theme.CapstoneProjectM3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapstoneProjectM3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Home()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(noteList: List<Note>) {
    Scaffold(
        topBar = { HomeTopBar() },
        floatingActionButton = {
            FloatingActionButton( onClick = {}) {
                Icon(Icons.Filled.Add, "Add new note")
            }
        },

        content = { innerPadding ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = innerPadding,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                items(noteList){note ->
                    NoteCard(
                        note.title,
                        note.date,
                        note.description
                    )
                }
            }
        }
    )
}

@Preview(
    name = "Home",
    widthDp = 360,
    heightDp = 640,
//    showSystemUi = true
    )
@Composable
fun HomePreview() {
    CapstoneProjectM3Theme {
        Surface(
//            modifier = Modifier
//                .width(360.dp)
//                .height(640.dp),
//            color = MaterialTheme.colorScheme.background
        ) {
            val title = "Note Title"
            val date = "DD/MM/YYYY 12:34:56"
            val description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor"
            val listNoteExample = mutableListOf<Note>()
            for (id in 1..100) {
                val note = Note(
                    id,
                    title,
                    date,
                    description
                )
                listNoteExample.add(note)
            }
            Home(listNoteExample)
        }
    }
}