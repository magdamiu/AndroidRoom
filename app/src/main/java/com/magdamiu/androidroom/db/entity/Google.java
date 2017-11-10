package com.magdamiu.androidroom.db.entity;

import android.arch.persistence.room.Entity;

/**
 * Created by magdamiu on 05/11/17.
 */

@Entity
public class Google extends Company {

    private int idGoogle;
    private String addressGoogle;

    public int getIdGoogle() {
        return idGoogle;
    }

    public void setIdGoogle(int idGoogle) {
        this.idGoogle = idGoogle;
    }

    public String getAddressGoogle() {
        return addressGoogle;
    }

    public void setAddressGoogle(String addressGoogle) {
        this.addressGoogle = addressGoogle;
    }
}
