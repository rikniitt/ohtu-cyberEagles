
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan poistaa viitteitä'

scenario "Tutkija voi poistaa lisäämänsä viitteen etusivulla", {
    given 'tutkija on etusivulla lisättyään viiteen', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080")

        element = driver.findElement(By.linkText("Lisää kirjaviite"))
        element.click()

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

        element = driver.findElement(By.linkText("Takaisin"))
        element.click()
    }
    
    when 'tutkija painaa viitteenpoistolinkkiä', {
        elements = driver.findElements(By.linkText("Poista"))
        element = elements.get(elements.size() - 1);
        element.click()
    }

    then 'viite on poistettu', {
        driver.getPageSource().contains("Aapo Avulias").shouldNotBe true
    }
}


scenario "Tutkija voi poistaa lisäämänsä viitteen viitteiden listauksessa", {
    given 'tutkija on viitteiden listauksessa lisättyään viiteen', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080")

        element = driver.findElement(By.linkText("Lisää kirjaviite"))
        element.click()

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

        element = driver.findElement(By.linkText("Listaa viitteet"))
        element.click()
    }
    
    when 'tutkija painaa viitteenpoistolinkkiä', {
        elements = driver.findElements(By.linkText("Poista"))
        element = elements.get(elements.size() - 1);
        element.click()
    }

    then 'viite on poistettu', {
        driver.getPageSource().contains("Aapo Avulias").shouldNotBe true
    }
}