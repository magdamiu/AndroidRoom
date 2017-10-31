package com.magdamiu.androidroom.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by magdamiu on 01/11/17.
 */

@Entity(foreignKeys = @ForeignKey(entity = Company.class,
        parentColumns = "id",
        childColumns = "company_id",
        onDelete = ForeignKey.CASCADE))
public class Employee {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int employeeId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "company_id")
    private int companyId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
