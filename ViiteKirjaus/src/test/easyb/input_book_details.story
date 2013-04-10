
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan syöttää ohjelmaan kirja viitteen tiedot.'
 
scenario "Tutkija voi syöttää kirja viitteen tiedot (ID, Kirjailija, Titteli, Vuosi ja Julkaisija", {
    given 'kirja viitteen syöttö valittuna', {
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
        
        element.submit()
    }

    then 'tutkija näkee kirjan tiedot', {
        parsedOuput = driver.findElement(By.id('parsed-output')).getText()
        parsedOuput.contains("PM01").shouldBe true
        parsedOuput.contains("Aapo Avulias").shouldBe true
        parsedOuput.contains("Aapon kootut Aatokset").shouldBe true
        parsedOuput.contains("1950").shouldBe true
        parsedOuput.contains("Otava").shouldBe true
    }
}