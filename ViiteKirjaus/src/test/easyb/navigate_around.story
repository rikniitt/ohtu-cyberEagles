
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan navigoida sivuilla'
 
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
        driver.getPageSource().contains("Lisää kirjaviite").shouldBe true
    }
}

scenario "Tutkija voi siirtyä linkin avulla artikkelin lisäämiseen", {
    given 'tutkija on etusivulla', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080")
    }

    when 'tutkija painaa kirjanlisäyslinkkiä', {
        element = driver.findElement(By.linkText("Lisää artikkeliviite"));
        element.click();
    }

    then 'tutkija on kirjanlisäyssivulla', {
        driver.getPageSource().contains("Lisää artikkeliviite").shouldBe true
    }
}

scenario "Tutkija voi siirtyä linkin avulla konferenssin lisäämiseen", {
    given 'tutkija on etusivulla', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080")
    }

    when 'tutkija painaa konferenssinlisäyslinkkiä', {
        element = driver.findElement(By.linkText("Lisää konferenssiviite"));
        element.click();
    }

    then 'tutkija on konferenssilisäyssivulla', {
        driver.getPageSource().contains("Lisää konferenssiviite").shouldBe true
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

scenario "Tutkija voi siirtyä linkin avulla kaikkien viitteiden listaamiseen", {
    given 'tutkija on etusivulla', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080")
    }

    when 'tutkija painaa viitteidenlistauslinkkiä', {
        element = driver.findElement(By.linkText("Listaa viitteet"));
        element.click();
        element = driver.findElement(By.linkText("generoi bibtex viitteet kaikista"));
        element.click();
    }

    then 'tutkija on kirjanlisäyssivulla', {
        driver.getPageSource().contains("Kaikki viitteet").shouldBe true
    }
}