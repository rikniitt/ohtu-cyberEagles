
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan listata syöttämäni viitteet ihmisen ymmärtämässä muodossa.'
 
scenario "Lisätty viite on näkyvissä viite listassa", {
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

    when 'lista näkymä on valittuna', {
        driver.get("http://localhost:8080/lista")
    }

    then 'lisätty viite on listassa', {
        driver.getPageSource().contains("author = Eetu Etukumara").shouldBe true
        driver.getPageSource().contains("title = Eetun kokemukset integraatio testaajana").shouldBe true
        driver.getPageSource().contains("booktitle = Eetun aiempi kokemus").shouldBe true
        driver.getPageSource().contains("year = 2001").shouldBe true
        driver.getPageSource().contains("pages = 12--23").shouldBe true
        driver.getPageSource().contains("address = Eetunkuja 3").shouldBe true
    }
}

scenario "", {
    given ''

    when ''

    then ''
}