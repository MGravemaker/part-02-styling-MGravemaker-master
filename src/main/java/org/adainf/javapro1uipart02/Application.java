package org.adainf.javapro1uipart02;

import javafx.stage.Stage;
import org.adainf.javapro1uipart02.models.Film;

import org.adainf.javapro1uipart02.screens.HomeScreen;




import java.util.ArrayList;

public class Application extends javafx.application.Application {

    public static int[] applicationSize = {1200, 650};


    public static ArrayList<Film> filmList = new ArrayList<>() {{
        add(new Film("The Nightmare Before Christmas", "1993", "the_nightmare_before_christmas.png"));
        add(new Film("How the Grinch Stole Christmas", "2000", "how_the_grinch_stole_christmas.png"));
        add(new Film("National Lampoon's Christmas Vacation", "1989", "national_lampoons_christmas_vacation.png"));
        add(new Film("A Christmas Story", "1983", "a_christmas_story.png"));
        add(new Film("A Christmas Carol", "2009", "a_christmas_carol.png"));
        add(new Film("Office Christmas Party", "2016", "office_christmas_party.png"));
        add(new Film("Last Christmas", "2019", "last_christmas.png"));
        add(new Film("The Christmas Chronicles", "2018", "the_christmas_chronicles.png"));

 


    }};
    // This method prints out each film's ID and Title






    @Override
    public void start(Stage stage) {
        stage.setWidth(applicationSize[0]);
        stage.setHeight(applicationSize[1]);
        stage.setResizable(false);
        stage.setTitle("Ad Cinema");


        stage.setScene(new HomeScreen().getHomeScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}