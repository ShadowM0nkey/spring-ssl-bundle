package dev.sagar.clientsslbundledemo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public record Movie(int id, String title, String directorName,
                    @JsonIgnore LocalDate releaseDate) {
}
