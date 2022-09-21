package aaa.bivizul.a32project.virbetapi

import aaa.bivizul.a32project.virbetentity.VirbetEntity
import aaa.bivizul.a32project.virbetentity.VirbetItemEntity
import aaa.bivizul.a32project.virbetentity.VirbetgEntity
import aaa.bivizul.a32project.virbetutil.Virbetcon.VIRBETBASEURL
import aaa.bivizul.a32project.virbetutil.Virbetcon.VIRBETGURL
import aaa.bivizul.a32project.virbetutil.Virbetcon.VIRBETITEMURL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class VirbetApi {

    val virbethc = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
        install(HttpTimeout) {
            val timeout = 30000L
            connectTimeoutMillis = timeout
            requestTimeoutMillis = timeout
            socketTimeoutMillis = timeout
        }
    }

    private fun HttpRequestBuilder.virbetbase(path: String) {
        url {
            takeFrom(VIRBETBASEURL)
            encodedPath = path
        }
    }

    suspend fun getVirbetItem(): List<VirbetItemEntity> {
        val getvirbetitemurl = VIRBETITEMURL
        val virbethr = virbethc.get { virbetbase(getvirbetitemurl) }
        val getvirbetitembody = virbethr.body<List<VirbetItemEntity>>()
        return getvirbetitembody
    }

    suspend fun getVirbetg(virbetEntity: VirbetEntity): VirbetgEntity {

        println("getVirbetg virbetEntity : $virbetEntity")

        val getvirbeturl = VIRBETGURL
        val virbethr = virbethc.post {
            virbetbase(getvirbeturl)
            contentType(ContentType.Application.Json)
            setBody(virbetEntity)
        }
        val getvirbetbody = virbethr.body<VirbetgEntity>()

        println("getVirbetg getvirbetbody : $getvirbetbody")

        return getvirbetbody
    }

}