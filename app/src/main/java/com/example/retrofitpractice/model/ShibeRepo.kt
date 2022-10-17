package com.example.retrofitpractice.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ShibeRepo {

    suspend fun getShibe(count: String): List<String> = withContext(Dispatchers.IO) {
        val response = ShibeService.shibeService.getShibe(count)
        val body = response.body()
        return@withContext if (response.isSuccessful && body != null) {
            body
        } else {
            listOf("")
        }
    }
}