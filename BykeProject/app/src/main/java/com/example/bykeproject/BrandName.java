package com.example.bykeproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BrandName extends Activity {
    private Spinner spinner;
    private Spinner spinnerColor;
    private Spinner typeSpinner;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }

    // add items into spinner dynamically
//    public void addItemsOnSpinner2() {
//
//        spinner2 = (Spinner) findViewById(R.id.spinner);
//        List<String> list = new ArrayList<>();
//        list.add("list 1");
//        list.add("list 2");
//        list.add("list 3");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(dataAdapter);
//    }

    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner) findViewById(R.id.spinner);
        spinnerColor = (Spinner) findViewById(R.id.spinnerColor);
//        typeSpinner = (Spinner)findViewById(R.id.spinner_type);
        spinner.setOnItemSelectedListener(new  CustomOnItemSelectedListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner = (Spinner) findViewById(R.id.spinner);
       spinnerColor = (Spinner) findViewById(R.id.spinnerColor);
//       typeSpinner = (Spinner)findViewById(R.id.spinner_type);
//        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(BrandName.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : "+ String.valueOf(spinner.getSelectedItem()) ,
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}
//    String pr=price.getText().toString();
//    double mnum2=Double.parseDouble(pr);
//
//    String qt=qty.getText().toString();
//    int mnum=Integer.parseInt(qt);
//
//                res=mnum2 * mnum;
//                        product.setTotal(res);
//                        double res;