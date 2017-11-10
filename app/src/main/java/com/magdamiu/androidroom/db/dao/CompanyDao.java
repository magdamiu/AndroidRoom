package com.magdamiu.androidroom.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.magdamiu.androidroom.db.entity.Company;
import com.magdamiu.androidroom.model.CompanyAndAllDepartments;

import java.util.List;

/**
 * Created by magdamiu on 01/11/17.
 */

@Dao
public interface CompanyDao {
    @Query("SELECT * FROM Company")
    LiveData<List<Company>> getAllCompanies();

    @Insert
    void insertCompany(Company company);

    @Query("SELECT * FROM Company WHERE name = :companyName")
    List<Company> getCompanies(String companyName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Company> companies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Company... companies);

    @Update
    void updateCompany(Company company);

    @Update
    void updateCompanies(Company... company);

    @Delete
    void deleteCompany(Company company);

    @Delete
    void deleteCompanies(Company... company);
}
