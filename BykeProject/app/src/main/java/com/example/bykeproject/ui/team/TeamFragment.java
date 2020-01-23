package com.example.bykeproject.ui.team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bykeproject.R;
import com.example.bykeproject.model.Products;
import com.example.bykeproject.rest.APIClient;
import com.example.bykeproject.rest.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamFragment extends Fragment {
    private TeamViewModel teamViewModel;

    TableLayout tableLayout;

    List<Products> staff=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        teamViewModel =
                ViewModelProviders.of(this).get(TeamViewModel.class);
        View root = inflater.inflate(R.layout.fragment_team, container, false);
        final TextView textView = root.findViewById(R.id.text_team);
//        teamViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        tableLayout = root.findViewById(R.id.tableview);
        loadTable();

        APIInterface apiInterface= APIClient.getClient().create(APIInterface.class);
        final Call<List<Products>> staffList = apiInterface.getProducts();
        staffList.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                staff = response.body();

                TableRow tableRow1 = new TableRow(getContext());
                tableRow1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
                TextView header1 = new TextView(getContext());
                header1.setText("Quantity");
                header1.setTextSize(15);
                tableRow1.addView(header1,0);

                TextView header2 = new TextView(getContext());
                header2.setText("Price");
                header2.setTextSize(15);
                tableRow1.addView(header2,1);

                TextView header3 = new TextView(getContext());
                header3.setText("Total Sell");
                header3.setTextSize(15);
                tableRow1.addView(header3,2);


                tableLayout.addView(tableRow1,new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.MATCH_PARENT));
                loadTable();

            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });


        return root;
    }
    public void loadTable() {


        for (int i = 0; i < staff.size(); i++) {
            TableRow row = new TableRow(getContext());
            TextView qty = new TextView(getContext());
            TextView price = new TextView(getContext());
            TextView totalSell = new TextView(getContext());

            qty.setText(Integer.toString(staff.get(i).getQty()));
            price.setText(Double.toString(staff.get(i).getPrice()));
            totalSell.setText(Double.toString(staff.get(i).getPrice()));




            row.addView(qty, 0);
            row.addView(price, 1);
            row.addView(totalSell, 2);

            tableLayout.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }
}
