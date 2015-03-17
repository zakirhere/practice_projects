
var webdriver = require('selenium-webdriver');
var assert = require('assert')	

var By = webdriver.By;

var driver = new webdriver.Builder().
   withCapabilities(webdriver.Capabilities.chrome()).
   build();

   driver.get("http://www.google.com").
      then(function() {
        return driver.findElement(By.name("q"));
		
      }).
      then(function(q) {
        return q.sendKeys("webdriver");
      }).
      then(function() {
        return driver.findElement(By.name("btnG"));
       }).
      then(function(btnG) {
        return btnG.click();
       }).
      then(function() {
        return driver.getTitle();
      }).
      then(function(title) {
        assert.assertEquals("webdriver - Google Search", title);
       });
	   
driver.quit();