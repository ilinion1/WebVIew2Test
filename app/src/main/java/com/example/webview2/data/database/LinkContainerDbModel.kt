package com.example.webview2.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "all_link")
data class LinkContainerDbModel(

    @PrimaryKey(autoGenerate = true) val key: Int,
    val link: String? = null,
    val home: String? = null
)
