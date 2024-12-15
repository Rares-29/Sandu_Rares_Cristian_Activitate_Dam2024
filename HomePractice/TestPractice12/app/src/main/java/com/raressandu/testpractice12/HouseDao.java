package com.raressandu.testpractice12;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HouseDao {

    @Insert
    public void insertHouse(House house);

    @Query("SELECT * FROM house")
    public List<House> selectAll();
}
