
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan käyttää sovellusta useammalla työpisteellä'
 
scenario "Tutkija voi navigoida etusivulla", {
    given 'web-osoitteen syöttö on valittuna', {
        driver = new HtmlUnitDriver()
    }

    when 'tutkija syöttää etusivun osoitteen', {
        driver.get("http://localhost:8080")
    }

    then 'tutkija on etusivulla', {
        element = driver.findElement(By.id("welcome-text"));    
        element.getText().contains("Arton viite kirjaus").shouldBe true
    }
}

scenario "Tutkija syöttää olemattoman alasivun osoittee ja päätyy etusivulle", {
    given 'web-osoitteen syöttö on valittuna', {
        driver = new HtmlUnitDriver()   
    }

    when 'tutkija syöttää virheellisen osoitteen', {
        driver.get("http://localhost:8080/asfdlol")
    }

    then 'tutkija on etusivulla', {
        element = driver.findElement(By.id("welcome-text"));    
        element.getText().contains("Arton viite kirjaus").shouldBe true
    }
}