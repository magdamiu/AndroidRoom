package com.magdamiu.androidroom.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.magdamiu.androidroom.db.entity.Department;
import com.magdamiu.androidroom.db.entity.Employee;
import com.magdamiu.androidroom.model.CompanyAndAllDepartments;

import java.util.List;

/**
 * Created by magdamiu on 03/11/17.
 */

@Dao
public interface CompanyDepartmentsDao {

    @Transaction
    @Query("SELECT * FROM Company WHERE id = :companyId")
    LiveData<CompanyAndAllDepartments> loadCompanyAllDepartments(long companyId);
}
