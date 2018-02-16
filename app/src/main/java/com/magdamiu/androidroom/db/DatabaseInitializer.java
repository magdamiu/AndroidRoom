package com.magdamiu.androidroom.db;


import com.magdamiu.androidroom.db.entity.Company;
import com.magdamiu.androidroom.db.entity.Department;
import com.magdamiu.androidroom.db.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();
    private static final String[] COMPANIES = new String[]{
            "Google", "Apple", "LinkedIN"};

    static void initializeDb(AppDatabase db) {
        List<Company> companies = new ArrayList<>(COMPANIES.length);
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        generateData(companies, employees, departments);

        //insertData(db, companies, employees, departments);
    }

    private static void generateData(List<Company> companies, List<Employee> cities, List<Department> departments) {
        Random rnd = new Random();
        for (int i = 0; i < COMPANIES.length; i++) {
            Company company = new Company();
            company.setName(COMPANIES[i]);
            company.setCompanyId(i + 1);
            companies.add(company);
        }

        for (Company company : companies) {
            int citiesNumber = rnd.nextInt(5) + 1;
            for (int i = 0; i < citiesNumber; i++) {
                Employee employee = new Employee();
                employee.setCompanyId(company.getCompanyId());
                employee.setName("Employee " + (i + 1) + " from " + company.getName());
                cities.add(employee);
            }

            int departmentNumbers = rnd.nextInt(5) + 1;
            for (int i = 0; i < departmentNumbers; i++) {
                Department department = new Department();
                department.setCompanyId(company.getCompanyId());
                department.setName("Dep " + i);
                departments.add(department);
            }
        }

    }

    private static void insertData(final AppDatabase db, List<Company> companies, List<Employee>
            employees, List<Department> departments) {
        db.beginTransaction();
        try {
            db.companyDao().insertAll(companies);
            db.employeeDao().insertAll(employees);
            db.departmentDao().insertAll(departments);
            db.departmentDao().insertAndDeleteInTransaction(departments.get(0), departments.get(1));
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }
}