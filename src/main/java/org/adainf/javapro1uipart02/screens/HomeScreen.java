package org.adainf.javapro1uipart02.screens;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.adainf.javapro1uipart02.Application;
import org.adainf.javapro1uipart02.models.Film;

public class HomeScreen {

    private final Scene homeScene;

    public HomeScreen() {
        Pane container = new Pane();
        container.setId("container");

        container.getChildren().addAll(getHeader(), getNavBar(), getFilmSection());

        homeScene = new Scene(container);
        homeScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;700;900");
        homeScene.getStylesheets().add(Application.class.getResource("stylesheets/homescreen.css").toString());
    }

    public Scene getHomeScene() {
        return homeScene;
    }


    private Pane getHeader() {
        FlowPane header = new FlowPane();
        header.setId("header");
        header.setPrefSize(Application.applicationSize[0], 40);
        header.setOrientation(Orientation.VERTICAL);
        header.setAlignment(Pos.CENTER);

        FlowPane titlePane = new FlowPane();
        titlePane.setId("title-pane");
        titlePane.setPrefSize(165, 40);
        titlePane.setAlignment(Pos.CENTER);
        titlePane.setHgap(5);

        ImageView logo = new ImageView(new Image(
                getClass().getResourceAsStream("/org/adainf/javapro1uipart02/images/icons/ic_video.png")
        ));
        logo.setFitHeight(15);
        logo.setFitWidth(15);


        titlePane.getChildren().addAll(logo, new Text("INF CINEMA"));

        FlowPane searchPane = new FlowPane();
        searchPane.setOrientation(Orientation.HORIZONTAL);
        searchPane.setPrefSize(Application.applicationSize[0] - titlePane.getPrefWidth(), 40);
        searchPane.setAlignment(Pos.CENTER_LEFT);
        searchPane.setPadding(new Insets(0, 0, 0, 20));
        searchPane.setHgap(5);

        TextField searchField = new TextField();
        searchField.setPromptText("Search for films...");
        searchField.setFocusTraversable(false);
        searchField.setMinWidth(Application.applicationSize[0] - titlePane.getPrefWidth() - 50);

        ImageView logo2 = new ImageView(new Image(
                getClass().getResourceAsStream("/org/adainf/javapro1uipart02/images/icons/ic_search.png")

                ));

        searchPane.getChildren().addAll(

                logo2, searchField
        );
        logo2.setFitHeight(12);
        logo2.setFitWidth(12);

        header.getChildren().addAll(titlePane, searchPane);

        return header;
    }

    /**
     * This method returns a Pane that contains the navigation bar.
     *
     * @return Pane
     */
    private Pane getNavBar() {
        FlowPane navBar = new FlowPane();
        navBar.setId("navbar");
        navBar.setOrientation(Orientation.HORIZONTAL);
        navBar.setPrefSize(165, Application.applicationSize[1] - 40);
        navBar.setPadding(new Insets(30, 0, 0, 0));
        navBar.relocate(0, 40);
        navBar.getChildren().addAll(
                generateNavItem("New Releases", true),
                generateNavItem("Trending", false),
                generateNavItem("Coming Soon", false),
                generateNavItem("Favourites", false),
                generateNavItem("Watch Later", false));

        return navBar;
    }

    /**
     * This method returns a Pane that contains the film section.
     *
     * @return Pane
     */
    private Pane getFilmSection() {
        FlowPane filmSection = new FlowPane();
        filmSection.setId("film-section");
        filmSection.setPrefSize(Application.applicationSize[0] - 165, Application.applicationSize[1] - 60);
        filmSection.setPadding(new Insets(40, 20, 20, 20));
        filmSection.relocate(165, 40);
        filmSection.setVgap(20);

        FlowPane films = new FlowPane();
        films.setHgap(40);
        films.setVgap(20);
        films.setPrefSize(filmSection.getPrefWidth() - 40, filmSection.getPrefHeight());
        films.getChildren().addAll(Application.filmList.stream().map(this::generateFilmItem).toList());

        Text text = new Text("Christmas Films");
        text.setId("film-hoofd-text");

        filmSection.getChildren().addAll(text, films);

        return filmSection;
    }

    /**
     * Generates a navigation item for the navigation bar
     *
     * @param title  The title of the navigation item
     * @param active Whether the navigation item is active or not
     * @return The navigation item
     */
    private FlowPane generateNavItem(String title, boolean active) {
        FlowPane navItem = new FlowPane();
        navItem.setId("nav-item");
        navItem.setPadding(new Insets(0, 0, 0, 20));
        navItem.setAlignment(Pos.CENTER_LEFT);
        navItem.setPrefSize(165, 35);
        navItem.setHgap(40);

        Text navItemText = new Text(title);
        navItemText.setId("nav-text");

        ImageView arrowIcon = new ImageView(new Image(
                getClass().getResourceAsStream("/org/adainf/javapro1uipart02/images/icons/ic_arrow_right.png")

        ));
        arrowIcon.setId("nav-arrow");
        arrowIcon.setFitHeight(15); // Adjust size as needed
        arrowIcon.setFitWidth(15);
        arrowIcon.setVisible(false); // Initially hidden

        navItem.getChildren().addAll(navItemText, arrowIcon);

        // Add hover effect
        navItem.setOnMouseEntered(e -> {
            arrowIcon.setVisible(true); // Show the arrow
            navItemText.setStyle("-fx-fill: #F83646"); // Change text color
        });



        // Show arrow on hover
        navItem.setOnMouseExited(e -> {
            arrowIcon.setVisible(false);
            navItemText.setStyle("-fx-fill: #797F84;");
        }); // Hide arrow unless active


        //TODO: Check if the nav item is active and change the style accordingly


        return navItem;
    }

    /**
     * Generates a film item for the film section
     *
     * @param film The film to generate the item for
     * @return The generated film item
     */
    private FlowPane generateFilmItem(Film film) {

        FlowPane filmItem = new FlowPane();
        filmItem.setId("film-item");
        filmItem.setOrientation(Orientation.HORIZONTAL);
        filmItem.setMinSize(130, 232);
        filmItem.setVgap(15);

        Pane filmPoster = new Pane();
        filmPoster.setPrefSize(120, 175);

        String posterUrl = film.poster();


            // Load the image using ImageView and add it to the filmPoster pane
            javafx.scene.image.ImageView posterImageView = new javafx.scene.image.ImageView(new javafx.scene.image.Image(posterUrl));
            posterImageView.setFitWidth(120);  // Set the width of the poster image
            posterImageView.setFitHeight(175); // Set the height of the poster image

            // Add the ImageView to the filmPoster pane (no gray background needed)
            filmPoster.getChildren().add(posterImageView);


            FlowPane filmInfo = new FlowPane();
            filmInfo.setOrientation(Orientation.VERTICAL);
            filmItem.setPrefSize(120, 80);

            Text filmTitle = new Text(film.title());
            filmTitle.setId("film-title");
            filmTitle.wrappingWidthProperty().set(120);

            Text filmReleaseDate = new Text(film.releaseDate());
            filmReleaseDate.setId("film-release-date");

            filmInfo.getChildren().addAll(filmTitle, filmReleaseDate);
            filmItem.getChildren().addAll(filmPoster, filmInfo);


            return filmItem;
        }
    }
