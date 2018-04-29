package checkAPI;

import base.CommonAPI;

public class CheckAPIMethods extends CommonAPI{

    public void checkmethods(){
        textInputField("quote-main-zip-code-input", "19034");
        clickWebElement("quote-main-zip-code-button");
    }
}
