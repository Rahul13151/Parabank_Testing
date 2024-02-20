package utils;

import Pages.PageObjectManager;

public class TestContextSetup {
    public Base base;
    public PageObjectManager pom;

    public TestContextSetup(){
        base =new Base();
        pom=new PageObjectManager(base.initializeDriver());

    }
    public PageObjectManager setup(){
        return pom;
    }
}
//Single tone factory method
//Single tone pattern