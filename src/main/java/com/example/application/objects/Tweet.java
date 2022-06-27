package com.example.application.objects;

import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;

public class Tweet {

  private String autor, mensaje;
  private Date fecha;

    public Tweet(String autor, String mensaje, Date fecha) {
        this.autor = autor;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String GetPrettyDate(){
        PrettyTime p = new PrettyTime();
        return p.format(this.fecha);
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "autor='" + autor + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
