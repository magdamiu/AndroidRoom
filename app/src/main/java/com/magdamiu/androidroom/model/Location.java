package com.magdamiu.androidroom.model;

import android.arch.persistence.room.Entity;

import com.magdamiu.androidroom.db.entity.Employee;

/**
 * Created by magdamiu on 01/11/17.
 */
public class Location {

    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
