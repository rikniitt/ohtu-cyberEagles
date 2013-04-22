
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan nähdä kaikki lisätyt viitteet etusivulla'
 
scenario "Tutkija navigoi etusivulle ja näkee lisäämänsä viitteet", {
    given 'Viite on lisätty järjestelmään', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/konferenssi/lisaa")

        element = driver.findElement(By.name("ID"))
        element.sendKeys("PM01")

        element = driver.findElement(By.name("author"))
        element.sendKeys("Eetu Etukumara")

        element = driver.findElement(By.name("title"))
        element.sendKeys("Eetun kokemukset integraatio testaajana")

        element = driver.findElement(By.name("booktitle"))
        element.sendKeys("Eetun aiempi kokemus")

        element = driver.findElement(By.name("year"))
        element.sendKeys("2001")

        element = driver.findElement(By.name("pages"))
        element.sendKeys("12--23")
        
        element = driver.findElement(By.name("address"))
        element.sendKeys("Eetunkuja 3")
        
        element.submit()
    }

    when 'tutkija syöttää etusivun osoitteen', {
        driver.get("http://localhost:8080")
    }

    then 'tutkija on etusivulla ja näkee lisätyt viitteet', {
        element = driver.findElement(By.id("welcome-text"));    
        element.getText().contains("Arton viite kirjaus").shouldBe true


        driver.getPageSource().contains("title = Eetun kokemukset integraatio testaajana").shouldBe true
        
    }
}
