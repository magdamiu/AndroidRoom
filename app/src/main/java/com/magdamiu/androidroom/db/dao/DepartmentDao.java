package com.magdamiu.androidroom.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.magdamiu.androidroom.db.entity.Department;

import java.util.List;

/**
 * Created by magdamiu on 04/11/17.
 */

@Dao
public abstract class DepartmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<Department> departments);

    @Insert
    public abstract void insert(Department product);

    @Delete
    public abstract void delete(Department product);

    @Transaction
    public void insertAndDeleteInTransaction(Department newDepartment, Department oldDepartment) {
        // Anything inside this method runs in a single transaction.
        insert(newDepartment);
        delete(oldDepartment);
    }
}
