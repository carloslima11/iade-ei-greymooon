package com.gamestore.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gamestore.model.Game
import androidx.compose.foundation.lazy.items


@Composable
fun MainScreen(
    games: List<Game>,
    onGameClick: (Game) -> Unit
) {
    LazyColumn {
        items(games) { game ->
            Card(modifier = Modifier.clickable {onGameClick(game)})
            {
                Column {
                    Text(text = game.nomegame,)
                    Text(text = game.descricaogame)

                }
            }
        }
    }
}



