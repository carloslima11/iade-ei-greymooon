package com.gamestore.model
import java.io.Serializable

data class ItemCompravel(
    val id:Int,
    val nome:String,
    val preco:Double,
    val imagem:Int,
): Serializable