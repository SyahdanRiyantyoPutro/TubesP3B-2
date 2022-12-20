package com.example.tubesifapps;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tubesifapps.databinding.ItemListPramatkulBinding;

import java.util.ArrayList;
import java.util.List;

public class PramatkulAdapter extends BaseAdapter {
    private List<Pramatkul> pramatkulList;
    private PramatkulFragment pramatkulFragment;
    ItemListPramatkulBinding binding;

    public PramatkulAdapter (PramatkulFragment pramatkulFragment){
        this.pramatkulFragment = pramatkulFragment;
        this.pramatkulList = new ArrayList<Pramatkul>();
    }

    public void add (List<Pramatkul> title){
        this.pramatkulList = (List<Pramatkul>) title;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return pramatkulList.size();
    }

    @Override
    public Object getItem(int i) {
        return pramatkulList.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        binding = ItemListPramatkulBinding.inflate(this.pramatkulFragment.getLayoutInflater());
        View itemView = binding.getRoot();
        Pramatkul pramatkul = (Pramatkul) this.getItem(i);
        this.binding.tvSmt.setText(pramatkul.getSmtPramatkul());
        return itemView;
    }
}
