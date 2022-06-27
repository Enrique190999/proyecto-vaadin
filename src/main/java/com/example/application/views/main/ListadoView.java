package com.example.application.views.main;

import com.example.application.layout.MainLayout;
import com.example.application.objects.Tweet;
import com.example.application.objects.Tweets;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;

@Route(value = "listado", layout = MainLayout.class)
@PageTitle("Contacts | Vaadin CRM")
public class ListadoView extends VerticalLayout {

    public ListadoView(){
        if(MainLayout.tweets.getListadoTweets().size() != 0){
            for(Tweet a: MainLayout.tweets.getListadoTweets()){
                HorizontalLayout hl = new HorizontalLayout();
                VerticalLayout vl = new VerticalLayout();
                vl.getStyle().set("width","100%");
                Image img = new Image("images/twitter-logo.svg","Logo de Twitter");
                img.getStyle().set("width","120px");
                H3 mensaje = new H3(a.getMensaje());
                H4 textoTweet = new H4("-- " + a.getAutor() + ". " + a.GetPrettyDate() );
                textoTweet.getStyle().set("font-style","italic");
                textoTweet.getStyle().set("font-size","1rem");
                Button botonEditar = new Button("Editar");
                botonEditar.addClickListener(e -> RedirectURIWithParams(a) );
                // getUI().ifPresent(action -> action.navigate("/" + MainLayout.tweetsGLO.getListadoTweets().indexOf(tweetToFind)));
                hl.add(img,vl);
                vl.add(mensaje,textoTweet,botonEditar);
                add(hl);
            }
        }

    }

    public void RedirectURIWithParams(Tweet tweet){
        getUI().ifPresent(action -> action.navigate("/" + MainLayout.tweets.getListadoTweets().indexOf(tweet)));
    }
}
