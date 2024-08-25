package page.LoginPage;

import commonActions.CommonActions;
import objectProperty.ElementHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage implements ElementHolder {
    CommonActions commonActions;
    public LoginPage(WebDriver driver) {
        commonActions = new CommonActions(driver);
    }

    public void navigateToLoginPage() throws InterruptedException {
        Thread.sleep(3000);
        commonActions.click(By.xpath(AP_LOGIN_PAGE_SIGNIN_LINK_XPATH));
    }

    public String getTextName(String loginTitle) {
        return commonActions.getText("", loginTitle);
    }

    public Object usernameTextBoxExists() {
        return commonActions.getElement(AP_LOGIN_PAGE_USERNAME_TEXTBOX_CSS, AP_LOGIN_PAGE_USERNAME_TEXTBOX_XPATH);
    }

    public Object passwordTextBoxExists() {
        return commonActions.getElement(AP_LOGIN_PAGE_PASSWORD_TEXTBOX_CSS, AP_LOGIN_PAGE_PASSWORD_TEXTBOX_XPATH);
    }

    public void clickLoginButton() {
        commonActions.click(AP_LOGIN_PAGE_LOGIN_BTN_XPATH);
    }

    public void clickProceedButton(){
        commonActions.click(AP_LOGIN_PAGE_PROCEED_BTN_XPATH);
    }

    public void enterUsername(String username) {
        commonActions.type(AP_LOGIN_PAGE_USERNAME_TEXTBOX_XPATH, username);

    }

    public void enterPassword(String password) {
        commonActions.type(AP_LOGIN_PAGE_PASSWORD_TEXTBOX_XPATH, password);
    }

    public Object getCurrentUrl() {
        return  commonActions.getCurrentUrl();
    }
}