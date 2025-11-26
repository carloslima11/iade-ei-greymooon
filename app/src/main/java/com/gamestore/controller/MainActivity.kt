package com.gamestore.controller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.R
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gamestore.model.Game
import com.gamestore.model.ItemCompravel
import com.gamestore.ui.theme.GameStoreTheme
import kotlin.jvm.java
import android.content.Intent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameStoreTheme {
                //itens Solo Leveling
                val SoloLevelingItem1 = ItemCompravel(
                    iditens = 1,
                    nomeitens = "Demon King Sword",
                    precoitens = 29.99,
                    imagemitens = com.gamestore.R.drawable.demonking_sword
                )
                val SoloLevelingItem2 = ItemCompravel(
                    iditens = 2,
                    nomeitens = "Knights Killer",
                    precoitens = 19.99,
                    imagemitens = com.gamestore.R.drawable.knights_killer
                )
                val SoloLevelingItem3 = ItemCompravel(
                    iditens = 3,
                    nomeitens = "The Sword of Light",
                    precoitens = 29.99,
                    imagemitens = com.gamestore.R.drawable.sword_of_light
                )


                //itens Hades II
                val Hades2item1 = ItemCompravel(
                    iditens = 1,
                    nomeitens = "Nectar",
                    precoitens = 14.99,
                    imagemitens = com.gamestore.R.drawable.nectar
                )

                val Hades2Item2 = ItemCompravel(
                    iditens = 2,
                    nomeitens = "Hades II Original SoundTrack",
                    precoitens = 14.99,
                    imagemitens = com.gamestore.R.drawable.hadessoundtrack
                )

                val Hades2Item3 = ItemCompravel(
                    iditens = 3,
                    nomeitens = "Hades + Hades 2 Bundle",
                    precoitens = 65.68,
                    imagemitens = com.gamestore.R.drawable.bundle
                )

                //card do primeiro jogo
                val SoloLeveling = Game(
                    idgame = 1,
                    nomegame = "Solo Leveling",
                    descricaogame = "Solo Leveling, o webtoon com 14,3 bilhões de visualizações em todo o mundo, agora é um jogo de RPG de ação! Ajude nosso herói a crescer a partir de seu humilde começo E-Rank.",
                    precogame = 59.99,
                    imagegame = com.gamestore.R.drawable.solo_leveling,
                    itens = listOf(SoloLevelingItem1, SoloLevelingItem2, SoloLevelingItem3)
                )

                //card do segundo jogo
                val Hades2 = Game(
                    idgame = 2,
                    nomegame = "Hades II",
                    descricaogame = "Lute além do Submundo usando feitiçaria negra para enfrentar o Titã do Tempo nesta sequência encantadora do premiado rastreador de masmorras rogue-like.",
                    precogame = 29.99,
                    imagegame = com.gamestore.R.drawable.hades2,
                    itens = listOf(Hades2item1, Hades2Item2, Hades2Item3)
                )

                //lista dos jogos
                val listadejogos = listOf(SoloLeveling, Hades2)

                // chama o view(main screen)
                com.gamestore.view.screens.MainScreen(
                    games = listadejogos,
                    onGameClick = { game ->
                        // lógica de navegação (controller)
                        val intent = Intent(this@MainActivity, com.gamestore.controller.GameDetailActivity::class.java)

                        // preparar para transporta o "objeto"
                        intent.putExtra("game_data", game)

                        // iniciar a viagem
                        startActivity(intent)
                    }
                )

            }
        }
    }
}
