/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.selecuke.generic.selenium;

import java.io.IOException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author arnaud
 */
public class GenericSeleniumUtil {

    private static RemoteWebDriver browser;
    private static final Logger logger = LoggerFactory.getLogger(GenericSeleniumUtil.class);

    public static RemoteWebDriver getBrowser() {
        return browser;
    }

    public static final void startBrowser() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        logger.info("New Test reached : opening Browser");
        browser = CustomWebDriverFactory.getWebDriver();
    }

    public static final void closeBrowser() {
        browser.close();
        logger.error("Test Finished : closing Browser");

    }
}
