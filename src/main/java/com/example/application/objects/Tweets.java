package com.example.application.objects;

import com.google.gson.Gson;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Tweets {

    private ArrayList<Tweet> listadoTweets;

    public Tweets() {
        try {
            File f = new File("tweets_list.json");
            if (f.exists()){
                BufferedReader br = new BufferedReader(new FileReader(new File("tweets_list.json")));
                String linea = "";
                String jsonFile = "";
                while((linea = br.readLine()) != null){
                    jsonFile += linea;
                }
                Tweet[] lista = new Gson().fromJson(jsonFile, Tweet[].class);
                if(jsonFile.length() != 0){
                    this.listadoTweets = new ArrayList<>(Arrays.asList(lista));
                }else{
                    this.listadoTweets = new ArrayList<Tweet>();
                    System.out.println("GOLA");

                }
            }else{
                listadoTweets = new ArrayList<Tweet>();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Tweet> getListadoTweets() {
        return listadoTweets;
    }

    public void setListadoTweets(ArrayList<Tweet> listadoTweets) {
        this.listadoTweets = listadoTweets;
        SaveArrayToFile();

    }

    public void ModifyTweetByIndex(int index,Tweet tweet){


        this.listadoTweets.set(index, tweet);
        SaveArrayToFile();

    }

    public void SetNewTweet(Tweet tweet){
        this.listadoTweets.add(tweet);
        SaveArrayToFile();
    }

    public void SaveArrayToFile(){

        try {
            Notification notification = Notification.show("Acciones realizadas correctamente");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            String JSON = new Gson().toJson(this.listadoTweets);
            File f = new File("tweets_list.json");
            if (!f.exists()){
                f.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("tweets_list.json")));
            bw.write(JSON);
            bw.close();
        } catch (IOException e) {
            Notification notification = Notification.show("Error al realizar cambios");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            throw new RuntimeException(e);
        }
    }
}
