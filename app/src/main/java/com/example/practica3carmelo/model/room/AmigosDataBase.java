package com.example.practica3carmelo.model.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.practica3carmelo.model.dao.AmigoDao;
import com.example.practica3carmelo.model.dao.LlamadaDao;
import com.example.practica3carmelo.model.entity.Amigo;
import com.example.practica3carmelo.model.entity.Llamada;

@Database(entities = {Amigo.class, Llamada.class}, version = 9, exportSchema = false)
public abstract class AmigosDataBase extends RoomDatabase {

    public abstract AmigoDao getAmigoDao();
    public abstract LlamadaDao getLlamadaDao();

    private volatile static AmigosDataBase INSTANCE;

    public static AmigosDataBase getDb(Context context){

        if(INSTANCE==null){
        INSTANCE = Room.databaseBuilder(context,AmigosDataBase.class,"amigosdb.sqlite").fallbackToDestructiveMigration().build();

        }
        return INSTANCE;
    }




}
