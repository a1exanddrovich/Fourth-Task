package com.epam.task.fourth.entities;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
@XmlSeeAlso({ForestFlower.class, WaterFlower.class, GardenFlower.class})
@XmlType(name = "FLower", namespace = "http://www.example.com/greenhouse")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flower extends Plant {

    @XmlElement(name = "color",required = true, namespace = "http://www.example.com/gems")
    private String color;

    public Flower(String name, String origin, String color) {
        super(name, origin);
        this.color = color;
    }

    public Flower() {
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Flower flowerToBeCompared = (Flower) object;
        return flowerToBeCompared.getName().equals(this.getName()) &&
                flowerToBeCompared.getColor().equals(this.getColor()) &&
                flowerToBeCompared.getOrigin().equals(this.getOrigin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }
}
