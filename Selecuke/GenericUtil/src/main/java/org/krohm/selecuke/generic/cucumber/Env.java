/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.selecuke.generic.cucumber;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author arnaud
 */
public class Env {

    private static boolean initDone = false;
    private static final Logger logger = LoggerFactory.getLogger(Env.class);
    private static final String propertyFileKey = "env.properties";
    private static Properties envProperties = new Properties();
    //
    // Generic properties to be used in the whole project
    //
    public static final String ENV_WEB_DRIVER_CLASS_KEY = "cucumber.env.webdriver";
    public static final String ENV_CSV_FILE_FOLDER = "cucumber.env.data.path";

    private static final Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        String envPropertiesPath = System.getProperties().getProperty(propertyFileKey);
        logger.info("Reading property file at path : <" + envPropertiesPath + ">");
        InputStream in = new FileInputStream(new File(envPropertiesPath));
        prop.load(in);
        in.close();
        return prop;
    }

    public static final Properties getProperties() {
        return envProperties;
    }

    public static boolean init() throws IOException {
        if (initDone) {
            return initDone;
        }
        // TODO : add a synchronize to be really sure that this is done only once
        // and that nothing does through before the init is finished
        logger.error("######################################################### Init");
        envProperties = loadProperties();
        //listCurrentFolder();
        //listEnv();
        listProp();
        initDone = true;
        return initDone;
    }

    public static boolean isInitDone() {
        return initDone;
    }

    private static void listCurrentFolder() {
        File tmpFile = new File(".");
        for (File currentFile : tmpFile.listFiles()) {
            logger.error("File : ===>" + currentFile.getName());
        }
    }

    private static void listEnv() {
        for (Entry<Object, Object> currentEntry : System.getProperties().entrySet()) {
            logger.error("Env : <" + currentEntry + ">");
        }
    }

    private static void listProp() {
        for (Entry<Object, Object> currentEntry : envProperties.entrySet()) {
            logger.error("Prop : <" + currentEntry + ">");
        }
    }
}
