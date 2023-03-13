package cz.upce.fe.cv02.service;

import cz.upce.fe.cv02.domain.AppUser;
import cz.upce.fe.cv02.repository.AppUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static cz.upce.fe.cv02.Examples.APP_USER;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppUserServiceTest {
    private AppUser existing = null;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserRepository appUserRepository;

    @BeforeEach
    void setUp() {
        existing = appUserRepository.save(APP_USER);
    }

    @AfterEach
    void tearDown() {
        appUserRepository.deleteAll();
    }

    @Test
    void findById() throws ResourceNotFoundException {
        var actual = appUserService.findById(existing.getId());

        assertEquals(existing, actual);
    }
}