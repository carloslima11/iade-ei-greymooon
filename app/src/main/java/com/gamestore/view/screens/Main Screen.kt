package com.gamestore.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.gamestore.model.Game
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gamestore.view.components.GameCard

@Composable
fun MainScreen(
    games: List<Game>,
    onGameClick: (Game) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 130.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(games) { game ->
            GameCard(game = game, onClick = { onGameClick(game) })
        }
    }
}

//preview da tela principal
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    //lista falta só para a preview
    val listaTeste = listOf(

        Game(
            idgame = 1,
            nomegame = "Solo Leveling",
            descricaogame = "Solo Leveling, o webtoon com 14,3 bilhões de visualizações em todo o mundo, agora é um jogo de RPG de ação! Ajude nosso herói a crescer a partir de seu humilde começo E-Rank.",
            precogame = 59.99,
            imagegame = com.gamestore.R.drawable.solo_leveling,
            itens = emptyList()
        ),

        Game(
            idgame = 2,
            nomegame = "Hades II",
            descricaogame = "Lute além do Submundo usando feitiçaria negra para enfrentar o Titã do Tempo nesta sequência encantadora do premiado rastreador de masmorras rogue-like.",
            precogame = 29.99,
            imagegame = com.gamestore.R.drawable.hades2,
            itens = emptyList()
        ),

        Game(
            idgame = 3,
            nomegame = "God Of War II",
            descricaogame = "Sentado em cima de seu trono no Olimpo, Kratos, o guerreiro mortal uma vez tornou-se uma ameaça muito pior do que seu antecessor, Ares, já havia sido. Kratos é um Deus cruel, cuja ira ataca por qualquer um que cruza seu caminho ou o caminho de seu amado Esparta.",
            precogame = 79.99,
            imagegame = com.gamestore.R.drawable.gow_cover,
            itens = emptyList()
        )

    )

    //chama o ecrã principal
    MainScreen(
        games = listaTeste,
        onGameClick = {}
    )
}

            /*Card(modifier = Modifier.clickable {onGameClick(game)})
            {
                Column {
                    Text(text = game.nomegame,)
                }*/
