package com.magdamiu.androidroom.repository;

import com.magdamiu.androidroom.db.dao.CompanyDao;
import com.magdamiu.androidroom.db.entity.Company;

/**
 * Created by magdamiu on 09/11/17.
 */

public class CompanyRepository {

    private final CompanyDao companyDao;

    public CompanyRepository(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }
}
