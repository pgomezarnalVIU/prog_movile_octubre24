package es.viu.animedb.presentation.utils

sealed class Screen (val route: String){
    data object AnimesListScreen : Screen("animes_list_screen")
    data object AddEditAnimeScreen : Screen("add_edit_anime_screen")
}