package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class ResourceTest {
    private Resource resource = new Resource(1,"Huckleberry Finn", 1884, true);


    @Test
    public void constructorTest(){
        Assert.assertEquals("Huckleberry Finn", resource.title);
    }
}
