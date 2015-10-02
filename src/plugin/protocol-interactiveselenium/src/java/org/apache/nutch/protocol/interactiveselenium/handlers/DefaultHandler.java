/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.nutch.protocol.interactiveselenium;

import java.lang.String;
import java.util.*;
import java.util.StringTokenizer;

import org.openqa.selenium.*;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DefaultHandler implements InteractiveSeleniumHandler {
    /*
    public void processDriver(WebDriver driver) {}
    public boolean shouldProcessURL(String URL) {
        return true;
    }
    */
    public void processDriver(WebDriver driver) {
        System.out.println("@@@@@@@@@@ The current URL is @@@@@@@@@@@: ");
       /*
         * Should be divide into two parts:
         * interact with JavaScripts (click on element)
         * submit forms (sendKeys and subimt)
       */

        //Get the current page URL and store the value in variable 'url'
        String url = driver.getCurrentUrl();

        //Print the value of variable in the console
        System.out.println("@@@@@@@@@@ The current URL is @@@@@@@@@@@: " + url);

        //Load a new page in the current browser windows
        driver.get(url);

        //Maximize the Browser window
        //driver.manage().window().maximize();

        By.ById id = new By.ById("pic");

        List<WebElement> list = driver.findElements(id);
        for (WebElement elem : list) {
            System.out.print("click elem with tag: " + elem.getTagName());
            System.out.println(" @ " + elem.toString());
            if (elem.getSize().getWidth() != 0 && elem.getSize().getWidth() != 0 && elem.isDisplayed()) {
//				JavascriptExecutor jse = (JavascriptExecutor)driver;
//				jse.executeScript("document.getElementById('pic1').click();");
                elem.click();
            }
        }
    }

    public boolean shouldProcessURL(String URL) {
        System.out.println("!!!!!!!!!!URL!!!!!!!!!!!!!");
        System.out.println(URL);
//        return !URL.isEmpty();
        return true;
    }
}
