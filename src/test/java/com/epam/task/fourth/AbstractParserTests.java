package com.epam.task.fourth;

import com.epam.task.fourth.entities.Flower;
import com.epam.task.fourth.entities.ForestFlower;
import com.epam.task.fourth.entities.GardenFlower;
import com.epam.task.fourth.entities.WaterFlower;
import com.epam.task.fourth.parsers.Parser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractParserTests {

    private Parser parser;
    private final String fileName = "resources/greenhouse.xml";
    private final List<Flower> expected = Arrays.asList(new ForestFlower("Bellflower", "Europe", "violet", "mixed"),
            new WaterFlower("Lotus", "West Europe", "white", "fresh"),
            new GardenFlower("Rose", "Asia", "red", "May"),
            new GardenFlower("Bell", "Asia", "orange", "June"));

    protected abstract Parser setParser();

    @Before
    public void setUp() {
        parser = setParser();
    }

    @Test
    public void testParseShouldParseValidXmlFileInList() {
        List<Flower> result = parser.parse(fileName);

        Assert.assertEquals(expected, result);
    }

}
