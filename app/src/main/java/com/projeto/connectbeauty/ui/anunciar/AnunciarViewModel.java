package com.projeto.connectbeauty.ui.anunciar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnunciarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AnunciarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}