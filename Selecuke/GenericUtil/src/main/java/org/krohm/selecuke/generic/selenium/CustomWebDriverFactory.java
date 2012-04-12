/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.selecuke.generic.selenium;

import org.krohm.selecuke.generic.cucumber.Env;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author arnaud
 */
public class CustomWebDriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(CustomWebDriverFactory.class);

    public static RemoteWebDriver getRemoteWebDriver() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String webDriverClassName = Env.getProperties().getProperty(Env.ENV_WEB_DRIVER_CLASS_KEY);
        logger.debug("Creating WebDriver instance from class : <" + webDriverClassName + ">");
        Class webDriverClass = Thread.currentThread().getContextClassLoader().loadClass(webDriverClassName);
        RemoteWebDriver returnWebDriver = (RemoteWebDriver) webDriverClass.newInstance();
        return returnWebDriver;
    }

        public static WebDriver getWebDriver() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String webDriverClassName = Env.getProperties().getProperty(Env.ENV_WEB_DRIVER_CLASS_KEY);
        logger.debug("Creating WebDriver instance from class : <" + webDriverClassName + ">");
        Class webDriverClass = Thread.currentThread().getContextClassLoader().loadClass(webDriverClassName);
        WebDriver returnWebDriver = (WebDriver) webDriverClass.newInstance();
        return returnWebDriver;
    }
}
