package com.project.memo.di

import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {
    single {
        ktorfit {
            httpClient(
                HttpClient {
                    install(HttpTimeout) {
                        requestTimeoutMillis = 5000L
                        connectTimeoutMillis = 5000L
                    }
                    install(ContentNegotiation) {
                        json(
                            json = Json {
                                prettyPrint = true
                                isLenient = true
                                ignoreUnknownKeys = true
                            },
                            contentType = ContentType.Application.Json
                        )
                    }
                    install(DefaultRequest) {
                        headers.apply {
                            header(HttpHeaders.ContentType, ContentType.Application.Json)
                        }
                    }
                }
            )
        }
    }
}