package com.magdamiu.androidroom;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.magdamiu.androidroom.db.AppDatabase;
import com.magdamiu.androidroom.db.DatabaseCreator;
import com.magdamiu.androidroom.db.entity.Company;
import com.magdamiu.androidroom.db.entity.Department;
import com.magdamiu.androidroom.model.CompanyAndAllDepartments;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private TextView dataTextView;
    private CoordinatorLayout coordinatorLayout;
    final DatabaseCreator databaseCreator = DatabaseCreator.getInstance(this.getApplication());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataTextView = (TextView) findViewById(R.id.text_data);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        databaseCreator.createDb(this.getApplication());
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    public void btnSaveData_onClick(View view) {
        if (databaseCreator.isDatabaseCreated().getValue().equals(true)) {
            final LiveData<List<Company>> companiesLiveData = databaseCreator.getDatabase().companyDao().getAllCompaniesOrdered();
            final LiveData<List<Company>> companiesByNameLiveData = databaseCreator.getDatabase().companyDao().getCompanies("Apple");


            if (companiesLiveData != null) {
                companiesLiveData.observe(this, new Observer<List<Company>>() {
                    @Override
                    public void onChanged(@Nullable List<Company> countries) {
                        dataTextView.setText(countries.toString() + "\n\n\n");
                    }
                });
            }
            if (companiesByNameLiveData != null) {
                companiesByNameLiveData.observe(this, new Observer<List<Company>>() {
                    @Override
                    public void onChanged(@Nullable List<Company> countries) {
                        dataTextView.append("selected= " + countries.toString() + "\n\n\n");
                    }
                });
            }


            final LiveData<CompanyAndAllDepartments> companyAndAllDepartmentsLiveData = databaseCreator.getDatabase().companyDepartmentsDao().loadCompanyAllDepartments(2);

            if (companyAndAllDepartmentsLiveData != null) {
                companyAndAllDepartmentsLiveData.observe(this, new Observer<CompanyAndAllDepartments>() {
                    @Override
                    public void onChanged(@Nullable CompanyAndAllDepartments companyAndAllDepartments) {
                        dataTextView.append(companyAndAllDepartmentsLiveData.getValue().getCompany().toString() + " " + companyAndAllDepartmentsLiveData.getValue().getDepartments().toString());
                    }
                });
            }
        } else {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "The database is not yet initialised", Snackbar
                            .LENGTH_LONG);
            snackbar.show();
        }
    }
}
