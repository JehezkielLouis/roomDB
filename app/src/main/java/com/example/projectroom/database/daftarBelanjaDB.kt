package com.example.projectroom.database
import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room

@Database(entities = [daftarBelanja::class], version = 1)
abstract class daftarBelanjaDB : RoomDatabase() {
    abstract fun funDaftarBelanjaDAO() : daftarBelanjaDAO

    companion object{
        @Volatile
        private var INSTANCE : daftarBelanjaDB ?=null

        @JvmStatic fun getDatabase(context: Context) : daftarBelanjaDB {
            if(INSTANCE == null){
                synchronized(daftarBelanjaDB::class.java){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        daftarBelanjaDB::class.java, "daftarBelanja_db"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE as daftarBelanjaDB
        }
    }
}