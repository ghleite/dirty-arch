package com.ada.service;

import com.ada.model.User;
import com.ada.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeAll
    public static void beforeAll() {
        MockitoAnnotations.openMocks(UserServiceTest.class);
    }

    @Test
    void createUserSuccessfully() {
        User user = new User("Fulano", LocalDate.parse("2004-04-04"), "fulano@gmail.com");
        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser);
        assertEquals("Fulano", createdUser.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void findUserByNameSuccessfully() {
        User user = new User("Lucio", LocalDate.parse("2000-01-01"), "lucio@gmail.com");
        when(userRepository.findByName("Lucio")).thenReturn(Optional.of(user));

        User foundUser = userService.getUserByName("Lucio");

        assertEquals("Lucio", foundUser.getName());
        verify(userRepository, times(1)).findByName("Lucio");
    }

    @Test
    void findUserByNameNotFound() {
        when(userRepository.findByName("unknown")).thenReturn(Optional.empty());

        User foundUser = userService.getUserByName("unknown");

        assertNull(foundUser);
        verify(userRepository, times(1)).findByName("unknown");
    }
}