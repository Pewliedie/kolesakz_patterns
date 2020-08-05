package com.epam.cdp.kzta2020.pages.move_to_trash_yandex;

import com.epam.cdp.kzta2020.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AccountPage extends AbstractPage {

    private static final By IMG_LOCATOR = By.xpath("(//div[@class='listing-item__fields'])[1]");
    private static final By TRASH_LOCATOR = By.xpath("(//div[@class='listing-item__fields'])[last()]");
    private static final By ELEMENT_IN_TRASH = By.xpath("//div[@class='listing listing_with-mouse-selection listing_theme_tile listing_completed']//div[3]");
    private static final By NOTIFICATION_TRASH_LOCATOR = By.xpath("//div[@class='notifications__item notifications__item_trash nb-island notifications__item_moved']");
    private static final By PANEL_LOCATOR = By.xpath("//div[@class='root__content-inner root__content-inner_white root__content-inner_page_listing']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }
    public AccountPage moveToTrash() {
        waitForElementEnabled(IMG_LOCATOR);
        waitForElementVisibility(PANEL_LOCATOR);
        WebElement trash = driver.findElement(TRASH_LOCATOR);
        WebElement img = driver.findElement(IMG_LOCATOR);
        WebElement panel = driver.findElement(PANEL_LOCATOR);

        new Actions(getDriver()).moveToElement(panel, -600, 10).clickAndHold()
                .moveToElement(panel).moveByOffset(-300, -150).release()
                .dragAndDrop(img, trash).build().perform();
        return this;
    }

    public AccountPage openTrash() {
        waitForElementVisibility(NOTIFICATION_TRASH_LOCATOR);
        WebElement trash = driver.findElement(TRASH_LOCATOR);
        new Actions(getDriver()).doubleClick(trash).build().perform();
        return this;
    }

    public boolean isElementInTrash(){
        waitForElementVisibility(ELEMENT_IN_TRASH);
        return driver.findElement(ELEMENT_IN_TRASH).isDisplayed();
    }
}
