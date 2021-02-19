package com.epam.task.fourth.parsers;

import com.epam.task.fourth.entities.Flower;
import com.epam.task.fourth.entities.ForestFlower;
import com.epam.task.fourth.entities.GardenFlower;
import com.epam.task.fourth.entities.WaterFlower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class FlowerHandler extends DefaultHandler {

    private final static Logger LOGGER = LogManager.getLogger(FlowerHandler.class);
    private final static String FOREST_FLOWER = "forest-flower";
    private final static String WATER_FLOWER = "water-flower";
    private final static String GARDEN_FLOWER = "garden-flower";
    private final static String NAME = "name";
    private final static String COLOR = "color";
    private final static String ORIGIN = "origin";
    private final static String FOREST_TYPE = "forest-type";
    private final static String WATER_SALINITY = "water-salinity";
    private final static String FLORESCENCE = "florescence";
    private List<Flower> flowers = new ArrayList<>();
    private Flower currentFlower = null;
    private String tag = null;

    @Override
    public void startDocument() {
        LOGGER.info("Parsing has been started");
        System.out.println("Parsing has been started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (localName) {
            case FOREST_FLOWER:
                currentFlower = new ForestFlower();
                currentFlower.setOrigin(attributes.getValue(ORIGIN));
                break;
            case GARDEN_FLOWER:
                currentFlower = new GardenFlower();
                currentFlower.setOrigin(attributes.getValue(ORIGIN));
                break;
            default:
                tag = localName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if(FOREST_FLOWER.equals(localName) ||
           WATER_FLOWER.equals(localName) ||
           GARDEN_FLOWER.equals(localName)) {
            flowers.add(currentFlower);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String text = new String(ch, start, length);
        if(tag != null) {
            switch (tag) {
                case NAME:
                    currentFlower.setName(text);
                    break;
                case COLOR:
                    currentFlower.setColor(text);
                    break;
                case FOREST_TYPE:
                    ForestFlower forestFlower = new ForestFlower(currentFlower);
                    forestFlower.setForestType(text);
                    currentFlower = forestFlower;
                    break;
                case WATER_SALINITY:
                    WaterFlower waterFlower = new WaterFlower(currentFlower);
                    waterFlower.setWaterSalinity(text);
                    currentFlower = waterFlower;
                    break;
                case FLORESCENCE:
                    GardenFlower gardenFlower = new GardenFlower(currentFlower);
                    gardenFlower.setFlorescence(text);
                    currentFlower = gardenFlower;
                    break;
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() {
        LOGGER.info("Parsing has been ended");
        System.out.println("Parsing has been ended");
    }

    public List<Flower> getFlowers() {
        return this.flowers;
    }
}
