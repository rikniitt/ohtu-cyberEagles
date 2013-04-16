
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan syöttää ohjelmaan artikkeliviitteen tiedot.'
 
scenario "Tutkija voi syöttää konferenssiviitteen tiedot (ID, Kirjoittaja, Otsikko, Kirjaotsikko, Vuosi, Sivut, Osoite)", {
    given 'konferenssiviitteen syöttö valittuna', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/konferenssi/lisaa")
    }


    when 'artikkelin tiedot syötetään', {

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


    then 'tutkija näkee konferenssin tiedot', {
        parsedOuput = driver.findElement(By.id('parsed-output')).getText() 
        parsedOuput.contains("Eetu Etukumara").shouldBe true
        parsedOuput.contains("Eetun aiempi kokemus").shouldBe true
        parsedOuput.contains("2001").shouldBe true
        parsedOuput.contains("12--23").shouldBe true
        parsedOuput.contains("Eetunkuja 3").shouldBe true
    }
}
