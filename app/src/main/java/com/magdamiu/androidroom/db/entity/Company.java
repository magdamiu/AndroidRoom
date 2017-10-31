package com.magdamiu.androidroom.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.graphics.Bitmap;

import com.magdamiu.androidroom.db.converter.DateConverter;

import java.util.Date;

/**
 * Created by magdamiu on 01/11/17.
 */

@Entity(tableName = "Company")
public class Company {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int companyId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "date_updated")
    @TypeConverters(DateConverter.class)
    private Date itemUpdatedDate;

    @Ignore
    Bitmap picture;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public Date getItemUpdatedDate() {
        return itemUpdatedDate;
    }

    public void setItemUpdatedDate(Date itemUpdatedDate) {
        this.itemUpdatedDate = itemUpdatedDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", itemUpdatedDate=" + itemUpdatedDate +
                '}';
    }
}
