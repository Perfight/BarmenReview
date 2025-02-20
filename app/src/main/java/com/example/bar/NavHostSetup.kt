package com.example.bar

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun BarNavigation(viewModel: BarViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "cocktail_list") {
        composable("cocktail_list") {
            CocktailListScreen(
                cocktails = viewModel.cocktails.value,
                onCocktailClick = { cocktail ->
                    navController.navigate("cocktail_detail/${cocktail.id}")
                },
                onFavoritesClick = {
                    navController.navigate("favorites") // Переход на экран избранных
                }
            )
        }
        composable("cocktail_detail/{id}") { backStackEntry ->
            val cocktailId = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: -1
            val selectedCocktail = viewModel.cocktails.value.find { it.id == cocktailId } ?: return@composable
            CocktailDetailScreen(cocktail = selectedCocktail) {
                navController.popBackStack()
            }
        }
        composable("favorites") {
            FavoritesScreen(
                cocktails = viewModel.cocktails.value,
                onCocktailClick = { cocktail ->
                    navController.navigate("cocktail_detail/${cocktail.id}")
                },
                onBackClick = { navController.popBackStack() } // Возврат на предыдущий экран
            )
        }
    }
}