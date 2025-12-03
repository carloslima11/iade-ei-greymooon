package com.gamestore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gamestore.model.Game
import com.gamestore.model.ItemCompravel
import com.gamestore.ui.theme.GameStoreTheme

class GameDetailActivity(game: Game) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
            val game = intent.getSerializableExtra("game_data") as Game
        setContent { GameDetailActivity(game) }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun GameDetailActivity(game: Game,onBackClick: () -> Unit = {}) {
            val sheetOpen = remember { mutableStateOf(false) }
            val selectedItem = remember { mutableStateOf<ItemCompravel?>(null) }
            val context = LocalContext.current

            TopAppBar(
                title = { Text(game.nomegame)
                    MaterialTheme.typography.titleLarge
                    FontWeight.Bold},
                navigationIcon = {
                    IconButton(onClick = { val intent = Intent(context, MainActivity::class.java); context.startActivity(intent) }) {
                        Icon(painter = painterResource(id = com.gamestore.R.drawable.back_arrow), contentDescription = null)
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )


            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 120.dp),

                verticalArrangement = Arrangement.spacedBy(10.dp)

            ) {
                // cabeçalho com o jogo e a descrição
                Row(modifier = Modifier.padding(bottom = 10.dp)) {
                    Image(
                        painter = painterResource(id = game.imagegame),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(120.dp).clip(RoundedCornerShape(10.dp))
                    )
                    Column(modifier = Modifier.padding(start = 10.dp)) {
                        Text(text = game.descricaogame, maxLines = 5)
                    }
                }

                Text(
                    "Purchasable Items",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                // lista com os itens do jogo
                LazyColumn {
                    items(game.itens) { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .clickable { // clique para abrir o bottom sheet
                                    selectedItem.value = item
                                    sheetOpen.value = true
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = item.imagemitens),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(110.dp).clip(RoundedCornerShape(10.dp))
                            )
                            // nome e descrição dos itens do jogo
                            Column(modifier = Modifier.weight(1f).padding(horizontal = 10.dp)) {
                                Text(
                                    text = item.nomeitens,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold

                                )
                                Text(
                                    text = item.descricaoitens,
                                    maxLines = 2,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                            // preço
                            Text(
                                text = "$${item.precoitens}",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .align(Alignment.Bottom)
                            )
                        }
                    }
                }
            }

            // bottom sheet com a mensagem de compra
            if (sheetOpen.value && selectedItem.value != null) {
                ModalBottomSheet(onDismissRequest = { sheetOpen.value = false }) {
                    val item = selectedItem.value!!
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth()
                    )
                    {
                        Text(
                            text = item.nomeitens,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Image(
                                painter = painterResource(id = item.imagemitens),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(150.dp)
                                    .clip(RoundedCornerShape(10.dp))
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = item.descricaoitens,
                                fontSize = 14.sp,
                                color = Color.DarkGray,
                                modifier = Modifier.weight(1f)
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "$${item.precoitens}",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            Button(
                                onClick = {
                                    val msg = "Acabou de comprar o item ${item.nomeitens} por $${item.precoitens}"
                                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
                                    sheetOpen.value = false
                                }
                            ) {
                                Text("Buy with 1-click")
                            }
                        }

                        Spacer(modifier = Modifier.height(40.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameDetailActivityPreview() {
    //itens para a preview
    val GOW2Item1 = ItemCompravel(
        iditens = 1,
        nomeitens = "Chaos Blades",
        descricaoitens = "Alimentadas por uma raiva primordial e forjadas no fogo do submundo. As correntes permitem que o usuário ataque a média distância, criando um turbilhão incontrolável de aço quente e destruição.",
        precoitens = 29.99,
        imagemitens = com.gamestore.R.drawable.chaos_blades
    )

    val GOW2Item2 = ItemCompravel(
        iditens = 2,
        nomeitens = "Barbarian Hammer",
        descricaoitens = "Sem magia, sem elegância e sem piedade. Apenas peso esmagador capaz de transformar armaduras de placas em sucata retorcida e ossos em pó. Exige força sobre-humana para ser erguido.",
        precoitens = 9.99,
        imagemitens = com.gamestore.R.drawable.barbarian_hammer
    )

    val GOW2Item3 = ItemCompravel(
        iditens = 3,
        nomeitens = "Destiny Spear",
        descricaoitens = "Dizem que, uma vez arremessada, esta arma não para até provar o sangue de seu objetivo. Ela ignora evasivas e escudos mágicos, pois o fim da batalha já foi escrito nas estrelas.",
        precoitens = 19.68,
        imagemitens = com.gamestore.R.drawable.destiny_spear
    )

    val GOW2Item4 = ItemCompravel(
        iditens = 4,
        nomeitens = "Nemesis Whip",
        descricaoitens = "Imbuído com o espírito da Deusa da Vingança. Esta arma não fere apenas a carne, mas julga a alma. Quanto mais \"pecados\" ou dano o inimigo causou, mais devastador será o impacto do chicote.",
        precoitens = 19.68,
        imagemitens = com.gamestore.R.drawable.nemesis_whip
    )

    val GOW2Item5 = ItemCompravel(
        iditens = 5,
        nomeitens = "Olympus Divine Sword",
        descricaoitens = "Forjada por Hefesto para um campeão escolhido. O metal vibra com uma pureza celestial que nenhum mortal corrupto consegue segurar sem se queimar. Ela brilha mais forte na presença de monstros mitológicos.",
        precoitens = 24.68,
        imagemitens = com.gamestore.R.drawable.olympus_divine_sword
    )

    // criar o "jogo falso" que contém a lista acima
    val GOW2 = Game(
        idgame = 3,
        nomegame = "God Of War II",
        descricaogame = "Sentado em cima de seu trono no Olimpo, Kratos, o guerreiro mortal uma vez tornou-se uma ameaça muito pior do que seu antecessor, Ares, já havia sido.",
        precogame = 79.99,
        imagegame = com.gamestore.R.drawable.gow_cover,
        itens = listOf(GOW2Item1, GOW2Item2, GOW2Item3, GOW2Item4, GOW2Item5)
    )

    GameStoreTheme {
        GameDetailActivity(game = GOW2)
    }
}

