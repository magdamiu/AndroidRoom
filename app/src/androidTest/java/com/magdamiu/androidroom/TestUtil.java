package com.magdamiu.androidroom;

import com.magdamiu.androidroom.db.entity.Company;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static Company createCompany(String name) {
        return new Company(name,
                null, null, null);
    }


}
