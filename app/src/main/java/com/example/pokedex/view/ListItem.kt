package com.example.pokedex.view

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.model.PokemonItem


@Composable
fun PokemonItem(data: PokemonItem, clickListener: OnItemClickListener) {
    Card(
        modifier = Modifier.padding(8.dp)
            .fillMaxSize()
            .clickable {
                clickListener.onItemClick(data)
            }
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = data.name.capitalize(), modifier = Modifier.weight(.8f))
        }
    }
}

interface OnItemClickListener {
    fun onItemClick(item: PokemonItem)
}