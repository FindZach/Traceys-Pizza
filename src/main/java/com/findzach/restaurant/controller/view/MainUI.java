package com.findzach.restaurant.controller.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 10:06 AM
 */
@Route("hello")
public class MainUI extends VerticalLayout {

    public MainUI() {
        add(new Text("Welcome to MainView."));
    }

}