package com.epam.task.fourth.validator;

import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {

    private final String XSD_FILE = "resources/greenhouse.xsd";
    private final XmlValidator validator = new XmlValidator(XSD_FILE);
    private final String VALID_XML_FILE = "resources/greenhouse.xml";
    private final String INVALID_XML_FILE = "resources/incorrect.xml";

    @Test
    public void testXmlValidatorShouldPassWhenCorrectFile() {

        //when
        boolean actual = validator.isValid(VALID_XML_FILE);

        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testXmlValidatorShouldPassWhenInvalidFile() {

        //when
        boolean actual = validator.isValid(INVALID_XML_FILE);

        //then
        Assert.assertFalse(actual);
    }

}
