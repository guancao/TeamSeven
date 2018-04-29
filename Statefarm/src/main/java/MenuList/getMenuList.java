package MenuList;

import base.CommonAPI;

public class getMenuList extends CommonAPI {

    public void PrintMenu(){

       String txt = getTextById("oneX-main-menu-btn");
        System.out.println(txt);
        clickWebElement("oneX-main-menu-btn");
       String text = getTextByXpath("/html/body/header/div[2]/div[1]/div/div[1]/section/h5/a");
        System.out.println(text);

    }
}
