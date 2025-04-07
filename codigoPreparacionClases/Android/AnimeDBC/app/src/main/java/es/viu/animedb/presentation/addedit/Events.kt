package es.viu.animedb.presentation.addedit

import es.viu.animedb.presentation.AnimeType

sealed interface AddEditAnimeEvent {
    data class EnteredCreator(val creator: String) : AddEditAnimeEvent
    data class EnteredTitle(val title: String): AddEditAnimeEvent
    data object AnimeView: AddEditAnimeEvent
    data object SaveAnime: AddEditAnimeEvent
    data class TypeChanged(val bookType: AnimeType): AddEditAnimeEvent
}