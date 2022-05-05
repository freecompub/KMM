package fr.acs.kmm.OSIAWebService

import fr.acs.kmm.Constants
import fr.acs.kmm.Log
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.auth.*
import io.ktor.serialization.kotlinx.json.*

class WebServiceImpl(engine: HttpClientEngine,
                     private val userUrl:String,
                     private val correlationId:String = "TODO",
                     private val featureId:String?,
                     private val accessToken:String):WebService {
    private val client = HttpClient(engine) {
        defaultRequest{
            url(userUrl)
            header(Constants.correlationIdHeaderKey,correlationId)
            featureId?.let {
                header(Constants.featureHeaderKey,it)
            }

        }
        install(ContentNegotiation) {
            json()
        }
        install(HttpTimeout) {
            val timeout = 30000L
            connectTimeoutMillis = timeout
            requestTimeoutMillis = timeout
            socketTimeoutMillis = timeout
        }
        install(AuthScheme.Bearer){
                accessToken
        }
    }

    override suspend fun upload(log: Log) {
        client.post {
setBody(log)
        }
    }

    override suspend fun upload(logs: List<Log>) {
        client.post {
            setBody(logs)
        }
    }
}