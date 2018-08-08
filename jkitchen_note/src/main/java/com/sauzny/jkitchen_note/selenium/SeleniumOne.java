package com.sauzny.jkitchen_note.selenium;

import java.util.List;

import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ByIdOrName;

public class SeleniumOne {

    public static void waitTime(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        //如果测试的浏览器没有安装在默认目录，那么必须在程序中设置   
        //bug1:System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//Google//Chrome//Application//chrome.exe");  
        //bug2:System.setProperty("webdriver.chrome.driver", "C://Users//Yoga//Downloads//chromedriver_win32//chromedriver.exe");  
        System.setProperty("webdriver.chrome.driver", "E:\\code\\py-selenium\\chromedriver_win32\\chromedriver.exe");  
        
        //System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");  
        
        //WebDriver driver = new FirefoxDriver();  
        WebDriver driver = new ChromeDriver(); 
        
        driver.manage().window().maximize();
        
        driver.get("http://www.baidu.com");  
        
        waitTime(3000L);
        
        // 获取 网页的 title    
        // System.out.println("The testing page title is: " + driver.getTitle());   
          /*
        WebElement userName = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));
        
        userName.clear();userName.sendKeys("admin");
        password.clear();password.sendKeys("admin");
        
        List<WebElement> webElementList = driver.findElements(By.className("checkRect_up"));
                
        webElementList.forEach(webElement -> webElement.click());
        
        waitTime(3000L);

        driver.findElement(By.id("treeDemo_3_switch")).click();
        driver.findElement(By.id("treeDemo_6_switch")).click();
        new Actions(driver).doubleClick(driver.findElement(By.id("treeDemo_9_span"))).perform();;
        */
        driver.quit();  
    }
}
