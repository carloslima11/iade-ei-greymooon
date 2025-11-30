package com.gamestore.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gamestore.model.Game

@Composable
fun GameCard(
    game: Game,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(modifier = Modifier.padding(0.dp)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                // imagem
                Image(
                    painter = painterResource(id = game.imagegame),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 12.dp,
                                topEnd = 24.dp
                            )
                        ),
                    contentScale = ContentScale.Crop
                )

                // textos
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                        .align(Alignment.BottomStart)
                ) {
                    Text(
                        text = game.nomegame,
                        style = MaterialTheme.typography.titleLarge,
                        maxLines = 1,
                        fontWeight = FontWeight.Bold,
                        color =  Color.White

                    )
                    Spacer(modifier = Modifier
                        .height(4.dp)
                    )
                }
            }
        }
    }
}


//preview da tela principal com os games cards
@Preview
@Composable
fun GameCardPreview() {

    //card do primeiro jogo
    val SoloLeveling = Game(
        idgame = 1,
        nomegame = "Solo Leveling",
        descricaogame = "Solo Leveling, o webtoon com 14,3 bilhões de visualizações em todo o mundo, agora é um jogo de RPG de ação! Ajude nosso herói a crescer a partir de seu humilde começo E-Rank.",
        precogame = 59.99,
        imagegame = com.gamestore.R.drawable.solo_leveling,
        itens = emptyList()
    )

    //card do segundo jogo
    val Hades2 = Game(
        idgame = 2,
        nomegame = "Hades II",
        descricaogame = "Lute além do Submundo usando feitiçaria negra para enfrentar o Titã do Tempo nesta sequência encantadora do premiado rastreador de masmorras rogue-like.",
        precogame = 29.99,
        imagegame = com.gamestore.R.drawable.hades2,
        itens = emptyList()
    )

    //card do terceiro jogo
    val GOW2 = Game(
        idgame = 3,
        nomegame = "God Of War II",
        descricaogame = "Sentado em cima de seu trono no Olimpo, Kratos, o guerreiro mortal uma vez tornou-se uma ameaça muito pior do que seu antecessor, Ares, já havia sido. Kratos é um Deus cruel, cuja ira ataca por qualquer um que cruza seu caminho ou o caminho de seu amado Esparta.",
        precogame = 79.99,
        imagegame = com.gamestore.R.drawable.gow_cover,
        itens = emptyList()
    )
    val listadejogos = listOf(SoloLeveling, Hades2, GOW2)

    GameCard(
        game = listadejogos[0],
        onClick = {}
    )
}

