package com.example.tubesifapps;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tubesifapps.databinding.FragmentMainBinding;

public class MainFragment extends Fragment implements View.OnClickListener {
    private FragmentMainBinding binding;
    private FragmentListener fragmentListener;

    public MainFragment(){

    }

    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();

        this.binding.btnLoginMain.setOnClickListener(this);
        return view;
    }

    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.fragmentListener = (FragmentListener) context;
        }
        else{
            throw new ClassCastException(context.toString()+"Must implement fragment listener");
        }
    }

    @Override
    public void onClick(View v) {
        if(v==binding.btnLoginMain) {
            this.fragmentListener.changePage(2);
        }
    }
}
