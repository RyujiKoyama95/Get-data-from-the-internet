package com.example.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(ScalarsConverterFactory.create()) // JSON結果をStringやプリミティブ型に変換
    .baseUrl(BASE_URL) // URLを設定
    .build()

interface MarsApiService {
    // @GETでRetrofitにgetメソッドであることを認識させる
    // パラメタにはURLのエンドポイントを指定。getPhotos()の呼び出しでベースURLの末尾にエンドポイントを追加する
    @GET("photos")
    suspend fun getPhotos(): String
}

object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}