package com.example.bykeproject.ui.tools;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.bykeproject.R;

import com.example.bykeproject.model.PackageTest;
import com.example.bykeproject.rest.APIClient;
import com.example.bykeproject.rest.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    EditText name;
    EditText byke;
    EditText email;
    EditText phone;
    EditText amount;
    EditText place;
    Button save;
    Button reset;
    APIInterface apiInterface;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        reset=root.findViewById(R.id.btn_packageReset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                byke.setText("");
                email.setText("");
                phone.setText("");
                amount.setText("");
                place.setText("");
            }
        });
        packageInser(root);
        return root;
    }
    public  void packageInser(final  View root){
      name=root.findViewById(R.id.package_name);
      byke=root.findViewById(R.id.package_bname);
      email=root.findViewById(R.id.package_email);
      phone=root.findViewById(R.id.package_phone);
      amount=root.findViewById(R.id.package_amount);
      place=root.findViewById(R.id.package_location);

      save=root.findViewById(R.id.btn_PackageSubmit);
      save.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            apiInterface= APIClient.getClient().create(APIInterface.class);
            final PackageTest packageTest = new PackageTest();
              packageTest.setName(name.getText().toString());
              packageTest.setByke(byke.getText().toString());
              packageTest.setEmail(email.getText().toString());
              packageTest.setPhone(Integer.parseInt(phone.getText().toString()));
              packageTest.setAmount(Integer.parseInt(amount.getText().toString()));
              packageTest.setPlace(place.getText().toString());


              Call<PackageTest> packageCall = apiInterface.insertPackage(packageTest);
              packageCall.enqueue(new Callback<PackageTest>() {
                  @Override
                  public void onResponse(Call<PackageTest> call, Response<PackageTest> response) {
//                      Log.d("inser fail-------->",response.body().get);
//                      Toast.makeText(getContext(),"Insert Successfull"+response.body().getName(),Toast.LENGTH_LONG).show();
                  }

                  @Override
                  public void onFailure(Call<PackageTest> call, Throwable t) {
                      Toast.makeText(getContext(),"failed",Toast.LENGTH_LONG).show();

                  }
              });
          }
      });
    }
}