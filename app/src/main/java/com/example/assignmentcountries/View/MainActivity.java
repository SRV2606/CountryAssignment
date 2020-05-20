package com.example.assignmentcountries.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentcountries.Helpers.Injector;
import com.example.assignmentcountries.Model.CountryList;
import com.example.assignmentcountries.R;
import com.example.assignmentcountries.ViewModel.MainViewModelFactory;
import com.example.countryassignment.ViewModel.MainViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.assignmentcountries.Helpers.Constants.CHECKED_DATA;


public class MainActivity extends AppCompatActivity implements CountryListAdapter.CheckedItemCallback {

    private static final String MENU_SELECTED = "selected";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_main)
    CollapsingToolbarLayout collapsingMain;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    //    @BindView(R.id.progress_bar)
//    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.buttonNext)
    MaterialButton buttonNext;
    @BindView(R.id.buttonSelectAll)
    MaterialButton buttonSelectAll;
    CountryListAdapter adapter;
    private MainViewModel viewModel;
    private int selected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        MainViewModelFactory vMainViewModelFactory = Injector.provideMainViewModelFactory(getApplication());
        viewModel = ViewModelProviders.of(this, vMainViewModelFactory).get(MainViewModel.class);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);


        if (savedInstanceState == null) {
            populateUI(selected);

        } else {
            selected = savedInstanceState.getInt(MENU_SELECTED);
            populateUI(selected);
        }


        buttonSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adapter.selectAll();

            }
        });

    }


    private void populateUI(int i) {


        // viewModel.mLiveDataFav().removeObservers(this);

        if (i == 0) {


            viewModel.mLiveData().observe(this, new Observer<List<CountryList>>() {
                @Override
                public void onChanged(List<CountryList> countryLists) {
                    setupRecyclerView(countryLists);
                }
            });
        }


    }


    private void setupRecyclerView(List<CountryList> results) {
        if (results != null) {


            adapter = new CountryListAdapter(getApplicationContext(), results, this);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(MENU_SELECTED, selected);
        super.onSaveInstanceState(outState);
    }


    @Override
    public void checkedItems(final List<CountryList> checked) {
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrencyActivity.class);
                intent.putParcelableArrayListExtra(CHECKED_DATA, (ArrayList<? extends Parcelable>) checked);
                startActivity(intent);
            }
        });

    }


}



