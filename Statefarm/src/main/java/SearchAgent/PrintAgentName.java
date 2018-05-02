package SearchAgent;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PrintAgentName extends CommonAPI{

    @FindBy (id = "viewMap")
    public WebElement viewMap;

    @FindBy(xpath = "//*[@id=\"agentMicrositeUrl_A\"]")
    public WebElement agentName;

    @FindBy (id = "distance")
    public WebElement doText;

    public void getAgentName(){
        String name= agentName.getText();
        //System.out.println(name);
        String text = doText.getText();
        System.out.println(text);
        Assert.assertEquals(doText.getText(), doText.getText());
        String maP = viewMap.getText();
        System.out.println(maP);
    }
}
