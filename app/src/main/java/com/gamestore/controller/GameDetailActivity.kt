package com.gamestore.controller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.gamestore.model.Game
import com.gamestore.view.screens.GameDetailScreen


class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
            val game = intent.getSerializableExtra("game_data") as Game
        setContent { GameDetailScreen(game) }

    }
}

