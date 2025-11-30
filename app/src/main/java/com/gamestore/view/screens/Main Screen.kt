package com.gamestore.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gamestore.model.Game
import com.gamestore.view.components.GameCard

@Composable
fun MainScreen(
    games: List<Game>,
    onGameClick: (Game) -> Unit
) {
    // coluna principal (lista e menu em cima)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp) // espaçamento em cima
    ) {

        LazyColumn(
            modifier = Modifier
                .weight(1f) // Ocupa todo o espaço disponível
                .padding(horizontal = 0.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {

            //cabeçalho com notificações e definições (inativas)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row {
                        Icon(Icons.Default.Notifications,
                            null,
                            Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(Icons.Default.Settings,
                            null,
                            Modifier.size(28.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(50.dp))

                    Text(
                        text = "GreyMoon",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold

                    )

                Spacer(modifier = Modifier.height(30.dp))
            }

            //lista dos jogos
            items(games) { game ->
                GameCard(game = game, onClick = { onGameClick(game) })
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF5F5F5))
                .padding(vertical = 30.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // botão featured(principal e único funcional)
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Icon(Icons.Default.Star,
                    null,
                    tint = Color.Black
                )
                Text("Featured",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            // botão de histórico(inativo)
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Icon(Icons.Default.DateRange,
                    null,
                    tint = Color.Gray
                )
                Text("History",
                    color = Color.Gray
                )
            }

            //botão de perfil(inativo)
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Icon(Icons.Default.Person,
                    null,
                    tint = Color.Gray
                )
                Text("Profile",
                    color = Color.Gray
                )
            }
        }
    }
}

//preview do ecrã principale
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    val lista = listOf(
        Game(1,
            "Solo Leveling",
            "",
            59.99,
            com.gamestore.R.drawable.solo_leveling,
            emptyList()),

        Game(2,
            "Hades II",
            "",
            29.99,
            com.gamestore.R.drawable.hades2,
            emptyList()),

        Game(2,
            "God Of War II",
            "",
            79.99,
            com.gamestore.R.drawable.gow_cover,
            emptyList())
    )
    MainScreen(games = lista, onGameClick = {})
}