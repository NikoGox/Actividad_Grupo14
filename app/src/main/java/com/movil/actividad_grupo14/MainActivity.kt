// Archivo: src/main/java/com/movil/actividad_grupo14/MainActivity.kt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.movil.actividad_grupo14.ui.navigation.NavigationEvent
import com.movil.actividad_grupo14.ui.navigation.Screen
import com.movil.actividad_grupo14.ui.screen.IniciarSesion
import com.movil.actividad_grupo14.ui.screen.PaginaPrincipal
import com.movil.actividad_grupo14.ui.screen.Registrarse
import com.movil.actividad_grupo14.ui.theme.Actividad_Grupo14Theme
import com.movil.actividad_grupo14.ViewModel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Actividad_Grupo14Theme {
                val viewModel: MainViewModel = viewModel()
                val navController = rememberNavController()

                LaunchedEffect(Unit) {
                    viewModel.navigationEvents.collectLatest { event ->
                        when (event) {
                            is NavigationEvent.NavigateTo -> {
                                navController.navigate(event.route.route) {
                                    event.popUpToRoute?.let {
                                        popUpTo(it.route) {
                                            inclusive = event.inclusive
                                        }
                                    }
                                    launchSingleTop = event.singleTop
                                }
                            }
                            is NavigationEvent.PopBackStack -> navController.popBackStack()
                            is NavigationEvent.NavigateUp -> navController.navigateUp()
                        }
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = Screen.PaginaPrincipal.route,
                    modifier = Modifier.padding()
                ) {
                    composable(Screen.PaginaPrincipal.route) {
                        PaginaPrincipal(navController = navController, viewModel = viewModel)
                    }
                    composable(Screen.IniciarSesion.route) {
                        IniciarSesion(navController = navController, viewModel = viewModel)
                    }
                    composable(Screen.Registrarse.route) {
                        Registrarse(navController = navController, viewModel = viewModel)
                    }
                }
            }
        }
    }
}