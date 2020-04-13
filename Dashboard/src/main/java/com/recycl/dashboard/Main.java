package com.recycl.dashboard;

import com.recycl.dashboard.back.MainBDD;
//import com.recycl.dashboard.front.MainUI;

public class Main {
    public static void main(String[] args) {
        MainBDD bdd =new MainBDD();
        bdd.startBDD();
//        MainUI ui = new MainUI();
//        ui.init();
    }
}



