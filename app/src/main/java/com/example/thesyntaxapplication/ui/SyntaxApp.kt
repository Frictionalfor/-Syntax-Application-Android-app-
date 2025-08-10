package com.example.thesyntaxapplication.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.thesyntaxapplication.ui.screens.CategoriesScreen
import com.example.thesyntaxapplication.ui.screens.EntriesScreen
import com.example.thesyntaxapplication.ui.screens.EntryDetailScreen
import com.example.thesyntaxapplication.ui.screens.FavoritesScreen
import com.example.thesyntaxapplication.ui.screens.HomeScreen
import com.example.thesyntaxapplication.ui.screens.SearchScreen

@Composable
fun SyntaxApp() {
    val navController = rememberNavController()
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                
                listOf(
                    NavigationItem.Home,
                    NavigationItem.Search,
                    NavigationItem.Favorites
                ).forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.title) }
                        label = { Text(screen.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavigationItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
                               composable(NavigationItem.Home.route) {
                       HomeScreen(navController = navController)
                   }
                   composable(NavigationItem.Search.route) {
                       SearchScreen(navController = navController)
                   }
                   composable(NavigationItem.Favorites.route) {
                       FavoritesScreen(navController = navController)
                   }
                   composable("categories/{languageId}") { backStackEntry ->
                       val languageId = backStackEntry.arguments?.getString("languageId") ?: ""
                       CategoriesScreen(navController = navController, languageId = languageId)
                   }
                   composable("entries/{languageId}/{categoryId}") { backStackEntry ->
                       val languageId = backStackEntry.arguments?.getString("languageId") ?: ""
                       val categoryId = backStackEntry.arguments?.getString("categoryId") ?: ""
                       EntriesScreen(navController = navController, languageId = languageId, categoryId = categoryId)
                   }
                   composable("entry/{entryId}") { backStackEntry ->
                       val entryId = backStackEntry.arguments?.getString("entryId") ?: ""
                       EntryDetailScreen(navController = navController, entryId = entryId)
                   }
        }
    }
}

sealed class NavigationItem(
    val route: String,
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    object Home : NavigationItem("home", "Languages", Icons.Default.Home)
    object Search : NavigationItem("search", "Search", Icons.Default.Search)
    object Favorites : NavigationItem("favorites", "Favorites", Icons.Default.Favorite)
}
