package com.gamestore.view.screens

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gamestore.model.Game
import com.gamestore.model.ItemCompravel


@Composable
fun GameDetailScreen(game: Game) {

    // estado para abrir/fechar o sheet
    val openSheet = remember { mutableStateOf(false) }
    val itemSelecionado = remember { mutableStateOf<ItemCompravel?>(null) }

    Column {
        Text(game.nomegame)
        Text(game.descricaogame)

        // lista de itens
        LazyColumn {
            items(game.itens) { item ->
                Card(
                    modifier = Modifier.clickable {
                        itemSelecionado.value = item
                        openSheet.value = true
                    }
                ) {
                    Column {
                        Text(item.nomeitens)
                        Text(item.descricaoitens)
                        Text(item.precoitens.toString())
                    }
                }
            }
        }


        if (openSheet.value) {
            ModalBottomSheet(
                onDismissRequest = { openSheet.value = false }
            ) {
                Text(itemSelecionado.value!!.nomeitens)
                Text(itemSelecionado.value!!.precoitens.toString())
                Button(onClick = {
                    Toast...
                    openSheet.value = false
                }) {
                    Text("Comprar")
                }
            }
        }
    }
}


