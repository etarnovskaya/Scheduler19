package com.scheduler.tests;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenAppTest {
  private AndroidDriver driver;

  @BeforeClass
  public void setUp() throws MalformedURLException {
  DesiredCapabilities capabilities = new DesiredCapabilities();
  capabilities.setCapability("platformName", "Android");
  capabilities.setCapability("deviceName", "Qa_19_class");
  capabilities.setCapability("platformVersion", "8.0");
  capabilities.setCapability("automationName", "Appium");
  capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
  capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
  capabilities.setCapability("app", "C:/Users/Elena/Documents/GitHub/Scheduler19/scheduler-android-tests/src/test/resources/v.0.0.1.apk");

  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}

@Test
public  void  testAppOpened(){
  System.out.println("App opened");
}

@AfterClass
  public  void  tearDown(){
    driver.quit();
}
}
