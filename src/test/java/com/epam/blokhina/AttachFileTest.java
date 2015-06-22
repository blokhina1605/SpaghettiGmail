package com.epam.blokhina;

import com.epam.blokhina.core.PropertyManager;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class AttachFileTest extends BaseTest {

    private static final String FILE_PATH = PropertyManager.getPropertyByName("filepath");


    private boolean attachFileSteps() throws InterruptedException {
        return loginSteps.logIn(FIRST_USER_LOGIN, PASSWORD)
                .createNewLetter()
                .composeLetter(SECOND_USER_LOGIN, SUBJECT_OF_LETTER + " " + FIRST_USER_LOGIN, CONTENT_OF_LETTER, FILE_PATH)
                .sendLetter()
                .changeUser(SECOND_USER_LOGIN, PASSWORD)
                .goToPage(mainSteps.getMainPage().getInboxPage())
                .verifyLetterWithFilePresent(SUBJECT_OF_LETTER + " " + FIRST_USER_LOGIN);
    }

    @Test
    public void testAttachFile() throws InterruptedException {
        assertTrue(attachFileSteps(), "Verify that message was sent and file was attached");
    }
}
