package com.gamestore.controller

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gamestore.R
import com.gamestore.model.Game
import com.gamestore.model.ItemCompravel
import com.gamestore.ui.theme.GameStoreTheme

class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val game = intent.getSerializableExtra("game_data") as? Game

        setContent {
            GameStoreTheme {
                if (game != null) {
                    GameDetailScreen(
                        game = game,
                        onBackClick = { finish() }
                    )
                } else {
                    finish()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(game: Game, onBackClick: () -> Unit) {
    val sheetOpen = remember { mutableStateOf(false) }
    val selectedItem = remember { mutableStateOf<ItemCompravel?>(null) }
    val context = LocalContext.current

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        game.nomegame,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack,
                            contentDescription = "Voltar")
                    }
                },
                actions = {
                    Icon(
                        Icons.Default.FavoriteBorder,
                        "Favorito",
                        modifier = Modifier.padding(end = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 15.dp)
                .fillMaxSize()
        ) {
            // cabeçalho do jogo
            Row(modifier = Modifier.padding(vertical = 10.dp)) {
                Image(
                    painter = painterResource(id = game.imagegame),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = game.descricaogame,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text("Purchasable Items", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(10.dp))

            // lista de itens
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(game.itens) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedItem.value = item
                                sheetOpen.value = true
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = item.imagemitens),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(110.dp)
                                .clip(RoundedCornerShape(10.dp))
                        )
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 10.dp)
                        ) {
                            Text(item.nomeitens,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .align(Alignment.Start)
                            )


                            Text(item.descricaoitens,
                                maxLines = 2,
                                style = MaterialTheme.typography.bodySmall)
                        }

                        Text("$${item.precoitens}",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.Bottom))
                    }
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
                            .size(150.dp) // Tamanho fixo quadrado
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameDetailScreenPreview() {
    //preview dos itens GOW II
    val GOW2Item1 = ItemCompravel(
        iditens = 1,
        nomeitens = "Chaos Blades",
        descricaoitens = "Alimentadas por uma raiva primordial e forjadas no fogo do submundo. As correntes permitem que o usuário ataque a média distância, criando um turbilhão incontrolável de aço quente e destruição.",
        precoitens = 29.99,
        imagemitens = R.drawable.chaos_blades
    )

    val GOW2Item2 = ItemCompravel(
        iditens = 2,
        nomeitens = "Barbarian Hammer",
        descricaoitens = "Sem magia, sem elegância e sem piedade. Apenas peso esmagador capaz de transformar armaduras de placas em sucata retorcida e ossos em pó. Exige força sobre-humana para ser erguido.",
        precoitens = 9.99,
        imagemitens = R.drawable.barbarian_hammer
    )

    val GOW2Item3 = ItemCompravel(
        iditens = 3,
        nomeitens = "Destiny Spear",
        descricaoitens = "Dizem que, uma vez arremessada, esta arma não para até provar o sangue de seu objetivo. Ela ignora evasivas e escudos mágicos, pois o fim da batalha já foi escrito nas estrelas.",
        precoitens = 19.68,
        imagemitens = R.drawable.destiny_spear
    )

    val GOW2Item4 = ItemCompravel(
        iditens = 4,
        nomeitens = "Nemesis Whip",
        descricaoitens = "Imbuído com o espírito da Deusa da Vingança. Esta arma não fere apenas a carne, mas julga a alma. Quanto mais \"pecados\" ou dano o inimigo causou, mais devastador será o impacto do chicote.",
        precoitens = 19.68,
        imagemitens = R.drawable.nemesis_whip
    )

    val GOW2Item5 = ItemCompravel(
        iditens = 5,
        nomeitens = "Olympus Divine Sword",
        descricaoitens = "Forjada por Hefesto para um campeão escolhido. O metal vibra com uma pureza celestial que nenhum mortal corrupto consegue segurar sem se queimar. Ela brilha mais forte na presença de monstros mitológicos.",
        precoitens = 24.68,
        imagemitens = R.drawable.olympus_divine_sword
    )

    //preview do terceiro jogo
    val GOW2 = Game(
        idgame = 3,
        nomegame = "God Of War II",
        descricaogame = "Sentado em cima de seu trono no Olimpo, Kratos, o guerreiro mortal uma vez tornou-se uma ameaça muito pior do que seu antecessor, Ares, já havia sido.",
        precogame = 79.99,
        imagegame = R.drawable.gow_cover,
        itens = listOf(GOW2Item1, GOW2Item2, GOW2Item3, GOW2Item4, GOW2Item5)
    )

    // mostrar o ecrã
    GameStoreTheme {
        GameDetailScreen(
            game = GOW2,
            onBackClick = {}
        )
    }
}