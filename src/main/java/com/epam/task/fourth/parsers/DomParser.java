package com.epam.task.fourth.parsers;

import com.epam.task.fourth.entities.Flower;
import com.epam.task.fourth.entities.ForestFlower;
import com.epam.task.fourth.entities.GardenFlower;
import com.epam.task.fourth.entities.WaterFlower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {

    private final static Logger LOGGER = LogManager.getLogger(DomParser.class);
    private final static String FOREST_FLOWER = "forest-flower";
    private final static String WATER_FLOWER = "water-flower";
    private final static String GARDEN_FLOWER = "garden-flower";
    private final static String NAME = "name";
    private final static String COLOR = "color";
    private final static String ORIGIN = "origin";
    private final static String FOREST_TYPE = "forest-type";
    private final static String WATER_SALINITY = "water-salinity";
    private final static String FLORESCENCE = "florescence";

    private Flower buildFlower(Element element) {
        switch (element.getTagName()) {
            case FOREST_FLOWER: {
                ForestFlower flower = new ForestFlower();
                if (element.hasAttribute(ORIGIN)) {
                    flower.setOrigin(element.getAttribute(ORIGIN));
                }
                flower.setName(getElementTextContent(element, NAME));
                flower.setColor(getElementTextContent(element, COLOR));
                flower.setForestType(getElementTextContent(element, FOREST_TYPE));
                return flower;
            }
            case WATER_FLOWER: {
                WaterFlower flower = new WaterFlower();
                if (element.hasAttribute(ORIGIN)) {
                    flower.setOrigin(element.getAttribute(ORIGIN));
                }
                flower.setName(getElementTextContent(element, NAME));
                flower.setColor(getElementTextContent(element, COLOR));
                flower.setWaterSalinity(getElementTextContent(element, WATER_SALINITY));
                return flower;
            }
            case GARDEN_FLOWER: {
                GardenFlower flower = new GardenFlower();
                if (element.hasAttribute(ORIGIN)) {
                    flower.setOrigin(element.getAttribute(ORIGIN));
                }
                flower.setName(getElementTextContent(element, NAME));
                flower.setColor(getElementTextContent(element, COLOR));
                flower.setFlorescence(getElementTextContent(element, FLORESCENCE));
                return flower;
            }
        }
        return new Flower();
    }


    private String getElementTextContent(Element element, String name) {
        NodeList list = element.getElementsByTagName(name);
        Node firstElement = list.item(0);
        String content = firstElement.getTextContent();
        return content;
    }

    @Override
    public List<Flower> parse(String fileName) {
        List<Flower> flowers = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("An error occurred while building " + e.getMessage());
        }
        try {
            Document document = builder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList flowersList = root.getElementsByTagName(FOREST_FLOWER);
            for (int i = 0; i < flowersList.getLength(); i++) {
                Element element = (Element) flowersList.item(i);
                Flower flower = buildFlower(element);
                flowers.add(flower);
            }
            flowersList = root.getElementsByTagName(WATER_FLOWER);
            for (int i = 0; i < flowersList.getLength(); i++) {
                Element element = (Element) flowersList.item(i);
                Flower flower = buildFlower(element);
                flowers.add(flower);
            }
            flowersList = root.getElementsByTagName(GARDEN_FLOWER);
            for (int i = 0; i < flowersList.getLength(); i++) {
                Element element = (Element) flowersList.item(i);
                Flower flower = buildFlower(element);
                flowers.add(flower);
            }
            LOGGER.info("DOM parsing has been ended successfully");
        } catch (SAXException | IOException e) {
            LOGGER.error("An error occurred while building " + e.getMessage());
        }
        return flowers;
    }

}
