package test.LoginTest;

import commonActions.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void NavigateToPage() throws IOException, InterruptedException{
        initDomainObjects(DRIVER);
        String siteUrl = data.getValueByName("url");
        setSiteURL(siteUrl);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void endingTest(){
        //quitDriver();
    }

    @Test
    public void adminUserSignInNavigation() throws InterruptedException{

        loginDom.navigateToLoginPage();
        Thread.sleep(2000);
        Assert.assertNotNull(loginDom.usernameTextBoxExists(),"Username text box is available in login page.");
        Assert.assertNotNull(loginDom.passwordTextBoxExists(),"Password text box is available in login  page.");
    }

    @Test
    public void adminUserSingInWitoutUNPass() throws InterruptedException{
        String usernameError = "//*[@id='username-error']";
        String passwordError = "//*[@id='password-error']";
        loginDom.navigateToLoginPage();
        Thread.sleep(2000);
        loginDom.clickLoginButton();
        Assert.assertEquals(loginDom.getTextName(usernameError), "Email Address is required");
        Assert.assertEquals(loginDom.getTextName(passwordError), "Password is required");
    }

    @Test

    public void adminUserSingInwithInvalidUsername() throws InterruptedException{
        String usernamePasswordError="/html/body/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[2]/span";
        String username = data.getValueByName("AdminPortalInvalidUsername");
        String password = data.getValueByName("AdminPortalValidPassword");
        loginDom.navigateToLoginPage();
        Thread.sleep(2000);
        loginDom.verifyUserLogin(username, password);
        Assert.assertEquals(loginDom.getTextName(usernamePasswordError),"Invalid Email Address or Password. Please Try Again!");
    }

    @Test

    public void adminUserSingInwithInvalidPassword() throws InterruptedException{
        String usernamePasswordError="/html/body/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[2]/span";
        String username = data.getValueByName("AdminPortalValidUsername");
        String password = data.getValueByName("AdminPortalInvalidPassword");
        loginDom.navigateToLoginPage();
        Thread.sleep(2000);
        loginDom.verifyUserLogin(username, password);
        Assert.assertEquals(loginDom.getTextName(usernamePasswordError),"Invalid Email Address or Password. Please Try Again!");
    }

    @Test
    public void adminUserSingInwithValidInformation() throws InterruptedException{

        String username = data.getValueByName("AdminPortalValidUsername");
        String password = data.getValueByName("AdminPortalValidPassword");
        loginDom.navigateToLoginPage();
        Thread.sleep(2000);
        loginDom.verifyUserLogin(username, password);
        Assert.assertEquals(loginDom.getCurrentUrl(),"https://qa.enimbus360.com/Home");
    }
}
