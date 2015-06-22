package com.epam.blokhina;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class DragAndDropTest extends BaseTest {

    private boolean dragAbdDropSteps() throws InterruptedException {
        return loginSteps.logIn(FIRST_USER_LOGIN, PASSWORD)
                .createNewLetter()
                .composeLetter(SECOND_USER_LOGIN, SUBJECT_OF_LETTER + " " + FIRST_USER_LOGIN, CONTENT_OF_LETTER)
                .sendLetter()
                .changeUser(SECOND_USER_LOGIN, PASSWORD)
                .goToPage(mainSteps.getMainPage().getInboxPage())
                .dragLetterToStarred()
                .goToPage(mainSteps.getMainPage().getStarredPage())
                .verifyLetterPresent(SUBJECT_OF_LETTER + " " + FIRST_USER_LOGIN);

    }

    @Test
    public void testDragAndDrop() throws InterruptedException {
        assertTrue(dragAbdDropSteps(), "Verify that message was sent and drag&Drop was performed");
    }
}
