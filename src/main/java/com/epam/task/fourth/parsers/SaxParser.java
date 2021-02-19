package com.epam.task.fourth.parsers;

import com.epam.task.fourth.entities.Flower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser implements Parser {

    private final static Logger LOGGER = LogManager.getLogger(SAXParser.class);
    private FlowerHandler flowerHandler = new FlowerHandler();

    @Override
    public List<Flower> parse(String fileName) {
        List<Flower> flowers = new ArrayList<>();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(flowerHandler);
            reader.parse(fileName);
            flowers = flowerHandler.getFlowers();
            LOGGER.info("The parsing has been performed successfully");
            return flowers;
        } catch (SAXException | IOException e) {
            LOGGER.error("The parsing hes been failed because of " + e.getMessage());
        }
        return flowers;
    }

}
