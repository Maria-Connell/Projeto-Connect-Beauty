package com.projeto.connectbeauty.ui.meuserv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MeuServViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MeuServViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}