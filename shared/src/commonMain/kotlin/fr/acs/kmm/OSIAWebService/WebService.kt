package fr.acs.kmm.OSIAWebService

import fr.acs.kmm.Log

interface WebService {
    suspend fun upload(log:Log)
    suspend fun upload(logs:List<Log>)
}



interface Reachability {
    var netWorkIsReachable: Boolean
}

interface Scheduler {
    fun launch(webService : WebService)
}