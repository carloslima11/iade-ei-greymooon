package com.gamestore.model
import java.io.Serializable

data class Game(
    val id: Int,
    val nome: String,
    val descricao: String,
    val preco: Double,
    val image: Int,
    val itens: List<ItemCompravel>
): Serializable
