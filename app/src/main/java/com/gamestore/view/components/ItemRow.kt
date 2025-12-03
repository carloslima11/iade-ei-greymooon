package com.gamestore.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gamestore.model.ItemCompravel
import androidx.compose.ui.tooling.preview.Preview
import com.gamestore.R

@Composable
fun ItemRow(item: ItemCompravel, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.imagemitens),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = item.nomeitens,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item.descricaoitens,
                maxLines = 2,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Text(
            text = "$${item.precoitens}",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Bottom)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ItemRowPreview() {
    val GOW2Item1 = ItemCompravel(
        iditens = 1,
        nomeitens = "Chaos Blades",
        descricaoitens = "Alimentadas por uma raiva primordial e forjadas no fogo do submundo. As correntes permitem que o usuário ataque a média distância, criando um turbilhão incontrolável de aço quente e destruição.",
        precoitens = 29.99,
        imagemitens = R.drawable.chaos_blades
    )

    // chamar o item row
    ItemRow(
        item = GOW2Item1,
        onClick = {}
    )
}