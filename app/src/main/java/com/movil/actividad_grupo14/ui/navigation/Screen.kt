package com.movil.actividad_grupo14.ui.navigation

sealed class Screen(val route: String) {
    data object PaginaPrincipal : Screen("pagina_principal")
    data object IniciarSesion : Screen("iniciar_sesion")
    data object Registrarse : Screen("registrarse")
}


data class Detail(val itemId: String) : Screen(detail_page/{itemId}) {
    fun buildRoute() : String {
        return route.replace("{itemId}", itemId)
    }
}