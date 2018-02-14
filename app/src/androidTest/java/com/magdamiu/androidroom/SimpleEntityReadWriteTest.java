package com.magdamiu.androidroom;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.magdamiu.androidroom.db.AppDatabase;
import com.magdamiu.androidroom.db.dao.CompanyDao;
import com.magdamiu.androidroom.db.entity.Company;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(AndroidJUnit4.class)
public class SimpleEntityReadWriteTest {
    private CompanyDao mCompanyDao;
    private AppDatabase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mCompanyDao = mDb.companyDao();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void writeCompanyAndReadInList() throws Exception {

        // Insert the company
        Company company = TestUtil.createCompany("DevTalksJr");
        mCompanyDao.insertCompany(company);

        // Get the company
        LiveData<List<Company>> byName = mCompanyDao.getCompanies("DevTalksJr AND id =1");

        // Check if the two objects are equals
        assertEquals("Should be equal", byName.getValue().get(0), company);
    }
}
