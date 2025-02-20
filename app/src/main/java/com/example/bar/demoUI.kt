package com.example.bar

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter


data class CocktailPresenter(
    val id: Int,
    val name: String,
    val ingredients: List<String>,
    val instructions: String,
    val imageUrl: String,
    val isAlcoholic: Boolean, // Новый параметр
    var isFavorite: Boolean = false,
    var rating: Int = 0 // Рейтинг от 0 до 5
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CocktailCard(cocktail: CocktailPresenter, onCocktailClick: (CocktailPresenter) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize(),
        onClick = { onCocktailClick(cocktail) },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.1f))
        ) {
            Image(
                painter = rememberAsyncImagePainter(cocktail.imageUrl),
                contentDescription = cocktail.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = cocktail.name,
                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onSurface),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Ингредиенты: ${cocktail.ingredients.joinToString(", ")}",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = cocktail.instructions,
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Рейтинг",
                        tint = Color.Yellow,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "${cocktail.rating}/5",
                        style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                IconButton(onClick = { cocktail.isFavorite = !cocktail.isFavorite }) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = if (cocktail.isFavorite) "Удалить из избранного" else "Добавить в избранное",
                        tint = if (cocktail.isFavorite) Color.Red else Color.Gray
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CocktailListScreen(
    cocktails: List<CocktailPresenter>,
    onCocktailClick: (CocktailPresenter) -> Unit,
    onFavoritesClick: () -> Unit // Обработчик нажатия на кнопку избранного
) {
    var searchQuery by remember { mutableStateOf("") }
    var filter by remember { mutableStateOf("Все") }

    val filteredCocktails = remember(searchQuery, filter) {
        cocktails.filter {
            it.name.lowercase().contains(searchQuery.lowercase()) &&
                    (filter == "Все" || (filter == "Алкогольные" && it.isAlcoholic) || (filter == "Безалкогольные" && !it.isAlcoholic))
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Рецепты коктейлей",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF0D47A1),
                    navigationIconContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = onFavoritesClick) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Избранное",
                            tint = Color.White
                        )
                    }
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color(0xFFF5F5F5))
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = { Text("Поиск") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    FilterChip(
                        selected = filter == "Все",
                        onClick = { filter = "Все" },
                        label = { Text("Все") }
                    )
                    FilterChip(
                        selected = filter == "Алкогольные",
                        onClick = { filter = "Алкогольные" },
                        label = { Text("Алкогольные") }
                    )
                    FilterChip(
                        selected = filter == "Безалкогольные",
                        onClick = { filter = "Безалкогольные" },
                        label = { Text("Безалкогольные") }
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                if (filteredCocktails.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Ничего не найдено",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFF757575))
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                    ) {
                        items(filteredCocktails) { cocktail ->
                            CocktailCard(cocktail = cocktail, onCocktailClick = onCocktailClick)
                        }
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    cocktails: List<CocktailPresenter>,
    onCocktailClick: (CocktailPresenter) -> Unit,
    onBackClick: () -> Unit
) {
    val favoriteCocktails = cocktails.filter { it.isFavorite }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Избранное",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF0D47A1),
                    navigationIconContentColor = Color.White
                )
            )
        },
        content = { padding ->
            if (favoriteCocktails.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Нет избранных коктейлей",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFF757575))
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    items(favoriteCocktails) { cocktail ->
                        CocktailCard(cocktail = cocktail, onCocktailClick = onCocktailClick)
                    }
                }
            }
        }
    )
}