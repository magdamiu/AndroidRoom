package com.magdamiu.androidroom;

import com.magdamiu.androidroom.db.dao.CompanyDao;
import com.magdamiu.androidroom.repository.CompanyRepository;

import org.junit.Before;

import static org.mockito.Mockito.mock;

/**
 * Created by magdamiu on 09/11/17.
 */

public class CompanyRepositoryTest {

    private CompanyDao companyDao = mock(CompanyDao.class);
    private CompanyRepository companyRepository;

    @Before
    private void setUp() throws Exception {
        companyRepository = new CompanyRepository(companyDao);
    }
}
