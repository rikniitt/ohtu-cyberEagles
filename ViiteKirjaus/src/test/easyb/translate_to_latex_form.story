
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'Tutkijana haluan kääntää viitteen tiedot latexin ymmärtämään muotoon'
 
scenario "Tutkijana haluan kääntää lisätyt viitteet latex muotoon", {
    given 'Kirja viite on lisätty' , {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/kirja/lisaa")


        element = driver.findElement(By.name("author"))
        element.sendKeys("Unto Uimari")

        element = driver.findElement(By.name("title"))
        element.sendKeys("Uskalikon Uskomattomat Uskomukset")

        element = driver.findElement(By.name("year"))
        element.sendKeys("1988")

        
        element.submit()
    }
    when 'Tutkija kääntää viitteet', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/listaaKaikki")
    }

    then 'Lisätty kirja on käännetty latex muotoon', {
        source = driver.getPageSource()

        source.contains("@book{U88").shouldBe true
        source.contains("author = {Unto Uimari}").shouldBe true
        source.contains("title = {Uskalikon Uskomattomat Uskomukset}").shouldBe true
        source.contains("year = {1988}").shouldBe true
        
    }
}
