
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana etsiä lisätyistä viitteistä kirjoittajan nimellä'
 
scenario "Tutkija voi etsiä kirjoittajan nimellä", {
    given 'Viite on lisätty järjestelmään', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/konferenssi/lisaa")

        element = driver.findElement(By.name("ID"))
        element.sendKeys("PM01")

        element = driver.findElement(By.name("author"))
        element.sendKeys("Esa Eeppinen")

        element = driver.findElement(By.name("title"))
        element.sendKeys("Eeppinen Etätyö")
 
        element = driver.findElement(By.name("year"))
        element.sendKeys("2012")

        element.submit()
    }

    when 'Tutkija etsii kirjoittajan nimellä', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/haku")

        element = driver.findElement(By.name("search-author"))
        element.sendKeys("Esa Eeppinen")

        element.submit()
    }

    then 'Tutkija näkee listan viiteistä, jotka on kirjoittanut haettu kirjailija', {
        driver.getPageSource().contains("author = Esa Eeppinen").shouldBe true
    }
}



scenario "Tutkija voi etsiä kirjoittajan osanimellä", {
    given 'Viite on lisätty järjestelmään', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/konferenssi/lisaa")

        element = driver.findElement(By.name("ID"))
        element.sendKeys("PM01")

        element = driver.findElement(By.name("author"))
        element.sendKeys("Auvo Alakulo")

        element = driver.findElement(By.name("title"))
        element.sendKeys("Ainainen Autuus")
 
        element = driver.findElement(By.name("year"))
        element.sendKeys("2012")

        element.submit()
    }

    when 'Tutkija etsii kirjoittajan osanimellä', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/haku")

        element = driver.findElement(By.name("search-author"))
        element.sendKeys("uvo")

        element.submit()
    }

    then 'Tutkija näkee listan viiteistä, jotka on kirjoittanut haettu kirjailija', {
        driver.getPageSource().contains("author = Auvo Alakulo").shouldBe true
    }
}
