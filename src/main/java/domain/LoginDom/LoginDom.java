package domain.LoginDom;

import org.openqa.selenium.WebDriver;
import page.LoginPage.LoginPage;

public class LoginDom {

    LoginPage loginPage;

    public LoginDom(WebDriver driver) {
        // TODO Auto-generated constructor stub
        loginPage = new LoginPage(driver);
    }

    public void navigateToLoginPage() throws InterruptedException {
        // TODO Auto-generated method stub
        loginPage.navigateToLoginPage();
    }

    public String getTextName(String loginTitle) {
        // TODO Auto-generated method stub
        return loginPage.getTextName(loginTitle);
    }



    public Object usernameTextBoxExists() {
        // TODO Auto-generated method stub
        return loginPage.usernameTextBoxExists();
    }

    public Object passwordTextBoxExists() {
        // TODO Auto-generated method stub
        return loginPage.passwordTextBoxExists();
    }

    public void clickLoginButton() {
        // TODO Auto-generated method stub
        loginPage.clickLoginButton();
    }

    public Object getCurrentUrl()
    {
        return loginPage.getCurrentUrl();
    }

    public void verifyUserLogin(String username, String password) {
        // TODO Auto-generated method stub
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        loginPage.clickProceedButton();
    }

}
