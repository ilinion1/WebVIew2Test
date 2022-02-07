package com.example.webview2.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.webview2.data.network.api.model.LinkContainerDto

@Dao
interface WebViewDao {

    @Query("SELECT * FROM all_link")
    fun getLink(): LiveData<LinkContainerDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDatabase(linkContainerDbModel: LinkContainerDbModel)

}