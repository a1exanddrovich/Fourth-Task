package com.epam.task.fourth.entities;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GardenFLower", namespace = "http://www.example.com/greenhouse")
public class GardenFlower extends Flower {

    @XmlElement(name = "garden-flower",required = true, namespace = "http://www.example.com/gems")
    private String florescence;

    public GardenFlower(String name,
                        String origin,
                        String color,
                        String florescence) {
        super(name, origin, color);
        this.florescence = florescence;
    }

    public GardenFlower (Flower flower) {
        this.setName(flower.getName());
        this.setColor(flower.getColor());
        this.setOrigin(flower.getOrigin());
    }

    public GardenFlower() {}

    public String getFlorescence() {
        return this.florescence;
    }

    public void setFlorescence(String florescence) {
        this.florescence = florescence;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this) {
            return true;
        }
        if(object == null || object.getClass() != this.getClass()) {
            return false;
        }
        GardenFlower flowerToBeCompared = (GardenFlower) object;
        return flowerToBeCompared.getName().equals(this.getName()) &&
                flowerToBeCompared.getColor().equals(this.getColor()) &&
                flowerToBeCompared.getOrigin().equals(this.getOrigin()) &&
                flowerToBeCompared.getFlorescence().equals(this.getFlorescence());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFlorescence());
    }
}
