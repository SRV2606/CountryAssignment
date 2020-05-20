package com.example.assignmentcountries.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentcountries.Model.CountryList;
import com.example.assignmentcountries.Model.Currencyy;
import com.example.assignmentcountries.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.MyViewHolder> {

    private final List<CountryList> mListt;
    private final Context mContext;
    private final CheckedItemCallback listener;

    List<CountryList> forwardList = new ArrayList<>();
    List<Currencyy> currencyys;
    private boolean isSelectedAll = false;


    public CountryListAdapter(Context applicationContext, List<CountryList> results, CheckedItemCallback mlistenr) {

        this.mContext = applicationContext;
        this.mListt = results;
        this.listener = mlistenr;
    }

    public void selectAll() {
        isSelectedAll = true;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.bind(mListt.get(position));

        if (isSelectedAll) {
            holder.chbContent.setChecked(true);

        }
    }

    @Override
    public int getItemCount() {
        return 50;
    }


    public interface CheckedItemCallback {

        void checkedItems(List<CountryList> checked);


    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.countryNameTV)
        TextView countryNameTV;
        @BindView(R.id.countryCapitalTV)
        TextView countryCapitalTV;
        @BindView(R.id.inner_LL)
        LinearLayout innerLL;
        @BindView(R.id.checkbox)
        CheckBox chbContent;
        @BindView(R.id.outer_LL)
        LinearLayout outerLL;
        @BindView(R.id.card_view)
        MaterialCardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bind(final CountryList countryList) {
            countryNameTV.setText(countryList.getCountryName());

            countryCapitalTV.setText(countryList.getCountryCapital());
            chbContent.setOnCheckedChangeListener(null);
            chbContent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        forwardList.add(countryList);
                        listener.checkedItems(forwardList);
                    } else {
                        forwardList.remove(countryList);
                    }
                }
            });

        }


    }


}
