package com.raressandu.testpractice12;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public Date longToDate(Long date) {
        return new Date(date);
    }

    @TypeConverter
    public long dateToLong(Date date) {
        return date.getTime();
    }
}
