package com.gamestore.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gamestore.model.ItemCompravel
import com.gamestore.R


@Composable
fun PurchaseBottomSheet(item: ItemCompravel, onBuyClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
    ) {
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
                    .size(110.dp)
                    .clip(RoundedCornerShape(12.dp))
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

            Button(onClick = onBuyClick) {
                Text("Buy with 1-click")
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PurchaseBottomSheetPreview() {
    val GOW2Item3 = ItemCompravel(
        iditens = 3,
        nomeitens = "Destiny Spear",
        descricaoitens = "Dizem que, uma vez arremessada, esta arma não para até provar o sangue de seu objetivo. Ela ignora evasivas e escudos mágicos, pois o fim da batalha já foi escrito nas estrelas.",
        precoitens = 19.68,
        imagemitens = R.drawable.destiny_spear
    )

    // chamar o componente
    PurchaseBottomSheet(
        item = GOW2Item3,
        onBuyClick = {}
    )
}