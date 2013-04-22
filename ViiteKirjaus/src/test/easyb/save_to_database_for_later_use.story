
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan tallentaa syöttämäni viitteen myohempää käyttöä varten.'
 
scenario "Lisätty konferenssiviite on näkyvissä myöhempää käyttöä varten", {
    given 'Konferenssi viitteen tiedot tallennetaan', {
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

    when 'tutkija navigoi tallennetun viitteen sivulle', {
        element = driver.findElement(By.linkText("viite"));
        element.click();
    }

    then 'tutkija näkee tallentamansa viitteen tiedot', {
        driver.getPageSource().contains("author = Eetu Etukumara").shouldBe true
        driver.getPageSource().contains("title = Eetun kokemukset integraatio testaajana").shouldBe true
        driver.getPageSource().contains("booktitle = Eetun aiempi kokemus").shouldBe true
        driver.getPageSource().contains("year = 2001").shouldBe true
        driver.getPageSource().contains("pages = 12--23").shouldBe true
        driver.getPageSource().contains("address = Eetunkuja 3").shouldBe true
    }
}
 
scenario "Lisätty kirjaviite on näkyvissä myöhempää käyttöä varten", {
    given 'Kirja viitteen tiedot tallennetaan', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/kirja/lisaa")

        element = driver.findElement(By.name("ID"))
        element.sendKeys("AA12")

        element = driver.findElement(By.name("kirjailija"))
        element.sendKeys("Iiro Itsepäinen")

        element = driver.findElement(By.name("titteli"))
        element.sendKeys("Iiron nuoruusvuosien haasteet")

        element = driver.findElement(By.name("vuosi"))
        element.sendKeys("2012")

        element = driver.findElement(By.name("julkaisija"))
        element.sendKeys("Otava")

        element = driver.findElement(By.name("osoite"))
        element.sendKeys("Etäkatu 12")
        
        element.submit()
    }

    when 'tutkija navigoi tallennetun viitteen sivulle', {
        element = driver.findElement(By.linkText("viite"));
        element.click();
    }

    then 'tutkija näkee tallentamansa viitteen tiedot', {
        source = driver.getPageSource()

        source.contains("Iiro Itsepäinen").shouldBe true
        source.contains("Iiron nuoruusvuosien haasteet").shouldBe true
        source.contains("2012").shouldBe true
        source.contains("Otava").shouldBe true
        source.contains("Etäkatu 12").shouldBe true
    }
}
 
scenario "Lisätty artikkeliviite on näkyvissä myöhempää käyttöä varten", {
    given 'Artikkeli viitteen tiedot tallennetaan', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/artikkeli/lisaa")

        element = driver.findElement(By.name("ID"))
        element.sendKeys("PM01")

        element = driver.findElement(By.name("author"))
        element.sendKeys("Otto Osallistuja")

        element = driver.findElement(By.name("title"))
        element.sendKeys("Otteita Oton Oppaasta")

        element = driver.findElement(By.name("journal"))
        element.sendKeys("Oikeat Osakkaat")

        element = driver.findElement(By.name("year"))
        element.sendKeys("2001")

        element = driver.findElement(By.name("publisher"))
        element.sendKeys("Omakustanne")

        element = driver.findElement(By.name("volume"))
        element.sendKeys("10")
        
        element = driver.findElement(By.name("number"))
        element.sendKeys("3")
        
        element = driver.findElement(By.name("pages"))
        element.sendKeys("12--23")
        
        element = driver.findElement(By.name("address"))
        element.sendKeys("Oikotie 123 B 123")
        
        element.submit()
    }

    when 'tutkija navigoi tallennetun viitteen sivulle', {
        element = driver.findElement(By.linkText("viite"));
        element.click();
    }

    then 'tutkija näkee tallentamansa viitteen tiedot', {
        source = driver.getPageSource()

        source.contains("Otto Osallistuja").shouldBe true
        source.contains("Otteita Oton Oppaasta").shouldBe true
        source.contains("Oikeat Osakkaat").shouldBe true
        source.contains("2001").shouldBe true
        source.contains("Omakustanne").shouldBe true
        source.contains("10").shouldBe true
        source.contains("3").shouldBe true
        source.contains("12--23").shouldBe true
        source.contains("Oikotie 123 B 123").shouldBe true
    }
}
