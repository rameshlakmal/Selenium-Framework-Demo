package commonActions;

import data.Dataprovider;
import domain.LoginDom.LoginDom;
import objectProperty.ElementHolder;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestBase implements ElementHolder {


    protected static WebDriver DRIVER;

    //protected FormFiller formFiller;
    public static Dataprovider data; // Create a variable call data with
    // Dataprovider class type
    protected CommonActions commonActions;
    protected LoginDom loginDom;

    public void initDomainObjects(WebDriver driver) throws IOException {
        loginDom= new LoginDom(driver);


        data = new Dataprovider(); // Create object of Dataprovider class
        System.out.println("**************** START TESTING ****************");
    }

    public void setSiteURL(String siteUrl) {
        commonActions = new CommonActions(DRIVER);
        commonActions.enterURL(siteUrl);
    }

    public void quitDriver() {
        commonActions.endDriver();
    }

    public void setmailinatorURL(String mailinatorURL) {
        commonActions = new CommonActions(DRIVER);
        commonActions.enterURL(mailinatorURL);
    }



}
