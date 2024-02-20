package utils;

import Pages.PageObjectManager;
import org.testng.annotations.Parameters;

public class TestContextSetup {
    public Base base;
    public PageObjectManager pom;

    public TestContextSetup(String browser){
        base =new Base();
        pom=new PageObjectManager(base.initializeDriver(browser));

    }
    public PageObjectManager setup(){
        return pom;
    }
}
//Single tone factory method
//Single tone pattern