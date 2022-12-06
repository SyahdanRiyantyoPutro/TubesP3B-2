package com.example.tubesifapps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tubesifapps.databinding.FragmentMainBinding;
import com.example.tubesifapps.databinding.FragmentPengumumanBinding;

public class PengumumanFragment extends Fragment implements View.OnClickListener {
    private FragmentPengumumanBinding binding;
    public PengumumanFragment(){

    }

    public static PengumumanFragment newInstance(){
        PengumumanFragment fragment = new PengumumanFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentPengumumanBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();

        return view;
    }

    @Override
    public void onClick(View v) {

    }

}
