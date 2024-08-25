package commonActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonActions {

    private static CommonActions myObj;

    public static WebDriver driver;

    String browserName;

    /**
     * Create Selenium driver according to the given browser
     *
     * @return driver
     */



    public WebDriver getdriver() {
        driver = null;

        browserName = TestBase.data.getValueByName("browser");


        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\rames\\Desktop\\Selenium_POM_DEMO\\src\\main\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(options);
            System.out.println("STARTING CHROME BROWSER..............");
        }


        return driver;

    }
    public CommonActions(WebDriver driver) {
        // TODO Auto-generated constructor stub
    }


    /**
     * Set the site URL
     *
     * @param siteUrl
     *            - site URL
     */
    public void enterURL(String siteUrl) {
        driver = getdriver();
        driver.get(siteUrl);
        driver.manage().window().maximize();
    }

    public void endDriver() {
        // TODO Auto-generated method stub
        System.out.println("CLOSING BROWSER...........");
        driver.quit();
        System.out.println("***************** END TESTING *****************");
    }

    public void openTab(String mailinatorURL) {
        driver = getdriver();
        driver.get(mailinatorURL);
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

    }

    // *******************getEliment functions*************************

    // Get element by CSS, ID, name and xPath
    /**
     * This is to find the element by CSS, ID, Name and XPath.
     *
     * @param cSS
     * @param id
     * @param name
     * @param xPath
     * @return Return the created object of the element
     */
    public WebElement getElement(String cSS, String id, String name, String xPath) {

        WebElement element;

        try {
            element = driver.findElement((By.id(id)));

        } catch (Exception e) {

            try {
                element = driver.findElement((By.name(name)));

            } catch (Exception e1) {

                try {
                    element = driver.findElement((By.xpath(xPath)));
                } catch (Exception e2) {

                    element = driver.findElement((By.cssSelector(cSS)));
                }

            }

        }

        return element;
    }

    /**
     * This is to find the element by CSS, Name and XPath.
     *
     * @param cSS
     * @param name
     * @param xPath
     * @return Return the created object of the element
     */
    // Get element by CSS, name and xPath
    public WebElement getElement(String cSS, String name, String xPath) {

        WebElement element;

        try {
            element = driver.findElement((By.name(name)));

        } catch (Exception e) {

            try {
                element = driver.findElement((By.xpath(xPath)));

            } catch (Exception e1) {

                element = driver.findElement((By.cssSelector(cSS)));

            }

        }

        return element;
    }

    /**
     * This is to find the element by CSS and XPath.
     *
     * @param cSS
     * @param xPath
     * @return Return the created object of the element
     */
    // Get element by CSS and xPath
    public WebElement getElement(String cSS, String xPath) {

        WebElement element;

        try {
            element = driver.findElement((By.xpath(xPath)));

        } catch (Exception e) {

            element = driver.findElement((By.cssSelector(cSS)));
        }

        return element;
    }

    /**
     * This is to find the list of element by CSS and XPath.
     *
     * @param cSS
     * @param xPath
     * @return Return the created list object of the element
     */
    // Get list of element by CSS and xPath
    public List<WebElement> getElements(String cSS, String xPath) {

        List<WebElement> elements;

        try {
            elements = driver.findElements((By.xpath(xPath)));

        } catch (Exception e) {
            elements = driver.findElements((By.cssSelector(cSS)));

        }

        return elements;
    }

    // Get list of element by tag
    /**
     *
     * @param tag
     * @return
     */
    public List<WebElement> getElements(String tag) {

        List<WebElement> elements;

        elements = driver.findElements((By.tagName(tag)));

        return elements;
    }

    // ******************************* function for type
    // *********************************
    // Selenium type function with parameter CSS, id, name and xPath

    /**
     *
     * @param xPath
     * @param textToEnter
     */
    public void type(String xPath, String textToEnter) {
        WebElement textBox = driver.findElement(By.xpath(xPath));
        textBox.sendKeys(textToEnter);
    }

    public void typeID(String id, String textToEnter) {
        WebElement textBox = driver.findElement(By.id(id));
        textBox.sendKeys(textToEnter);
    }


    /**
     *
     * @param cSS
     * @param objectName
     * @param xPath
     * @param textToEnter
     */
