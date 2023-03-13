package cz.upce.fe.cv02;

import cz.upce.fe.cv02.domain.AppUser;

import java.time.LocalDateTime;

public final class Examples {
    public static final AppUser APP_USER = new AppUser(100L, "st55774", "12345", true, LocalDateTime.now(), LocalDateTime.now());

    private Examples() {
    }
}
