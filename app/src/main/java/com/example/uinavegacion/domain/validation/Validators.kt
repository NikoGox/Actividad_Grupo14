package com.example.uinavegacion.domain.validation

import android.util.Patterns

//validar correo: Formato y no vacio
fun validateEmail(email:String):String?{

    //valida si esta vacio
    if(email.isBlank()) return "El correo es obligatorio"

    //Validador integrado de email
    val ok = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    //Si la validadción no es correcta retorna el error
    if(!ok) return "Formato de correo no válido"

    return null

}

//validar nombre: no vacio, no numeros
fun validarNombre(nombre:String):String?{

    if(nombre.isBlank()) return "El nombre es obligatorio"

    //Expresiones regulares ^Hola$
    val regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúñ ü]+$")//El más dice que puede contner mas de un elemento a la vez
    if(!regex.matches(nombre)) return "Formato de nombre no válido"

    if (nombre.length !in 0..50) return "Debe tener entre 0 y 50 carácteres"

    return null
}

//validación de telefono: no vacio, longitud 8 y 9, solo numeros
fun validarTelefono(telefono:String):String?{

    if(telefono.isBlank()) return "El teléfono es obligatorio"

    if (!telefono.all {it.isDigit()}) return "Solo acepta numeros"

    if(telefono.length !in 8..9)return "Debe tener entre 8 y 9 caracteres"

    return null
}

//validación de contraseña:
fun validarContraseña(contraseña:String):String?{

    if(contraseña.isBlank()) return "La contraseña es obligatorio"

    if(contraseña.length < 8)return "Debe tener la contraseña más de 7 caracteres"

    if(!contraseña.any{it.isUpperCase()}) return "Debe contenter al menos una Mayúscula"

    if(!contraseña.any{it.isLowerCase()}) return "Debe contenter al menos una Minúscula"

    if(!contraseña.any{it.isDigit()}) return "Debe contenter al menos un número"

    if(!contraseña.any{it.isLetterOrDigit()}) return "Debe contenter al menos una simbolo"

    if(contraseña.contains(" ")) return "No puede tener espacios en blanco"

    //**Expresiones regulares ^Hola$
    //val regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúñ0-9]+$")//El más dice que puede contner mas de un elemento a la vez
    //if(!regex.matches(contraseña)) return "Formato de contraseña no válido"
    
    return null
}

//validar coincidencia de contraseña
fun validacionConfirmacion(contraseña: String,confirm:String):String?{

    if(confirm.isBlank()) return "Debe confirmar la contraseña"
    if(contraseña != confirm) return "Las contraseñas deben coincidir"

    return null
}

