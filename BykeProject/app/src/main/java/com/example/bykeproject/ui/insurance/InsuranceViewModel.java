package com.example.bykeproject.ui.insurance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InsuranceViewModel extends ViewModel {
     private MutableLiveData<String>mtext;

     public InsuranceViewModel(){
          mtext = new MutableLiveData<>();
         // mtext.setValue("Insurance");
     }
     public LiveData<String> getText() {
          return mtext;
     }
}
