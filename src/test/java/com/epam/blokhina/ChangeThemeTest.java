package com.epam.blokhina;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class ChangeThemeTest extends BaseTest{

    private boolean changeThemeSteps() throws InterruptedException {
        return loginSteps.logIn(FIRST_USER_LOGIN, PASSWORD)
                .clickSelectTheme()
                .chooseRandomTheme()
                .verifyConfirmMessage();
    }

    @Test
    public void testChangeTheme() throws InterruptedException {
        assertTrue(changeThemeSteps(), "Verify that theme was changed");
    }
}
