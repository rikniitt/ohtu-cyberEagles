
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan navigoida etusivulta alisivuille'
 
scenario "Tutkija voi siirtyä linkin avulla kirjan lisäämiseen", {
    given 'tutkija on etusivulla', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080")
    }

    when 'tutkija painaa kirjanlisäyslinkkiä', {
        element = driver.findElement(By.linkText("Lisää kirjaviite"));
        element.click();
    }

    then 'tutkija on kirjanlisäyssivulla', {
        driver.getPageSource().contains("Lisää viite").shouldBe true
    }
}

scenario "Tutkija voi siirtyä linkin avulla viitteiden listaamiseen", {
    given 'tutkija on etusivulla', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080")
    }

    when 'tutkija painaa viitteidenlistauslinkkiä', {
        element = driver.findElement(By.linkText("Listaa viitteet"));
        element.click();
    }

    then 'tutkija on kirjanlisäyssivulla', {
        driver.getPageSource().contains("Kirja viitteet").shouldBe true
    }
}