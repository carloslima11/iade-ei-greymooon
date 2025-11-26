package com.gamestore.model
import java.io.Serializable

data class Game(
    val idgame: Int,
    val nomegame: String,
    val descricaogame: String,
    val precogame: Double,
    val imagegame: Int,
    val itens: List<ItemCompravel>
): Serializable
