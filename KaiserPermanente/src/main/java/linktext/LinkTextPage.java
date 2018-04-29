package linktext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkTextPage {

    @FindBy(linkText = "Why KP")
    public WebElement whyKpLinkText;
    @FindBy(linkText = "Shop Plans")
    public WebElement shopPlansLinkText;
    @FindBy(linkText = "Doctors & Locations")
    public WebElement doctorrLinkText;
    @FindBy(linkText = "Health & Wellness")
    public WebElement healthLinkText;

    public WebElement getHealthLinkText() {
        return healthLinkText;
    }

    public void setHealthLinkText(WebElement healthLinkText) {
        this.healthLinkText = healthLinkText;
    }



    public WebElement getDoctorrLinkText() {
        return doctorrLinkText;
    }

    public void setDoctorrLinkText(WebElement doctorrLinkText) {
        this.doctorrLinkText = doctorrLinkText;
    }



    public WebElement getShopPlansLinkText() {
        return shopPlansLinkText;
    }

    public void setShopPlansLinkText(WebElement shopPlansLinkText) {
        this.shopPlansLinkText = shopPlansLinkText;
    }


    public WebElement getWhyKpLinkText() {
        return whyKpLinkText;
    }

    public void setWhyKpLinkText(WebElement whyKpLinkText) {
        this.whyKpLinkText = whyKpLinkText;
    }

    public void linkTextPage(WebDriver driver)throws InterruptedException
    {

        getWhyKpLinkText().click();
        Thread.sleep(2000);
        driver.navigate().back();
        getShopPlansLinkText().click();
        Thread.sleep(2000);
        driver.navigate().back();
        getDoctorrLinkText().click();
        driver.navigate().back();
        Thread.sleep(2000);
        getHealthLinkText().click();
        driver.navigate().back();
        Thread.sleep(2000);

    }



   /* public void clickLinkByHref(WebDriver driver) throws InterruptedException {
        WebElement anchors = driver.findElement(By.xpath("//*[@id=\"logged_out_topnav\"]/ul"));
        List<WebElement> links=anchors.findElements(By.tagName("a"));
        for(int i=0; i< links.size(); i++) {
            try{
                links.get(i).click();
                driver.navigate().back();
                Thread.sleep(5000);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            //System.out.println(links.get(i).getText());
            //driver.navigate().refresh();
             //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



            //Thread.sleep(1000);
           // driver.navigate().back();

        }





        /*String[] linkTexts = new String[anchors.size()];
        int i = 0;
        for (WebElement e : anchors) {
            linkTexts[i] = e.getText();
            System.out.println(e.getText());
            i++;
        }
        for (String t : linkTexts) {
           // driver.findElement(By.linkText(t)).click();
            driver.findElement(By.linkText(t)).click();
            if (driver.getTitle().equals(underConsTitle)) {
                System.out.println("\"" + t + "\""
                        + " is under construction.");
            } else {
                System.out.println("\"" + t + "\""
                        + " is working.");
            }
            Thread.sleep(2000);
            System.out.println("in the loop");
            driver.navigate().back();
        }
        //System.out.println(strLink);
                /*currentLink.click();
       }         Thread.sleep(1000);
               driver.navigate().back();*/



}





