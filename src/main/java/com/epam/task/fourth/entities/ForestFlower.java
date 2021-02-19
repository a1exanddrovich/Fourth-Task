package com.epam.task.fourth.entities;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FOrestFlower", namespace = "http://www.example.com/greenhouse")
public class ForestFlower extends Flower {

    @XmlElement(name = "forest-type",required = true, namespace = "http://www.example.com/gems")
    private String forestType;

    public ForestFlower(String name,
                        String origin,
                        String color,
                        String forestType) {
        super(name, origin, color);
        this.forestType = forestType;
    }

    public ForestFlower (Flower flower) {
        this.setName(flower.getName());
        this.setColor(flower.getColor());
        this.setOrigin(flower.getOrigin());
    }

    public ForestFlower() {}

    public String getForestType() {
        return this.forestType;
    }

    public void setForestType(String forestType) {
        this.forestType = forestType;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this) {
            return true;
        }
        if(object == null || object.getClass() != this.getClass()) {
            return false;
        }
        ForestFlower flowerToBeCompared = (ForestFlower) object;
        return flowerToBeCompared.getName().equals(this.getName()) &&
               flowerToBeCompared.getColor().equals(this.getColor()) &&
               flowerToBeCompared.getOrigin().equals(this.getOrigin()) &&
               flowerToBeCompared.getForestType().equals(this.getForestType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getForestType());
    }

}
