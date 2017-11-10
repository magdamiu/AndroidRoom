package com.magdamiu.androidroom.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.graphics.Bitmap;

import com.magdamiu.androidroom.db.converter.DateConverter;
import com.magdamiu.androidroom.model.Location;

import java.util.Date;

/**
 * Created by magdamiu on 01/11/17.
 */
@Entity(tableName = "Company")
public class Company {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int companyId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "date_updated")
    @TypeConverters(DateConverter.class)
    private Date itemUpdatedDate;

    @Embedded
    private Location location;

    @Embedded(prefix = "hq_")
    private Location headLocation;

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

    public Date getItemUpdatedDate() {
        return itemUpdatedDate;
    }

    public void setItemUpdatedDate(Date itemUpdatedDate) {
        this.itemUpdatedDate = itemUpdatedDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getHeadLocation() {
        return headLocation;
    }

    public void setHeadLocation(Location headLocation) {
        this.headLocation = headLocation;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public Company() {
    }

    public Company(String name, Date itemUpdatedDate, Location location, Location headLocation) {
        this.name = name;
        this.itemUpdatedDate = itemUpdatedDate;
        this.location = location;
        this.headLocation = headLocation;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", itemUpdatedDate=" + itemUpdatedDate +
                ", location=" + location +
                ", headLocation=" + headLocation +
                ", picture=" + picture +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (itemUpdatedDate != null ? !itemUpdatedDate.equals(company.itemUpdatedDate) : company.itemUpdatedDate != null)
            return false;
        if (location != null ? !location.equals(company.location) : company.location != null)
            return false;
        return headLocation != null ? headLocation.equals(company.headLocation) : company.headLocation == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (itemUpdatedDate != null ? itemUpdatedDate.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (headLocation != null ? headLocation.hashCode() : 0);
        return result;
    }
}
