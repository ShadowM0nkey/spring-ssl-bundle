package dev.sagar.serversslbundledemo;

import java.time.LocalDate;

public record Movie(int id, String title, String directorName,
                    LocalDate releaseDate) {
}
