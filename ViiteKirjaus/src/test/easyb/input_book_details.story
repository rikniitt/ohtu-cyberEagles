
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan syöttää ohjelmaan kirjaviitteen tiedot.'
 
scenario "Tutkija voi syöttää kirjaviitteen tiedot (ID, Kirjailija, Titteli, Vuosi, Julkaisija, Osoite)", {
    given 'kirjaviitteen syöttö valittuna', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/kirja/lisaa")
    }

    when 'kirjan tiedot syötetään', {

        element = driver.findElement(By.name("ID"))
        element.sendKeys("PM01")

        element = driver.findElement(By.name("kirjailija"))
        element.sendKeys("Aapo Avulias")

        element = driver.findElement(By.name("titteli"))
        element.sendKeys("Aapon kootut Aatokset")

        element = driver.findElement(By.name("vuosi"))
        element.sendKeys("1950")

        element = driver.findElement(By.name("julkaisija"))
        element.sendKeys("Otava")

        element = driver.findElement(By.name("osoite"))
        element.sendKeys("1997")
        
        element.submit()
    }

    then 'tutkija näkee kirjan tiedot', {
        parsedOuput = driver.findElement(By.id('parsed-output')).getText() 
        parsedOuput.contains("PM01").shouldBe true
        parsedOuput.contains("Aapo Avulias").shouldBe true
        parsedOuput.contains("Aapon kootut Aatokset").shouldBe true
        parsedOuput.contains("1950").shouldBe true
        parsedOuput.contains("Otava").shouldBe true
        parsedOuput.contains("1997").shouldBe true
    }
}
