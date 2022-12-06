package com.example.tubesifapps;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tubesifapps.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    private ActivityMainBinding binding;
    protected MainFragment mainFragment;
    protected PengumumanFragment pengumumanFragment;
    protected PertemuanFragment pertemuanFragment;
    protected PramatkulFragment pramatkulFragment;
    protected LoginFragment loginFragment;

    protected FragmentManager fragmentManager;
    protected FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        this.mainFragment = MainFragment.newInstance();
        this.pengumumanFragment = PengumumanFragment.newInstance();
        this.pertemuanFragment = PertemuanFragment.newInstance();
        this.pramatkulFragment = PramatkulFragment.newInstance();
        this.loginFragment = LoginFragment.newInstance();


        this.fragmentManager = this.getSupportFragmentManager();
        ft = this.fragmentManager.beginTransaction();
        ft.add(binding.fragmentContainer.getId(), this.mainFragment).addToBackStack(null).commit();
        setSupportActionBar(binding.toolbar);

        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar, R.string.openDrawer, R.string.closeDrawer);
        binding.drawerLayout.addDrawerListener(abdt);
        abdt.syncState();
    }

    public void changePage(int page) {
        ft = this.fragmentManager.beginTransaction();

        if (page == 1) {
            Log.d("debug", "changePage: page1");
            ft.replace(R.id.fragment_container,this.mainFragment).addToBackStack(null);
        } else if (page == 2) {
            ft.replace(R.id.fragment_container,this.loginFragment).addToBackStack(null);
        } else if (page == 3) {
            ft.replace(R.id.fragment_container,this.pengumumanFragment).addToBackStack(null);
        } else if (page == 4) {
            ft.replace(R.id.fragment_container,this.pertemuanFragment).addToBackStack(null);
        } else if (page == 5) {
            ft.replace(R.id.fragment_container,this.pramatkulFragment).addToBackStack(null);
        }
        this.ft.commit();
        binding.drawerLayout.closeDrawers();
    }
//    @Override
//    public void updateArray(List<Dokter> dokters) {
//        this.adapter.updateArray(dokters);
//    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }
}