package renters;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import rentersInsurance.Renters;

public class TestRentersInsurance extends CommonAPI {

    @Test
    public void testRentersIns(){
        Renters renters = PageFactory.initElements(driver, Renters.class);
        renters.callAllMethods();
    }
}
