package com.example.tubesifapps;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.tubesifapps.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment implements View.OnClickListener{
    private FragmentLoginBinding binding;
    private FragmentListener fragmentListener;

    public LoginFragment(){

    }

    public static LoginFragment newInstance(){
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the Layout for this fragment
        this.binding = FragmentLoginBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();

        this.binding.btnLogin.setOnClickListener(this);
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
        if(v==binding.btnLogin && this.binding.etEmailLogin.getText().length() > 0) {
            this.fragmentListener.changePage(3);
        }
    }
}
