package com.projeto.connectbeauty.ui.favoritos;

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

public class FavoritosFragment extends Fragment {

    private FavoritosViewModel favoritosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoritosViewModel =
                ViewModelProviders.of(this).get(FavoritosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favoritos, container, false);

        return root;
    }
}