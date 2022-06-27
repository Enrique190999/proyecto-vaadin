package com.example.application.views.main;

import com.example.application.layout.MainLayout;
import com.example.application.objects.Tweet;


import com.example.application.objects.Tweets;
import com.google.gson.Gson;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


@Route(value = "", layout = MainLayout.class)
@PageTitle("Contacts | Vaadin CRM")
public class AltaEdicionView extends VerticalLayout implements HasUrlParameter<Integer> {

    public AltaEdicionView(){
        setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

    }


    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter Integer indice) {
        removeAll();
        if(indice == null){
            Div contenedorImagenTexto = new Div();
            Image imgTwitter = new Image("images/twitter-logo.svg","Logo Twitter");
            imgTwitter.getStyle().set("width","100px");
            contenedorImagenTexto.add(imgTwitter);
            contenedorImagenTexto.add(new H3("Creación de un tweet"));
            add(contenedorImagenTexto);
            TextField textoAutor = new TextField("Autor");
            TextField textoMensaje = new TextField("Mensaje");
            Button botonInsertar = new Button("Insertar");
            botonInsertar.addClickListener(event -> MainLayout.tweets.SetNewTweet(new Tweet(textoAutor.getValue(),textoMensaje.getValue(),new Date(System.currentTimeMillis()))));
            botonInsertar.getStyle().set("margin-top","15px");
            add(textoAutor,textoMensaje,botonInsertar);
        }else{
            try{
                Tweet tweetEdit = MainLayout.tweets.getListadoTweets().get(indice);
                Div contenedorImagenTexto = new Div();
                Image imgTwitter = new Image("images/twitter-logo.svg","Logo Twitter");
                imgTwitter.getStyle().set("width","100px");
                contenedorImagenTexto.add(imgTwitter);
                contenedorImagenTexto.add(new H3("Edición de un tweet"));
                add(contenedorImagenTexto);
                TextField textoAutor = new TextField("Autor");
                textoAutor.setReadOnly(true);
                textoAutor.setValue(tweetEdit.getAutor());

                TextField textoMensaje = new TextField("Mensaje");
                textoMensaje.setValue(tweetEdit.getMensaje());
                Button botonModificar = new Button("Modificar");
                botonModificar.addClickListener(e -> MainLayout.tweets.ModifyTweetByIndex(indice,new Tweet(textoAutor.getValue(),textoMensaje.getValue(),new Date(System.currentTimeMillis()))));
                botonModificar.getStyle().set("margin-top","15px");
                add(textoAutor,textoMensaje,botonModificar);

                add(new H2("Tweet no encontrado"));
            }catch (Exception e){
                add(new H2("Tweet no encontrado"));
            }




        }
    }
}
