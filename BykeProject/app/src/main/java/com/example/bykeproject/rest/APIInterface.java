package com.example.bykeproject.rest;

import com.example.bykeproject.model.Booking;
import com.example.bykeproject.model.MultipleResource;
import com.example.bykeproject.model.PackageTest;
import com.example.bykeproject.model.Product;
import com.example.bykeproject.model.Products;
import com.example.bykeproject.model.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();
    @GET("/SpringWH/test")
    Call<List<Products>> getProducts();
//    @POST("/SpringWH/saveProduct")
//    Call<Products> insertProducts(@Body Products p);
    @POST("/SpringWH/savePackage/")
    Call<PackageTest> insertPackage(@Body PackageTest packageTest);

    @GET("/SpringWH/tests")
    Call<List<PackageTest>> getPackage();

    @POST("/SpringWH/saveSell/")
    Call<Products> insertProducts(@Body Products products);

    @POST("/SpringWH/saveBookings/")
    Call<Booking> insertBooking(@Body Booking booking);


    @POST("/SpringWH/saveService/")
    Call<Service> insertService(@Body Service service);



    @POST("/SpringWH/saveSell/")
    Call<Product> insertProducts(@Body Product products);


}
