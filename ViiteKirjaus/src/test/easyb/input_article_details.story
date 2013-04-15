
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan syöttää ohjelmaan artikkeliviitteen tiedot.'
 
scenario "Tutkija voi syöttää artikkeliviitteen tiedot (ID, Kirjoittaja, Otsikko, Lehti, Vuosi ja Julkaisija, Numero, Sivut, Osoite)", {
    given 'artikkeliviitteen syöttö valittuna', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/artikkeli/lisaa")
    }

    when 'artikkelin tiedot syötetään', {

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

        element = driver.findElement(By.name("volume"))
        element.sendKeys("19")
        
        element = driver.findElement(By.name("number"))
        element.sendKeys("3")
        
        element = driver.findElement(By.name("pages"))
        element.sendKeys("12--23")
        
        element = driver.findElement(By.name("address"))
        element.sendKeys("Eetunkuja 3")
        
        element.submit()
    }


    then 'tutkija näkee artikkelin tiedot', {
        parsedOuput = driver.findElement(By.id('parsed-output')).getText() 
        parsedOuput.contains("PM01").shouldBe true
        parsedOuput.contains("Eetu Etukumara").shouldBe true
        parsedOuput.contains("Eetun kokemukset integraatio testaajana").shouldBe true
        parsedOuput.contains("Test Ninja Monthly").shouldBe true
        parsedOuput.contains("2001").shouldBe true
        parsedOuput.contains("Omakustanne").shouldBe true
        parsedOuput.contains("Omakustanne").shouldBe true
        parsedOuput.contains("3").shouldBe true
        parsedOuput.contains("19").shouldBe true
        parsedOuput.contains("12--23").shouldBe true
        parsedOuput.contains("Eetunkuja 3").shouldBe true
    }
}
