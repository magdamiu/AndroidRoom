package com.magdamiu.androidroom.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RawQuery;
import android.arch.persistence.room.Update;
import android.provider.BaseColumns;

import com.magdamiu.androidroom.db.entity.Company;
import com.magdamiu.androidroom.db.entity.Employee;

import java.util.List;

/**
 * Created by magdamiu on 01/11/17.
 */

@Dao
public interface EmployeeDao {
    @Query("SELECT * FROM Employee")
    LiveData<List<Employee>> getAllEmployees();

    @RawQuery
    LiveData<List<Employee>> getAllEmployeesWithLimit(String query);

    @Insert
    void insertEmployee(Employee employee);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Employee> employees);

    @Update
    void updateEmployee(Employee employee);

    @Delete
    void deleteEmployee(Employee employee);
}

