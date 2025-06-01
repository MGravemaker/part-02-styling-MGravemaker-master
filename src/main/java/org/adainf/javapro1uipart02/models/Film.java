package org.adainf.javapro1uipart02.models;

import org.adainf.javapro1uipart02.Application;

import java.util.Objects;

public record Film(String title, String releaseDate, String poster) {

    @Override
    public String poster() {
        try {
            return Objects.requireNonNull(Application.class.getResource("images/posters/" + this.poster)).toString();
        } catch (Exception e) {
            return null;
        }
    }
}
