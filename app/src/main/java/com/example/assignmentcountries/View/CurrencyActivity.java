package com.example.assignmentcountries.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentcountries.Model.CountryList;
import com.example.assignmentcountries.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.assignmentcountries.Helpers.Constants.CHECKED_DATA;


public class CurrencyActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_main)
    CollapsingToolbarLayout collapsingMain;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<CountryList> currencyyList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        currencyyList = new ArrayList<>();
        currencyyList = intent.getParcelableArrayListExtra(CHECKED_DATA);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);
        setupRecyclerView(currencyyList);

    }


    private void setupRecyclerView(List<CountryList> results) {
        if (results != null) {

            CurrencyAdapter adapter = new CurrencyAdapter(getApplicationContext(), results);
            recyclerView.setAdapter(adapter);
        }
    }


}
