package com.example.marsphotos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL) // URLを設定
    .build()

interface MarsApiService {
    // @GETでRetrofitにgetメソッドであることを認識させる
    // パラメタにはURLのエンドポイントを指定。getPhotos()の呼び出しでベースURLの末尾にエンドポイントを追加する
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

object MarsApi {
    // by lazy{}は最初にこの変数にアクセスしたタイミングで値を初期化し、
    // 以降のアクセス時には同じ値を返す。シングルトン。
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}