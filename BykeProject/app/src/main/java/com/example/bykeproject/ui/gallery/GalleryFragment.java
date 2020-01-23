package com.example.bykeproject.ui.gallery;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.bykeproject.R;
import com.example.bykeproject.model.Product;
import com.example.bykeproject.rest.APIClient;
import com.example.bykeproject.rest.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GalleryFragment extends Fragment  {

    private GalleryViewModel galleryViewModel;
    EditText name;
    EditText qty;
    EditText price;
    EditText type;
    EditText color;
    EditText date;
    Button save;
    Button reset;
    double res;
    APIInterface  apiInterface;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);

reset = root.findViewById(R.id.reset_sell_Submit);
reset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        name.setText("");
        qty.setText("");
        price.setText("");
        type.setText("");
        color.setText("");
        date.setText("");
    }

});
//                Call<Product>productCall = apiInterface.insertProducts(products);
//                productCall.enqueue(new Callback<Product>() {
//                    @Override
//                    public void onResponse(Call<Product> call, Response<Product> response) {
//                    Toast.makeText(getContext(),"insrt sucessful",Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<Product> call, Throwable t) {
//                        Toast.makeText(getContext(),"failed",Toast.LENGTH_SHORT).show();
//                    }
//                });
        inserProducts(root);
        return root;
    }

public  void inserProducts(final View root){
        name=root.findViewById(R.id.products_name);
        qty = root.findViewById(R.id.products_qty);
        price=root.findViewById(R.id.products_price);
        type=root.findViewById(R.id.products_type);
        color=root.findViewById(R.id.products_Color);
        date=root.findViewById(R.id.products_date);

        save = root.findViewById(R.id.btn_SellSubmit);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiInterface = APIClient.getClient().create(APIInterface.class);
                final Product product = new Product();
                product.setName(name.getText().toString());
                product.setQty(Integer.parseInt(qty.getText().toString()));
                product.setPrice(Integer.parseInt(price.getText().toString()));
                product.setType(type.getText().toString());
                product.setColor(color.getText().toString());
                product.setDate(date.getText().toString());
                String pr = price.getText().toString();
                double mnum2 = Double.parseDouble(pr);

                String qt = qty.getText().toString();
                Integer mnum = Integer.parseInt(qt);

                res = mnum2 * mnum;
                product.setTotal(res);

                Call<Product>productCall = apiInterface.insertProducts(product);
                productCall.enqueue(new Callback<Product>() {
                    @Override
                    public void onResponse(Call<Product> call, Response<Product> response) {

                    }

                    @Override
                    public void onFailure(Call<Product> call, Throwable t) {

                    }
                });
            }
        });
}
}
