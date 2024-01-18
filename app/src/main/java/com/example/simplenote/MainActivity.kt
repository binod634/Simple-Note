package com.example.simplenote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplenote.appScreens.AddNote
import com.example.simplenote.appScreens.AppHome
import com.example.simplenote.appScreens.AppScreen
import com.example.simplenote.appScreens.ViewNote
import com.example.simplenote.database.DatabaseEntity
import com.example.simplenote.database.NoteData
import com.example.simplenote.ui.theme.SimpleNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val instance = DatabaseEntity.getDatabase(context = applicationContext)
        val viewModel by lazy { AppViewModel(instance.databaseDao()) }
        installSplashScreen()
        setContent {
            SimpleNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = AppScreen.Home.name) {
                        composable(route = AppScreen.Home.name) {
                            AppHome(
                                noteDataFlowList = viewModel.noteData,
                                navAddNote = {
                                    navController.navigate(AppScreen.AddNote.name)
                                },
                                showNoteInfo = { noteData: NoteData ->
                                    viewModel.noteToView(noteData = noteData)
                                    navController.navigate(AppScreen.ViewNote.name)
                                }
                            )
                        }
                        composable(route = AppScreen.AddNote.name) {
                            AddNote(returnToHome = {
                                navController.popBackStack(
                                    route = AppScreen.Home.name,
                                    saveState = false,
                                    inclusive = false
                                )
                            }) { title, description ->
                                viewModel.addNote(
                                    NoteData(
                                        title = title,
                                        description = description
                                    )
                                )
                                navController.popBackStack(
                                    route = AppScreen.Home.name,
                                    inclusive = false
                                )
                            }
                        }
                        composable(route = AppScreen.ViewNote.name) {
                            ViewNote(
                                noteData = viewModel.noteView!!,
                                dismiss = {
                                    navController.popBackStack(
                                        route = AppScreen.Home.name,
                                        inclusive = false
                                    )
                                }) {
                                viewModel.deleteCurrentNote()
                            }
                        }
                    }
                }
            }
        }
    }
}