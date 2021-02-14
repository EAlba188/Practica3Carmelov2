package com.example.practica3carmelo.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.practica3carmelo.model.entity.Amigo;

import java.util.List;

@Dao
public interface AmigoDao {

    @Delete
    int delete(Amigo contacto);

    @Query("select * from amigos where id = :id")
    Amigo get(int id);

    @Query("select * from amigos")
    LiveData<List<Amigo>> getAll();
    @Insert
    long insert(Amigo contacto);
    @Update
    int update (Amigo contacto);

    @Query("select id from amigos where telefono = :num")
    int getIdAmigoLlamada(String num);



}
