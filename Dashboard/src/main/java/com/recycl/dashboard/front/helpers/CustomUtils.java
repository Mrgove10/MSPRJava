package com.recycl.dashboard.front.helpers;

import com.recycl.dashboard.back.Beans.DemandeEnlevement;

import java.util.ArrayList;
import java.util.List;

public class CustomUtils {
    /**
     * Function to remove duplicates from an ArrayList
     *
     * @param list
     * @return
     */
    public static ArrayList<DemandeEnlevement> removeDuplicates(List<DemandeEnlevement> list) {
        ArrayList<DemandeEnlevement> newList = new ArrayList<DemandeEnlevement>();

        for (DemandeEnlevement element : list) {
            boolean isFind = false;
            for (DemandeEnlevement itemToCompare : newList) {
                if (element.getId() == itemToCompare.getId()) {
                    isFind = true;
                    break;
                }
            }

            if (!isFind) {

                newList.add(element);
            }
        }

        return newList;
    }
}
