package com.recycl.dashboard.front.helpers;

import javafx.scene.layout.Pane;

import java.util.HashMap;

public class UIPaneHelper {
    public static HashMap<String, Pane> panes;

    /**
     * Initialise the helper
     */
    public static void init() {
        panes = new HashMap<>();
    }

    /**
     * Add a pane to the list of available ones
     *
     * @param name
     * @param pane
     */
    public static void AddPane(String name, Pane pane) {
        panes.put(name, pane);
        pane.setVisible(false);
    }

    /**
     * Show a single pane (based on the given name) by hiding all the over ones at the same time
     *
     * @param name
     */
    public static void Show(String name) {
        for (Pane p : panes.values()) {
            p.setVisible(false);
        }
        panes.get(name).setVisible(true);
    }

    /**
     * Show a single pane (based on the Pane object name) by hiding all the over ones at the same time
     *
     * @param pane
     */
    public static void Show(Pane pane) {
        for (Pane p : panes.values()) {
            if (pane == p) {
                p.setVisible(true);
            } else {
                p.setVisible(false);
            }
        }
    }

    /**
     * Hides a Single pane based on its name
     *
     * @param name
     */
    public static void Hide(String name) {
        panes.get(name).setVisible(false);
    }

    /**
     * Hides all the panes
     * Warning : you might end up with a completly with screen
     */
    public static void HideAll() {
        for (Pane p : panes.values()) {
            p.setVisible(false);
        }
    }
}
