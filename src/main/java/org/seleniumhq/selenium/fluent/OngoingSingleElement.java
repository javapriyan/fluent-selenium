package org.seleniumhq.selenium.fluent;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class OngoingSingleElement extends OngoingFluentWebDriver {

    private final WebElement currentElement;

    public OngoingSingleElement(WebDriver delegate, WebElement currentElement, String context) {
        super(delegate, context);
        this.currentElement = currentElement;
    }

    protected WebElement findIt(By by) {
        return currentElement.findElement(by);
    }

    @Override
    protected List<WebElement> findThem(By by) {
        return currentElement.findElements(by);
    }


    public OngoingFluentWebDriver click() {
        currentElement.click();
        return getOngoingSingleElement(currentElement, context);
    }

    /**
     *  Use this instead of clear() to clear an WebElement
     */

    public OngoingFluentWebDriver clearField() {
        currentElement.clear();
        return getOngoingSingleElement(currentElement, context);
    }


    public OngoingFluentWebDriver submit() {
        currentElement.submit();
        return getOngoingSingleElement(currentElement, context);
    }

    // These are as they would be in the WebElement API

    public OngoingFluentWebDriver sendKeys(CharSequence... keysToSend) {
        String ctx = context + ".sendKeys(" + charSeqArrayAsHumanString(keysToSend) + ")";
        try {
            currentElement.sendKeys(keysToSend);
        } catch (WebDriverException e) {
            throw decorateWebDriverException(ctx, e);

        }
        return getOngoingSingleElement(currentElement, ctx);
    }

    private String charSeqArrayAsHumanString(CharSequence[] keysToSend) {
        String keys = "";
        for (int i = 0; i < keysToSend.length; i++) {
            CharSequence charSequence = keysToSend[i];
            keys = keys + ", '" + charSequence + "'";
        }
        return keys.substring(2);
    }

    public String getTagName() {
        return currentElement.getTagName();
    }

    public boolean isSelected() {
        return currentElement.isSelected();
    }

    public boolean isEnabled() {
        return currentElement.isEnabled();
    }

    public boolean isDisplayed() {
        return currentElement.isDisplayed();
    }

    public Point getLocation() {
        return currentElement.getLocation();
    }

    public Dimension getSize() {
        return currentElement.getSize();
    }

    public String getCssValue(String cssName) {
        return currentElement.getCssValue(cssName);
    }

    public String  getAttribute(String attr) {
        return currentElement.getAttribute(attr);
    }

    public String getText() {
        return currentElement.getText();
    }

}