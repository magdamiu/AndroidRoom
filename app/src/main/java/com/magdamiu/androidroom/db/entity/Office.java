package com.magdamiu.androidroom.db.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

/**
 * Created by magda on 12/02/2018.
 */

@Entity(primaryKeys = {"id", "code"})
public class Office {

    private int id;

    @NonNull
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@NonNull String code) {
        this.code = code;
    }
}
