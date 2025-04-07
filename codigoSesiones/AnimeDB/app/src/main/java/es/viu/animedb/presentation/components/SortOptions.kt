package es.viu.animedb.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import es.viu.animedb.presentation.AnimeVM

@Composable
fun SortOptions(animeOrder: SortOrder = SortByAuthor,onSortOrderChange : (SortOrder)-> Unit){
    Row(modifier= Modifier.fillMaxWidth()){
        AnimeRadioButton(text = "Autor",
            selected = animeOrder is SortByAuthor,
            onSelect = {onSortOrderChange(SortByAuthor)})
        Spacer(modifier = Modifier.width(8.dp))
        AnimeRadioButton(text = "Titulo",
            selected = animeOrder is SortByTitle,
            onSelect = {onSortOrderChange(SortByTitle)})
    }
    Spacer(modifier = Modifier.width(8.dp))
    Row(modifier= Modifier.fillMaxWidth()){
        AnimeRadioButton(text = "Tipo",
            selected = animeOrder is SortByType,
            onSelect = {onSortOrderChange(SortByType)})
        Spacer(modifier = Modifier.width(8.dp))
        AnimeRadioButton(text = "Visto",
            selected = animeOrder is SortByView,
            onSelect = {onSortOrderChange(SortByView)})
    }

}

sealed class SortOrder()
data object SortByAuthor: SortOrder()
data object SortByTitle: SortOrder()
data object SortByView: SortOrder()
data object SortByType: SortOrder()

sealed class AnimeEvent {
    data class Order(val order: SortOrder): AnimeEvent()
    data class Delete(val anime: AnimeVM) : AnimeEvent()
}