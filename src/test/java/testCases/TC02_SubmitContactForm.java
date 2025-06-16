package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactPage;
import base.BaseClass;
import utilities.ExcelReader;

import java.time.Duration;


public class TC02_SubmitContactForm extends BaseClass {

    @DataProvider(name = "contactData")
    public Object[][] contactData() throws Exception {
        String path = System.getProperty("user.dir") + "/testData/TestData.xlsx";
        ExcelReader reader = new ExcelReader(path);
        var result = reader.getContactFormData("ContactFormData", true).stream().skip(1).map(r -> new Object[]{r[0], r[1], r[2], r[3], r[4]}).toArray(Object[][]::new);
        return result;
    }
    @Test(dataProvider = "contactData", description = "Submit the 'Contact Form' with valid inputs and validate the success message")
    public void successfulSubmission(String foreName, String surName, String email, String telephone, String message) {

        logger.info("*** Starting successfulSubmission ***");
        //Navigate to the 'Contact' page
        ContactPage cp = new ContactPage(driver);
        cp.clickContactLnk();
        //Enter values to the text fields
        cp.setForename(foreName);
        cp.setSurname(surName);
        cp.setEmail(email);
        cp.setTelephone(telephone);
        cp.setMessage(message);

        //Submit values
        cp.clickSubmitBtn();

        //Wait for the success message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cp.getSuccessMsgLocator())));

        //Validate the 'Success Message'
        String successMsgTxt = cp.getSuccessMsg();
        Assert.assertEquals(successMsgTxt, "Thanks " +foreName+ ", we appreciate your feedback.");
        logger.info("Success message is displayed: " + successMsgTxt);
        cp.clickBackBtn();
        logger.info("*** Finished successfulSubmission ***");
    }
}
