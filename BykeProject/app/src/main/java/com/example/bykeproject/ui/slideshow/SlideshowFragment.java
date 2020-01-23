package com.example.bykeproject.ui.slideshow;

//import android.app.DatePickerDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.bykeproject.R;

import com.example.bykeproject.model.Booking;
import com.example.bykeproject.rest.APIClient;
import com.example.bykeproject.rest.APIInterface;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    EditText name;
    EditText email;
    EditText phone;
    EditText bname;
    EditText version;
    EditText color;
    EditText destination;
    EditText location;
    EditText date;
    Button save;
    Button reset;
    APIInterface apiInterface;
    DatePickerDialog pickerDialog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final  TextView textView = root.findViewById(R.id.text_slideshow);
        reset = root.findViewById(R.id.booking_btn_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                email.setText("");
                phone.setText("");
                bname.setText("");
                date.setText("");
                version.setText("");
                color.setText("");
                destination.setText("");
                location.setText("");
                date.setText("");
            }
        });
        date=root.findViewById(R.id.booking_date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker picker = new DatePicker(getContext());

                int currentday=picker.getDayOfMonth();
                int currentMonth = picker.getMonth();
                int currentYear = picker.getYear();

                pickerDialog=new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth+ " / " + month+ " / " + year);

                    }
                },currentday,currentMonth,currentYear);

                pickerDialog.show();

            }
        });

//        final TextView textView = root.findViewById(R.id.text_slideshow);
//        slideshowViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
       bookinginsert(root);
        return root;

    }
public  void  bookinginsert(final View root){
        name=root.findViewById(R.id.booking_Cust_name);
        email=root.findViewById(R.id.booking_email);
        phone=root.findViewById(R.id.booking_phone);
        destination = root.findViewById(R.id.booking_destination);
        date=root.findViewById(R.id.booking_date);
        location = root.findViewById(R.id.booking_picked_location);
        bname = root.findViewById(R.id.booking_brandname);
        color=root.findViewById(R.id.bookig_color);
        version=root.findViewById(R.id.booking_version);

        save=root.findViewById(R.id.btn_bookingSubmit);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiInterface = APIClient.getClient().create(APIInterface.class);

                final  Booking booking = new Booking();

                booking.setName(name.getText().toString());
                booking.setEmail(email.getText().toString());
                booking.setPhone(Integer.parseInt(phone.getText().toString()));
                booking.setBname(bname.getText().toString());
                booking.setVersion(version.getText().toString());
                booking.setBcolor(color.getText().toString());
                booking.setDestination(destination.getText().toString());
                booking.setLocation(location.getText().toString());
                booking.setDate(date.getText().toString());


              Call<Booking>bookingCall = apiInterface.insertBooking(booking);
              bookingCall.enqueue(new Callback<Booking>() {
                  @Override
                  public void onResponse(Call<Booking> call, Response<Booking> response) {

                  }

                  @Override
                  public void onFailure(Call<Booking> call, Throwable t) {

                  }
              });
            }
        });
}
}