//    public void type(String cSS, String objectName, String xPath, String textToEnter) {
//        getElement(cSS, objectName, xPath).sendKeys(textToEnter);
//    }

    /**
     *
     * @param id
     * @param xPath
     * @param textToEnter
     */
    public void type(String xPath, String id, String textToEnter) {
        getElement(xPath, id).sendKeys(textToEnter);
    }

    // ******************************* function for click
    // *********************************

    /**
     * Click event by CSS, ID, Name and XPath
     *
     * @param xPath
     * @param cSS
     * @param id
     * @param name
     */
    public void click(String xPath, String cSS, String id, String name) {
        getElement(cSS, id, name, xPath).click();
    }

    /**
     *
     * @param xPath
     */
    public void click(String xPath) {
        driver.findElement(By.xpath(xPath)).click();
    }



    public void iFrame()
    {
        driver.switchTo().frame("publicshowmaildivcontent");
    }

    public void chromeSwitchToTab() {
        // TODO Auto-generated method stub
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

    }


    public void click(By by) {
        driver.findElement(by).click();
    }

    // ******************************* function for get the text
    // *********************************

    public String getText(By by) {

        return driver.findElement(by).getText();

    }

    public String getText(String css, String id, String name, String xpath) {

        String text;

        text = getElement(css, id, name, xpath).getText();

        return text;

    }

    public String getText(String css, String xpath) {

        String text;

        text = getElement(css, xpath).getText();

        return text;

    }



    public String getTextCSS(String css) {

        String text;

        text = getText(By.cssSelector(css));

        return text;

    }

    public String getTextXPATH(String xpath) {

        String text;

        text = getText(By.xpath(xpath));

        return text;

    }

    // ******************************* function for select value from dropdown
    // *********************************

    public void selectByValue(By by, String value) {

        new Select(driver.findElement(by)).selectByValue(value);
        driver.findElement(By.xpath("//body")).click();


    }

    public void selectByVisibleText(By by, String text) {

        new Select(driver.findElement(by)).selectByVisibleText(text);

    }

    public void selectByVisibleText(String css, String id, String name, String xpath, String text) {

        new Select(getElement(css, id, name, xpath)).selectByVisibleText(text);

    }

    public void selectByVisibleText(String css, String xpath, String text) {

        new Select(getElement(css, xpath)).selectByVisibleText(text);

    }

    public void selectByVisibleTextAndWait(By by, String text) {

        new Select(driver.findElement(by)).selectByVisibleText(text);

    }

    public String getSelectedText(By by) {

        return new Select(driver.findElement(by)).getFirstSelectedOption().getText();
    }

    public String getSelectedText(String css, String id, String name, String xpath) {

        return new Select(getElement(css, id, name, xpath)).getFirstSelectedOption().getText();
    }

    public int getOptionCount(String css, String id, String name, String xpath) {

        return new Select(getElement(css, id, name, xpath)).getOptions().size();
    }


    public List<String> getSelectList(String css, String id, String name, String xpath) {

        List<String> list = null;
        List<WebElement> options;
        Select select;

        select = new Select(getElement(css, id, name, xpath));

        options = select.getOptions();

        for (WebElement option : options) {

            list.add(option.getText());

        }

        return list;

    }

    public void selectDateFromDatepicker(String datePickerXpath, String selectDate) throws InterruptedException {
        // TODO Auto-generated method stub
        String day;
        String monthYear;
        String currMonthYear;

        // Splitting a date and month
        String dateSplitter[] = selectDate.split("-");
        day = dateSplitter[0];
        monthYear = dateSplitter[1];
        System.out.println(day);
        System.out.println(monthYear);

        Thread.sleep(2000);

        WebElement calElement = driver.findElement(By.xpath(datePickerXpath));
        calElement.click();

        currMonthYear = driver
                .findElement(By
                        .xpath("//div[2][@class='Zebra_DatePicker dp_visible']/table[@class='dp_header']/tbody/tr/td[@class='dp_caption']"))
                .getText();

        if (currMonthYear.equals(monthYear)) {
            List<WebElement> days = driver.findElements(By
                    .xpath("//div[2][@class='Zebra_DatePicker dp_visible']/table[@class='dp_daypicker']/tbody/tr/td"));

            for (WebElement d : days) {
                if (d.getText().equals(day)) {
                    d.click();
                }
            }
        } else {
            do {
                driver.findElement(By
                                .xpath("//div[2][@class='Zebra_DatePicker dp_visible']/table[@class='dp_header']/tbody/tr/td[3]"))
                        .click();
                currMonthYear = driver
                        .findElement(By
                                .xpath("//div[2][@class='Zebra_DatePicker dp_visible']/table[@class='dp_header']/tbody/tr/td[@class='dp_caption']"))
                        .getText();
            } while (!currMonthYear.equals(monthYear));
            List<WebElement> days = driver.findElements(By
                    .xpath("//div[2][@class='Zebra_DatePicker dp_visible']/table[@class='dp_daypicker']/tbody/tr/td"));
            for (WebElement d : days) {
                if (d.getText().equals(day)) {
                    d.click();
                }
            }
        }
    }

    public void selectDateFromBasicDatepicker(String datePickerXpath, String selectDate) {

        String day;
        String month;
        String year;
        String monthYear;
        String monthInThree;

        // Splitting day, Month and Year
        String dateSplitter[] = selectDate.split("-");
        day = dateSplitter[0];
        monthYear = dateSplitter[1];
        String yerMonthSplit[] = monthYear.split(",");
        month = yerMonthSplit[0].trim();
        year = yerMonthSplit[1].trim();

        monthInThree = month.substring(0, 3);

        System.out.println(monthInThree);

        WebElement calElement = driver.findElement(By.xpath(datePickerXpath));
        calElement.click();

        driver.findElement(
                        By.xpath("//div[2][@class='Zebra_DatePicker dp_visible']/table[@class='dp_header']/tbody/tr/td[2]"))
                .click();
        driver.findElement(
                        By.xpath("//div[2][@class='Zebra_DatePicker dp_visible']/table[@class='dp_header']/tbody/tr/td[2]"))
                .click();

        // Select year
        List<WebElement> yearLists = driver.findElements(
                By.xpath("//div[2][@class='Zebra_DatePicker dp_visible']/table[@class='dp_yearpicker']/tbody/tr/td"));

        for (WebElement yearList : yearLists) {

            if (year.equals(yearList.getText())) {
                yearList.click();
            }

        }

        // Select month
        List<WebElement> monthLists = driver.findElements(
                By.xpath("//div[2][@class='Zebra_DatePicker dp_visible']/table[@class='dp_monthpicker']/tbody/tr/td"));

        for (WebElement monthList : monthLists) {

            if (monthInThree.equals(monthList.getText())) {
                monthList.click();
            }

        }

        // Select date
        List<WebElement> days = driver.findElements(
                By.xpath("//div[2][@class='Zebra_DatePicker dp_visible']/table[@class='dp_daypicker']/tbody/tr/td"));
        for (WebElement d : days) {
            if (d.getText().equals(day)) {
                d.click();
            }
        }
    }

    // Verify disable objects
    public String verifyDesableObject(String xPath) {
        WebElement disable = driver.findElement(By.xpath(xPath));
        String disableAttribute = disable.getAttribute("disabled");
        return disableAttribute;
    }

    public boolean verifyAvailableObject(String xPath) {
        WebElement available = driver.findElement(By.xpath(xPath));
        // WebElement available = driver.findElement(By.name(xPath));
        boolean disableAttribute = available.isDisplayed();
        return disableAttribute;
    }

    // Create random number
    public String createRandomNumber() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss");
        String randomNumber = ft.format(dNow);
        return randomNumber;
    }

    // Get tag count under specific tag
    public int getTagCount(String xPath) {
        List<WebElement> tagType = driver.findElements(By.xpath(xPath));
        int tagCount = tagType.size();
        return tagCount;
    }

    public String getCurrentUrl()
    {
        String strUrl = driver.getCurrentUrl();
        return  strUrl;
    }


    public void selectSupplier(String supplierName) throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='input-group-text input-group-btn input-group-append btn text-white bg-primary show-searchsupplier-modal rightradius-4 waves-effect waves-themed']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/label[1]/input[1]")).sendKeys(supplierName);;
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/button[1]")).click();
    }

    public void selectProduct(String productName) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/main/div/form/div[2]/div/div/div/div[1]/div/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/main/div/div[3]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/label/input")).sendKeys(productName);;
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/main/div/div[3]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/table/tbody/tr/td[1]/button")).click();
        driver.findElement(By.xpath("//body")).click();
    }

    public void CustomizeProductSearch(String productName) throws InterruptedException {

        String PurchaseInvoiceAmount = "PurchaseInvoiceItem_Amount";

        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/main/div/form/div[2]/div/div/div/div[1]/div/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/main/div/div[3]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/label/input")).sendKeys(productName);;
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/main/div/div[3]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/table/tbody/tr/td[1]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("PurchaseInvoiceItem_Quantity")).sendKeys("10");
        Thread.sleep(2000);
        driver.findElement(By.id("PurchaseInvoiceItem_CostPrice")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("PurchaseInvoiceItem_CostPrice")).sendKeys("340");
        Thread.sleep(2000);
        driver.findElement(By.id("PurchaseInvoiceItem_ProductDiscount")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("PurchaseInvoiceItem_ProductDiscount")).sendKeys("40");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='input-group-btn input-group-text input-group-append btn text-white bg-primary btn-SalesOrderItem-DiscountValue waves-effect waves-themed']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("PurchaseInvoiceItem_ProductFreeQuantity")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("PurchaseInvoiceItem_ProductFreeQuantity")).sendKeys("20");
        Thread.sleep(2000);

        Select size =new Select(driver.findElement(By.id("PurchaseInvoiceItem_ProductSize")));
        size.selectByValue("6");
        driver.findElement(By.xpath("//body")).click();


        Thread.sleep(1000);

        Select color =new Select(driver.findElement(By.id("PurchaseInvoiceItem_ProductColor")));
        color.selectByValue("7");
        driver.findElement(By.xpath("//body")).click();


        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='panel-purchaseinvoice-item-search']/div[1]/div[3]/div[2]/a")).click();
        Thread.sleep(1000);

        Select warranty =new Select(driver.findElement(By.id("PurchaseInvoiceItem_ProductWarrantyDurationEnum")));
        warranty.selectByValue("2");
        driver.findElement(By.xpath("//body")).click();


        Thread.sleep(1000);
        driver.findElement(By.id("PurchaseInvoiceItem_ProductWarranty")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("PurchaseInvoiceItem_ProductWarranty")).sendKeys("5");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='col-md-12 pl-0']//div[@role='textbox']")).sendKeys("Product Description");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body")).click();
        Thread.sleep(1000);
    }





    public WebElement waitUntilNextElementAppears(By locator, int timeOut){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.presenceOfElementLocated(locator));
        return wait;
    }


    public void waituntil(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Method to clear text and then send keys to an element

    public void clearAndTypeID(String id, String text) {
        WebElement textBox = driver.findElement(By.id(id));
        textBox.clear();
        textBox.sendKeys(text);
    }


    public void ScrollToElement(String element){
        WebElement iframe = driver.findElement(By.id(element));
        new Actions(driver).scrollToElement(iframe).perform();

    }



}
