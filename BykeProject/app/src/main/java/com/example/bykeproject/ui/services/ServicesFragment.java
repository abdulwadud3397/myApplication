package com.example.bykeproject.ui.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.bykeproject.R;
import com.example.bykeproject.model.Service;
import com.example.bykeproject.rest.APIClient;
import com.example.bykeproject.rest.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicesFragment extends Fragment {
    EditText name;
    EditText email;
    EditText services;
    EditText phone;
    EditText country;
    EditText message;
    Button save;
    Button reset;
    APIInterface apiInterface;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_service, container, false);

        reset = root.findViewById(R.id.btn_serviceReset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                email.setText("");
                services.setText("");
                phone.setText("");
                country.setText("");
                message.setText("");
            }
        });
        insertService(root);
        return root;

    }
    public  void  insertService(final  View root){
        name = root.findViewById(R.id.service_name);
        email=root.findViewById(R.id.service_email);
        services=root.findViewById(R.id.service_service);
        phone=root.findViewById(R.id.service_phone);
        country = root.findViewById(R.id.service_country);
        message = root.findViewById(R.id.service_message);

        save=root.findViewById(R.id.btn_service_Submit);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiInterface = APIClient.getClient().create(APIInterface.class);
                final  Service service = new Service();
                service.setName(name.getText().toString());
                service.setEmail(email.getText().toString());
                service.setService(services.getText().toString());
                service.setPhone(Integer.parseInt(phone.getText().toString()));
//                service.setCountry(country.getText().toString());
                service.setMessage(message.getText().toString());

                Call<Service>serviceCall = apiInterface.insertService(service);
                serviceCall.enqueue(new Callback<Service>() {
                    @Override
                    public void onResponse(Call<Service> call, Response<Service> response) {

                    }

                    @Override
                    public void onFailure(Call<Service> call, Throwable t) {

                    }
                });
            }
        });

    }

}
