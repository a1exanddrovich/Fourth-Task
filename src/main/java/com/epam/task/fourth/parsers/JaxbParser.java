package com.epam.task.fourth.parsers;

import com.epam.task.fourth.entities.Flower;
import com.epam.task.fourth.entities.Flowers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JaxbParser implements Parser {

    @Override
    public List<Flower> parse(String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Flowers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader fileReader = new FileReader(fileName);
            Flowers flowersJaxb = (Flowers) unmarshaller.unmarshal(fileReader);
            List<Flower> flowers = parseFlowers(flowersJaxb.getFlowersJaxbElementList());
            return flowers;
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Flower> parseFlowers(List<JAXBElement<? extends Flower>> flowers) {
        List<Flower> candies = new ArrayList<>();
        for (JAXBElement element : flowers) {
            Flower flower = (Flower) element.getValue();
            candies.add(flower);
        }
        return candies;
    }

}
