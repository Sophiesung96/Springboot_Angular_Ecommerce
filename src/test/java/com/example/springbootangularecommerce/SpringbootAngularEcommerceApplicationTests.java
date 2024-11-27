package com.example.springbootangularecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringbootAngularEcommerceApplicationTests {

    @Autowired
    private UserDetailsManager userDetailsManager;

    @Test
    public void testUserAuthentication() {
        // Load user by username
        UserDetails user = userDetailsManager.loadUserByUsername("john");

        // Assertions to verify user details
        assertNotNull(user, "User should not be null");
        assertEquals("john", user.getUsername(), "Username should match");

        // Print user information for debug purposes
        System.out.println("Username: " + user.getUsername());
        System.out.println("Authorities: " + user.getAuthorities());
    }
}
