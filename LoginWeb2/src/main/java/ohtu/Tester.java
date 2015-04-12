package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));
        element.click(); 
        
        /**
        System.out.println("==");   
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit(); 
        
        System.out.println("=toka=");
        System.out.println( driver.getPageSource() );
        **/
        
        System.out.println("==");   
        
        System.out.println( driver.getPageSource() );       //testataan oikealla tunnuksella, väärällä salasanalla
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaaraSalasana");
        element.submit();
        System.out.println(driver.getPageSource().contains("wrong username or password"));
        
        element = driver.findElement(By.name("username"));  //testataan oikealla salasanalla, väärällä tunnuksella
        element.clear();
        element.sendKeys("vaaraTunnus");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element.submit();
        System.out.println(driver.getPageSource().contains("wrong username or password"));
        
        System.out.println("=toka=");
        System.out.println( driver.getPageSource() );        
                
        driver.get("http://localhost:8090");
        element = driver.findElement(By.linkText("register new user")); //testataan uuden käyttäjän rekisteröitymistä
        element.click();
        String name = Integer.toString(10000 + new Random().nextInt(10000));
        element = driver.findElement(By.id("username"));
        element.sendKeys(name);
        element = driver.findElement(By.id("password"));
        element.sendKeys("qwerty12");
        element = driver.findElement(By.id("passwordConfirmation"));
        element.sendKeys("qwerty12");
        element.submit();
        System.out.println(driver.getPageSource().contains("Welcome to Ohtu App!"));
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();        
        
        element = driver.findElement(By.linkText("logout"));    //testataan ulos kirjautumista
        element.click();
        element = driver.findElement(By.linkText("login"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.clear();
        element.sendKeys(name);
        element = driver.findElement(By.name("password"));
        element.sendKeys("acbcd12345");
        element.submit();
        System.out.println(driver.getPageSource().contains("Welcome to Ohtu Application!"));
        
    }
}

