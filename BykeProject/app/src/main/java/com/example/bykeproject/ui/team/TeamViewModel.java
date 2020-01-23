package com.example.bykeproject.ui.team;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TeamViewModel extends ViewModel {
    private MutableLiveData<String> nText;
    public TeamViewModel() {
        nText = new MutableLiveData<>();
        //nText.setValue("This is team fragment");
    }

    public LiveData<String> getText() {
        return nText;
    }
}
