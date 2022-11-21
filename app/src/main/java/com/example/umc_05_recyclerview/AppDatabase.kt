package com.example.umc_05_recyclerview

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.umc08.DataDao
import java.time.chrono.HijrahChronology.INSTANCE


@Database(entities = [Data::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun DataDao(): DataDao
    companion object{
        private var appDatabase:AppDatabase?=null

        @Synchronized   //공유자원의 문제 해결
        fun getInstance(context: Context) :AppDatabase?{
            if(appDatabase==null){
                synchronized(AppDatabase::class.java){
                    appDatabase= Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "memo-database"//이름 겹치면 안됨
                    ).allowMainThreadQueries().build()
                }
            }
            return appDatabase
            //효율적으로 객체를 재활용하기 위한
            //싱글톤 패턴..?
            // Room은 한 개 만들어 놓고 여러 번 사용하기 때문에 싱글톤으로 구현하였다.
            // 그리고 사용할 때는 비동기 처리를 해주어야한다.
        }

        fun deleteInstance() {
            appDatabase = null
        }
    }
}