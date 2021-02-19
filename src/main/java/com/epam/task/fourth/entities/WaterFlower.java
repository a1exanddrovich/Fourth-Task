package com.epam.task.fourth.entities;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
@XmlType(name = "WaterFLower", namespace = "http://www.example.com/greenhouse")
@XmlAccessorType(XmlAccessType.FIELD)
public class WaterFlower extends Flower {

    @XmlElement(name = "water-flower",required = true, namespace = "http://www.example.com/gems")
    private String waterSalinity;

    public WaterFlower(String name,
                       String origin,
                       String color,
                       String waterSalinity) {
        super(name, origin, color);
        this.waterSalinity = waterSalinity;
    }

    public WaterFlower (Flower flower) {
        this.setName(flower.getName());
        this.setColor(flower.getColor());
        this.setOrigin(flower.getOrigin());
    }

    public WaterFlower() {}

    public String getWaterSalinity() {
        return this.waterSalinity;
    }

    public void setWaterSalinity(String waterSalinity) {
        this.waterSalinity = waterSalinity;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this) {
            return true;
        }
        if(object == null || object.getClass() != this.getClass()) {
            return false;
        }
        WaterFlower flowerToBeCompared = (WaterFlower) object;
        return flowerToBeCompared.getName().equals(this.getName()) &&
                flowerToBeCompared.getColor().equals(this.getColor()) &&
                flowerToBeCompared.getOrigin().equals(this.getOrigin()) &&
                flowerToBeCompared.getWaterSalinity().equals(this.getWaterSalinity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWaterSalinity());
    }
}
