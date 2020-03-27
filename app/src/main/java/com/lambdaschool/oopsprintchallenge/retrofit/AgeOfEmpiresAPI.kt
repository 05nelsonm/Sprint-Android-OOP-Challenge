package com.lambdaschool.oopsprintchallenge.retrofit

import com.lambdaschool.oopsprintchallenge.model.Civilization
import com.lambdaschool.oopsprintchallenge.model.Structure
import com.lambdaschool.oopsprintchallenge.model.Technology
import com.lambdaschool.oopsprintchallenge.model.Unit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface AgeOfEmpiresAPI {

    @GET("civilization/{id}")
    fun getCivilization(@Path("id") id: Int): Call<Civilization>

    @GET("unit/{id}")
    fun getUnit(@Path("id") id: Int): Call<Unit>

    @GET("structure/{id}")
    fun getStructure(@Path("id") id: Int): Call<Structure>

    @GET("technology/{id}")
    fun getTechnologies(@Path("id") id: Int): Call<Technology>

    class Factory {

        companion object {

            private const val BASE_URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/"

            fun create(): AgeOfEmpiresAPI {

/*                val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.BASIC

                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .retryOnConnectionFailure(false)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build()*/

                val retrofit = Retrofit.Builder()
                    //.client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                return retrofit.create(AgeOfEmpiresAPI::class.java)
            }
        }
    }
}
