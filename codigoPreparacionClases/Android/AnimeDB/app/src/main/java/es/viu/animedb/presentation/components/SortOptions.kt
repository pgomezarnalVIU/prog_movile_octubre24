package es.viu.animedb.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import es.viu.animedb.presentation.AnimeVM

@Composable
fun SortOptions(
    animeOrder: SortOrder = SortByCreador,
    onSortOrderChange: (SortOrder) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        AnimeRadioButton(text = "Author",
            selected = animeOrder is SortByCreador,
            onSelect = { onSortOrderChange(SortByCreador) })

        Spacer(modifier = Modifier.width(8.dp))

        AnimeRadioButton(text = "Title",
            selected = animeOrder is SortByTitulo,
            onSelect = { onSortOrderChange(SortByTitulo) })

    }
    Spacer(modifier = Modifier.height(8.dp))
    Row() {

        AnimeRadioButton(text = "Fictional",
            selected = animeOrder is SortByFiccion,
            onSelect = { onSortOrderChange(SortByFiccion) })

        Spacer(modifier = Modifier.width(8.dp))

        AnimeRadioButton(text = "Read",
            selected = animeOrder is SortByVisto,
            onSelect = { onSortOrderChange(SortByVisto) })

    }
}

sealed class SortOrder()
data object SortByCreador : SortOrder()
data object SortByTitulo : SortOrder()
data object SortByVisto : SortOrder()
data object SortByFiccion : SortOrder()

data class NotesState(
    val books: List<AnimeVM> = emptyList(),
    val bookOrder: SortOrder = SortByCreador,
)

sealed class AnimeEvent {
    data class Order(val order: SortOrder)
}