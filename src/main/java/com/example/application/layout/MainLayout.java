package com.example.application.layout;

import com.example.application.objects.Tweets;
import com.example.application.views.main.AltaEdicionView;
import com.example.application.views.main.ListadoView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

import javax.swing.text.html.ListView;

public class MainLayout extends AppLayout {

    public static Tweets tweets = new Tweets();

    public MainLayout() {

        createDrawer();
    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("Alta y edición", AltaEdicionView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());
        RouterLink listListado = new RouterLink("Listado", ListadoView.class);
        addToDrawer(new VerticalLayout(
                listLink,listListado
        ));
    }
}
