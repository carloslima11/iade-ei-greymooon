package com.gamestore.controller

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.gamestore.R
import com.gamestore.model.Game
import com.gamestore.model.ItemCompravel
import com.gamestore.ui.theme.GameStoreTheme
import com.gamestore.view.components.GameCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameStoreTheme {

                // itens solo leveling
                val SoloLevelingItem1 = ItemCompravel(
                    iditens = 1,
                    nomeitens = "Knights Killer",
                    precoitens = 19.99,
                    imagemitens = R.drawable.knights_killer,
                    descricaoitens = "Desprezada pela Guarda Real, esta arma rudimentar foi inventada por rebeldes."
                )
                val SoloLevelingItem2 = ItemCompravel(
                    iditens = 2,
                    nomeitens = "The Sword of Light",
                    precoitens = 29.99,
                    imagemitens = R.drawable.sword_of_light,
                    descricaoitens = "Dizem ser um presente dos céus para o Primeiro Herói."
                )
                val SoloLevelingItem3 = ItemCompravel(
                    iditens = 3,
                    nomeitens = "Fénix Bow",
                    precoitens = 21.99,
                    imagemitens = R.drawable.fenix_bow,
                    descricaoitens = "Encordoado com a veia de um pássaro de fogo mítico."
                )
                val SoloLevelingItem4 = ItemCompravel(
                    iditens = 4,
                    nomeitens = "Heavenly Spear",
                    precoitens = 27.99,
                    imagemitens = R.drawable.heavenly_spear,
                    descricaoitens = "Caiu dos céus durante a Guerra dos Deuses."
                )
                val SoloLevelingItem5 = ItemCompravel(
                    iditens = 5,
                    nomeitens = "Lizard Glave",
                    precoitens = 38.99,
                    imagemitens = R.drawable.lizard_glave,
                    descricaoitens = "Criada pelas tribos reptilianas do Grande Pântano."
                )

                // Itens Hades II
                val Hades2item1 = ItemCompravel(
                    iditens = 6,
                    nomeitens = "Nectar",
                    precoitens = 14.99,
                    imagemitens = R.drawable.nectar,
                    descricaoitens = "Uma garrafa de ambrosia líquida destilada nos pomares do Elísio."
                )
                val Hades2Item2 = ItemCompravel(
                    iditens = 7,
                    nomeitens = "Hades II OST",
                    precoitens = 14.99,
                    imagemitens = R.drawable.hadessoundtrack,
                    descricaoitens = "Uma coleção de hinos compostos para a Princesa do Submundo."
                )
                val Hades2Item3 = ItemCompravel(
                    iditens = 8,
                    nomeitens = "Hades Bundle",
                    precoitens = 65.68,
                    imagemitens = R.drawable.bundle,
                    descricaoitens = "Testemunhe a jornada de Zagreus e Melinoë."
                )
                val Hades2Item4 = ItemCompravel(
                    iditens = 9,
                    nomeitens = "Druida's Staff",
                    precoitens = 27.68,
                    imagemitens = R.drawable.druids_staff,
                    descricaoitens = "Colhido da Árvore Mãe sem o uso de ferramentas de ferro."
                )
                val Hades2Item5 = ItemCompravel(
                    iditens = 10,
                    nomeitens = "Infernal Arms",
                    precoitens = 35.68,
                    imagemitens = R.drawable.infernal_arms,
                    descricaoitens = "Escurecido pelas cinzas de mil batalhas demoníacas."
                )

                // Itens GOW II
                val GOW2Item1 = ItemCompravel(
                    iditens = 11,
                    nomeitens = "Chaos Blades",
                    precoitens = 29.99,
                    imagemitens = R.drawable.chaos_blades,
                    descricaoitens = "Alimentadas por uma raiva primordial."
                )
                val GOW2Item2 = ItemCompravel(
                    iditens = 12,
                    nomeitens = "Barbarian Hammer",
                    precoitens = 9.99,
                    imagemitens = R.drawable.barbarian_hammer,
                    descricaoitens = "Apenas peso esmagador capaz de transformar armaduras em sucata."
                )
                val GOW2Item3 = ItemCompravel(
                    iditens = 13,
                    nomeitens = "Destiny Spear",
                    precoitens = 19.68,
                    imagemitens = R.drawable.destiny_spear,
                    descricaoitens = "Ignora evasivas e escudos mágicos."
                )
                val GOW2Item4 = ItemCompravel(
                    iditens = 14,
                    nomeitens = "Nemesis Whip",
                    precoitens = 19.68,
                    imagemitens = R.drawable.nemesis_whip,
                    descricaoitens = "Imbuído com o espírito da Deusa da Vingança."
                )
                val GOW2Item5 = ItemCompravel(
                    iditens = 15,
                    nomeitens = "Olympus Sword",
                    precoitens = 24.68,
                    imagemitens = R.drawable.olympus_divine_sword,
                    descricaoitens = "Forjada por Hefesto para um campeão escolhido."
                )

                // jogo 1 solo leveling
                val SoloLeveling = Game(
                    idgame = 1,
                    nomegame = "Solo Leveling",
                    descricaogame = "Solo Leveling, o webtoon com 14,3 bilhões de visualizações!",
                    precogame = 59.99,
                    imagegame = R.drawable.solo_leveling,
                    itens = listOf(SoloLevelingItem1, SoloLevelingItem2, SoloLevelingItem3, SoloLevelingItem4, SoloLevelingItem5)
                )

                // jogo 2 hades 2
                val Hades2 = Game(
                    idgame = 2,
                    nomegame = "Hades II",
                    descricaogame = "Lute além do Submundo usando feitiçaria negra.",
                    precogame = 29.99,
                    imagegame = R.drawable.hades2,
                    itens = listOf(Hades2item1, Hades2Item2, Hades2Item3, Hades2Item4, Hades2Item5)
                )

                // jogo 1 gow 2
                val GOW2 = Game(
                    idgame = 3,
                    nomegame = "God Of War II",
                    descricaogame = "Kratos, o guerreiro mortal uma vez tornou-se uma ameaça.",
                    precogame = 79.99,
                    imagegame = R.drawable.gow_cover,
                    itens = listOf(GOW2Item1, GOW2Item2, GOW2Item3, GOW2Item4, GOW2Item5)
                )

                val listadejogos = listOf(SoloLeveling, Hades2, GOW2)

                MainScreen(
                    games = listadejogos,
                    onGameClick = { game ->
                        val intent = Intent(this@MainActivity, GameDetailActivity::class.java)
                        intent.putExtra("game_data", game)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    games: List<Game>,
    onGameClick: (Game) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row {
                        Icon(Icons.Default.Notifications, null, Modifier.size(28.dp))
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(Icons.Default.Settings, null, Modifier.size(28.dp))
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "GreyMoon",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))
            }

            items(games) { game ->
                GameCard(game = game, onClick = { onGameClick(game) })
            }
        }

        // menu de navegação
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF5F5F5))
                .padding(vertical = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // featured
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Star, null, tint = Color.Black)
                Text("Featured", color = Color.Black, fontWeight = FontWeight.Bold)
            }
            // history
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.DateRange, null, tint = Color.Gray)
                Text("History", color = Color.Gray)
            }
            // profile
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Person, null, tint = Color.Gray)
                Text("Profile", color = Color.Gray)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    val lista = listOf(
        Game(
        idgame = 1,
        nomegame = "Solo Leveling",
        descricaogame = "Solo Leveling, o webtoon com 14,3 bilhões de visualizações!",
        precogame = 59.99,
        imagegame = R.drawable.solo_leveling,
        itens = emptyList()
        ),

    // jogo 2 hades 2
        Game(
            idgame = 2,
            nomegame = "Hades II",
            descricaogame = "Lute além do Submundo usando feitiçaria negra.",
            precogame = 29.99,
            imagegame = R.drawable.hades2,
            itens = emptyList()
        ),

    // jogo 1 gow 2
        Game(
            idgame = 3,
            nomegame = "God Of War II",
            descricaogame = "Kratos, o guerreiro mortal uma vez tornou-se uma ameaça.",
            precogame = 79.99,
            imagegame = R.drawable.gow_cover,
            itens = emptyList()
        )
    )
            MainScreen(games = lista, onGameClick = {})
}