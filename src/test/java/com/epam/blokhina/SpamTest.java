package com.epam.blokhina;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;


public class SpamTest extends BaseTest{


    private boolean dragAbdDropSteps() throws InterruptedException {
        return loginSteps.logIn(FIRST_USER_LOGIN, PASSWORD)
                .createNewLetter()
                .composeLetter(SECOND_USER_LOGIN, SUBJECT_OF_LETTER + " " + FIRST_USER_LOGIN, CONTENT_OF_LETTER)
                .sendLetter()

                .changeUser(SECOND_USER_LOGIN, PASSWORD)
                .goToPage(mainSteps.getMainPage().getInboxPage())
                .markLetterAsSpam()

                .changeUser(FIRST_USER_LOGIN, PASSWORD)
                .createNewLetter()
                .composeLetter(SECOND_USER_LOGIN, SUBJECT_OF_LETTER + " " + FIRST_USER_LOGIN, CONTENT_OF_LETTER)
                .sendLetter()

                .changeUser(SECOND_USER_LOGIN, PASSWORD)
                .goToPage(mainSteps.getMainPage().getInboxPage())
                .verifyLetterPresent(SUBJECT_OF_LETTER + " " + FIRST_USER_LOGIN);
    }

    @Test
    public void testDragAndDrop() throws InterruptedException {
        assertFalse(dragAbdDropSteps(), "Verify that message was sent and checked as spam");
    }
}
