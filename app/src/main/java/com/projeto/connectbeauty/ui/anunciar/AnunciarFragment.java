package com.projeto.connectbeauty.ui.anunciar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.projeto.connectbeauty.R;

public class AnunciarFragment extends Fragment {

    private AnunciarViewModel anunciarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        anunciarViewModel =
                ViewModelProviders.of(this).get(AnunciarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_anunciar, container, false);

        return root;
    }
}