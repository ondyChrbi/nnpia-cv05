package cz.upce.fe.cv02.service;

import cz.upce.fe.cv02.repository.AppUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static cz.upce.fe.cv02.Examples.APP_USER;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppUserServiceTest {
    @Autowired
    private AppUserService appUserService;

    @MockBean
    private AppUserRepository appUserRepository;

    @BeforeEach
    void setUp() {
        Mockito.when(appUserRepository.findById(100L)).thenReturn(Optional.of(APP_USER));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() throws ResourceNotFoundException {
        var actual = appUserService.findById(100L);

        assertEquals(APP_USER, actual);
    }
}