package fr.acs.kmm

data class Message(private val inputValue:String){
    val value:String
    get() {
     return   inputValue.take(255)
    }
}
