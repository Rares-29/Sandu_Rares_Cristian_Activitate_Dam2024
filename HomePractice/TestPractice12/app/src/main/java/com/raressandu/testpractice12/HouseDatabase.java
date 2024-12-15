package com.raressandu.testpractice12;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Database(entities = {House.class}, version=1)
@TypeConverters(DateConverter.class)
public abstract class HouseDatabase extends RoomDatabase {
    public abstract HouseDao getHouseDao();
}
