package com.example.tubesifapps;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {
    protected List<Pramatkul> pramatkulList;
    protected IMainActivity UI;

    public MainPresenter(IMainActivity ui){
        this.pramatkulList = new ArrayList<>();
        this.UI = ui;
    }
}
