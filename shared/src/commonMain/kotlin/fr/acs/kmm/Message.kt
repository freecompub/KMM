package fr.acs.kmm

import kotlinx.serialization.Serializable

@Serializable
data class Message(private val inputValue:String){
    val value:String
    get() {
     return   inputValue.take(255)
    }
}
