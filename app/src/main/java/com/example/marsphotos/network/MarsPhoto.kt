package com.example.marsphotos.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// シリアル化可能にするため、@Serializableをつける
// JSONオブジェクトのキー名と対応するように変数名をつける
// kotlin規則的に変数名はキャメルケースを使用なので、@SerialNameでキー名を指定して紐づける
// 画像表示にするにはこのデータクラスの修正が必要？
@Serializable
data class MarsPhoto(
    val id: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)