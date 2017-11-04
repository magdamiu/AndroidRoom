package com.magdamiu.androidroom.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.magdamiu.androidroom.db.entity.Department;

import java.util.List;

/**
 * Created by magdamiu on 04/11/17.
 */

@Dao
public interface DepartmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Department> departments);
}
