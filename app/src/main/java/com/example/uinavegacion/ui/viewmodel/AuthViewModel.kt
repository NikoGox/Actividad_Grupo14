package com.example.uinavegacion.ui.viewmodel

import androidx.lifecycle.ViewModel

//Estructura para manipulatr los datos del formulario
data class LoginUiState(
    //variables de los campos del formulario
    val email: String = "",
    val contraseña: String = "",
    //variables para los errores de los campos
    val emailError: String? = "",
    val contraseñaError: String? = "",
    //variables para los estados
    var isSubmitting: Boolean = false, //flag de carga
    var canSumbit: Boolean = false, //habilito o no el boton del formulario
    var succes: Boolean = false, // resultado ok del formulario
    var erorMsg: String? = null, //error general del formulario (usario y/o contraseña incorrecta)
    var isActivatedRemember: Boolean = false // checkbox recordar cuenta
)

data class RegisterUiState(
    //variables de los campos del formulario
    val nombre: String = "",
    val email: String = "",
    val telefono: String = "",
    val contraseña: String = "",
    val confirm: String = "",
    //variables para los errores de los campos
    val nombreError: String? = "",
    val emailError: String? = "",
    val telefonoError: String? = "",
    val contraseñaError: String? = "",
    val confirmError: String? = "",
    //variables para los estados
    var isSubmitting: Boolean = false, //flag de carga
    var canSumbit: Boolean = false, //habilito o no el boton del formulario
    var succes: Boolean = false, // resultado ok del formulario
    var erorMsg: String? = null //error general del formulario (Usuario ya existente)
)

//estructura estandar para los usuarios
private data class DemoUser(
    val nombre: String,
    val email: String,
    val telefono: String,
    val contraseña: String
)

class AuthViewModel : ViewModel(){
    //coleccion estatica de usuarios que se manipularon como una sola instancia
    companion object{
        //lista mutalbe de usuarios
        private val USERS = mutableListOf(
            DemoUser("Demo","a@a.cl","12345678","Demo1!")
        )
    }

}