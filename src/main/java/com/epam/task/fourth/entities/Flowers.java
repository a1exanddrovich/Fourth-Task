package com.epam.task.fourth.entities;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", namespace = "http://www.example.com/greenhouse", propOrder = {
        "flowers"
})
@XmlRootElement(namespace = "http://www.example.com/greenhouse", name = "greenhouse")
public class Flowers {

    @XmlElementRef(name = "flowers", namespace = "http://www.example.com/greenhouse", type =
            JAXBElement.class)
    protected List<JAXBElement<? extends Flower>> flowers;

    public List<JAXBElement<? extends Flower>> getFlowersJaxbElementList() {
        if (flowers == null) {
            flowers = new ArrayList<>();
        }
        return this.flowers;
    }

}
