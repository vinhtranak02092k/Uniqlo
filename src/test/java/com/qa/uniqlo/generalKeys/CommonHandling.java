package com.qa.uniqlo.generalKeys;

import com.microsoft.playwright.options.LoadState;
import com.qa.uniqlo.base.AbstractTest;
import com.qa.uniqlo.utilities.logs.Log;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.testng.Assert;

public class CommonHandling extends AbstractTest {

    public static @NotNull String normalizeStr(@NotNull String expStr) {
        Log.info("NORMALIZED STR: "+ expStr);
        return expStr.trim().toLowerCase();
    }

    public static @NotNull Boolean normalizeBool(@NotNull String expBool) {
        Log.info("NORMALIZED STR: "+ expBool);
        return Boolean.parseBoolean(expBool.trim().toLowerCase());
    }

    public static void setTxtIntoElement(
            String expSelector,
            String expStr) {
        AbstractTest.page.waitForSelector(expSelector);
        Log.info("FOUND SELECTOR= "+ expSelector);
        AbstractTest.page.click(expSelector);
        AbstractTest.page.fill(expSelector,"");
        AbstractTest.page.fill(expSelector,expStr);
    }

    public static void clickOnElement(String expSelector) {
        AbstractTest.page.waitForSelector(expSelector);
        Log.info("FOUND SELECTOR= "+ expSelector);
        AbstractTest.page.click(expSelector);
    }

    public static void procrastinateWithTimeOut(
            int timeOut) throws Exception {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Contract(pure = true)
    public static @NotNull Boolean verifyIfStringIsContained(
            @NotNull String expTxt, String toBeVerifiedTxt) {
        return expTxt.contains(toBeVerifiedTxt);
    }

    public static void verifyIfStringIsEqual(@NotNull String expTxt, @NotNull String actTxt) {
        String expTxtNormalized= expTxt.trim().toLowerCase();
        String actTxtNormalized= actTxt.trim().toLowerCase();
        Assert.assertEquals(expTxtNormalized, actTxtNormalized);
    }

    public static void verifyIfIntNumberIsEqual(int expInt, int actInt) {
        Assert.assertEquals(expInt, actInt);
    }

    public static void verifyIfFloatNumberIsEqual(Float expFloat, Float actFloat) {
        Assert.assertEquals(expFloat, actFloat);
    }

    public static void verifyIfSelectorHasTxt(String expSelector, String expTxt) {
        String actTxt= AbstractTest.page.textContent(expSelector);
        verifyIfStringIsEqual(expTxt, actTxt);
    }

    public static void hoverOnElement(String expSelector) {
        AbstractTest.page.waitForSelector(expSelector);
        Log.info("HOVERED SELECTOR= "+ expSelector);
        AbstractTest.page.locator(expSelector).hover();
    }

    public static void mouseOnSpecificLocation() {
//        AbstractTest.page.hover("", Locator.HoverOptions);
//        AbstractTest.page.locator("").hover();
    }

    public static void keyPressedEnter() {
        AbstractTest.page.keyboard().press("Enter");
        Log.info("PRESSED ENTER >>");
    }

    public static void waitForPageToLoad(@NotNull LoadState loadState) {
        AbstractTest.page.waitForLoadState(LoadState.valueOf((loadState).toString().toUpperCase()));
    }






}