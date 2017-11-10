package com.magdamiu.androidroom.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.magdamiu.androidroom.db.entity.Company;
import com.magdamiu.androidroom.db.entity.Department;

import java.util.List;

/**
 * Created by magdamiu on 03/11/17.
 */

public class CompanyAndAllDepartments {

    @Embedded
    Company company;

    @Relation(parentColumn = "id", entityColumn = "company_id", entity = Department.class)
    List<Department> departments;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "CompanyAndAllDepartments{" +
                "company=" + company.toString() +
                ", departments=" + departments.toString() +
                '}';
    }
}
