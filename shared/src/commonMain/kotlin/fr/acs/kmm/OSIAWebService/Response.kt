package fr.acs.kmm.OSIAWebService

import fr.acs.kmm.Log


data class Response(
    val error: String?,
    val error_description: String?,
    val achievement: Int?
)


data class Logs(
    val Logs: List<Log>?
)