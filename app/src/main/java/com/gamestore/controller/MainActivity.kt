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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                    //itens Solo Leveling
                    val SoloLevelingItem1 = ItemCompravel(
                        id = 1,
                        nome = "Demon King Sword",
                        preco = 29.99,
                        imagem = R.drawable.demonking_sword
                    )
                    val SoloLevelingItem2 = ItemCompravel(
                        id = 2,
                        nome = "Knights Killer",
                        preco = 19.99,
                        imagem = R.drawable.knights_killer
                    )
                    val SoloLevelingItem3 = ItemCompravel(
                        id = 3,
                        nome = "The Sword of Light",
                        preco = 29.99,
                        imagem = R.drawable.sword_of_light
                    )


                    //itens Hades II
                    val Hades2item1 = ItemCompravel(
                        id = 1,
                        nome = "Nectar",
                        preco = 14.99,
                        imagem = R.drawable.nectar
                    )

                    val Hades2Item2 = ItemCompravel(
                        id = 2,
                        nome = "Hades II Original SoundTrack",
                        preco = 14.99,
                        imagem = R.drawable.hadessoundtrack
                    )

                    val Hades2Item3 = ItemCompravel(
                        id = 3,
                        nome = "Hades + Hades 2 Bundle",
                        preco = 65.68,
                        imagem = R.drawable.bundle
                    )

            val SoloLeveling = Game(
                id = 1,
                nome = "Solo Leveling",
                descricao = "Solo Leveling, o webtoon com 14,3 bilhões de visualizações em todo o mundo, agora é um jogo de RPG de ação! Ajude nosso herói a crescer a partir de seu humilde começo E-Rank.",
                preco = 59.99,
                image = R.drawable.solo_leveling,
                itens = listOf(SoloLevelingItem1, SoloLevelingItem2, SoloLevelingItem3)
            )

            val Hades2 = Game(
                id = 2,
                nome = "Hades II",
                descricao = "Lute além do Submundo usando feitiçaria negra para enfrentar o Titã do Tempo nesta sequência encantadora do premiado rastreador de masmorras rogue-like.",
                preco = 29.99,
                image = R.drawable.hades2,
                itens = listOf(Hades2item1, Hades2Item2, Hades2Item3)
            )

            val listadejogos = listOf(SoloLeveling, Hades2)

        }
    }
}

@Composable
fun ItemCompravel(name: String, modifier: Modifier = Modifier) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    GameStoreTheme {
        ItemCompravel("Android")
    }
}
