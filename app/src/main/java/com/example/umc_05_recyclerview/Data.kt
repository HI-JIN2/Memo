package com.example.umc_05_recyclerview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Memo")
data class Data (
    @ColumnInfo(name="title") val title: String,
    @ColumnInfo(name="content") val content: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="index") val index:Int=0
)