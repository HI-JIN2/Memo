package com.example.umc08

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Index
import androidx.room.Insert
import androidx.room.Query
import com.example.umc_05_recyclerview.Data

@Dao
interface DataDao {
    //여기에 실질적으로 데이터를 가져오고~

    @Insert
    fun insert(data: Data)

    @Delete
    fun delete(data: Data)

    @Query("SELECT*FROM Memo")
    fun selectALL():List<Data>
//
//    @Query("SELECT*FROM Memo WHERE `index`")
//    fun selectByDataNumber(index: Index) : Data
//
//    @Query("SELECT * FROM Memo WHERE Title=:title")
//    fun selectByDataTitle(title:String) : List<Data>
}