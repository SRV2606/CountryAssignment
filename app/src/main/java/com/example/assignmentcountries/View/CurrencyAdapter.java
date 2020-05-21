package com.example.assignmentcountries.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentcountries.Model.CountryList;
import com.example.assignmentcountries.Model.Currencyy;
import com.example.assignmentcountries.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.MyViewHolder> {
    private final Context mContext;
    private final List<CountryList> mResult;
    boolean showText = false;

    public CurrencyAdapter(Context applicationContext, List<CountryList> results) {

        this.mContext = applicationContext;
        this.mResult = results;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list1, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.bind(mResult.get(position));


    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    public class
    MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        @BindView(R.id.countryNameTV)
        TextView countryNameTV;
        @BindView(R.id.countryCurrencyTV)
        TextView countryCurrencyTV;
        @BindView(R.id.inner_LL)
        LinearLayout innerLL;
        @BindView(R.id.cart_decrement)
        ImageView cartDecrement;
        @BindView(R.id.cart_product_quantity_tv)
        TextView cartProductQuantityTv;
        @BindView(R.id.cart_increment)
        ImageView cartIncrement;
        @BindView(R.id.cart_plus_minus_layout)
        LinearLayout cartPlusMinusLayout;
        @BindView(R.id.outer_LL)
        LinearLayout outerLL;
        @BindView(R.id.card_view)
        MaterialCardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            cartIncrement.setOnClickListener(this);
            cartDecrement.setOnClickListener(this);
        }


        public void bind(final CountryList countryList) {

            countryNameTV.setText(countryList.getCountryName());
            setUpCurrency(countryList.getCurrencies());
            final int quantity = countryList.getQuantity();
            cartIncrement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countryList.setQuantity(quantity + 1);
                    notifyDataSetChanged();
                }
            });
            cartDecrement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (quantity > 1) {
                        countryList.setQuantity(quantity - 1);
                        notifyDataSetChanged();
                    } else {
                        Toast.makeText(mContext, "Currency value not accepted", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            cartProductQuantityTv.setText(String.valueOf(quantity));
        }

        public void setUpCurrency(List<Currencyy> currency) {
            if (currency != null) {
                for (int i = 0; i < currency.size(); i++) {
                    currency(currency.get(i));
                }
            }

        }

        public void currency(Currencyy currencyy) {

            if (currencyy != null) {
                countryCurrencyTV.setText(currencyy.getSymbol());
            }

        }


        @Override
        public void onClick(View v) {

        }
    }
}

