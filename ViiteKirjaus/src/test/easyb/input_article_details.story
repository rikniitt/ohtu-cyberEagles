
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan syöttää ohjelmaan artikkeliviitteen tiedot.'
 
scenario "Tutkija voi syöttää artikkeliviitteen tiedot (ID, Kirjoittaja, Otsikko, Lehti, Vuosi ja Julkaisija", {
    given 'artikkeliviitteen syöttö valittuna', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/artikkeli/lisaa")
    }

    when 'artikkeln tiedot syötetään', {

        element = driver.findElement(By.name("ID"))
        element.sendKeys("PM01")

        element = driver.findElement(By.name("author"))
        element.sendKeys("Eetu Etukumara")

        element = driver.findElement(By.name("title"))
        element.sendKeys("Eetun kokemukset integraatio testaajana")

        element = driver.findElement(By.name("journal"))
        element.sendKeys("Test Ninja Monthly")

        element = driver.findElement(By.name("year"))
        element.sendKeys("2001")

        element = driver.findElement(By.name("publisher"))
        element.sendKeys("Omakustanne")
        
        element.submit()
    }

    then 'tutkija näkee kirjan tiedot', {
        parsedOuput = driver.findElement(By.id('parsed-output')).getText() 
        parsedOuput.contains("PM01").shouldBe true
        parsedOuput.contains("Eetu Etukumara").shouldBe true
        parsedOuput.contains("Eetun kokemukset integraatio testaajana").shouldBe true
        parsedOuput.contains("Test Ninja Monthly").shouldBe true
        parsedOuput.contains("2001").shouldBe true
        parsedOuput.contains("Omakustanne").shouldBe true
    }
}
