package com.genericmethods;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    public static WebDriver driver;
    public Properties prop;
    public Properties dataProp;

    public String path = "C:\\Users\\TECQNIO\\git\\KSP_WEB_Automation\\com.properties";

    // Variables to track test results
    private int passedTests = 0;
    private int failedTests = 0;

    public void loadPropertiesFile() {
        prop = new Properties();
        File propFile = new File(path);

        try {
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
            System.out.println("Properties loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load properties file.");
        }
    }

    public WebDriver initializeAndOpenBrowser(String browserName) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        FirefoxOptions options1 = new FirefoxOptions();
        InternetExplorerOptions options2 = new InternetExplorerOptions();
        SafariOptions options3 = new SafariOptions();

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(options1);
        } else if (browserName.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver(options2);
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver(options3);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        String url = prop.getProperty("url");
        if (url != null) {
            driver.get(url);
        } else {
            System.out.println("URL property not found.");
        }

        return driver;
    }

    // Method to increment passed tests
    public void incrementPassedTests() {
        passedTests++;
    }

    // Method to increment failed tests
    public void incrementFailedTests() {
        failedTests++;
    }

    // Method to generate the report
    public void generateReport() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Passed", passedTests);
        dataset.setValue("Failed", failedTests);

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Test Case Execution Report",
                dataset,
                true, // include legend
                true, // tooltips
                false // URLs?
        );

        // Display the chart in a JFrame
        JFrame frame = new JFrame("Test Case Execution Report");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new ChartPanel(pieChart), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}