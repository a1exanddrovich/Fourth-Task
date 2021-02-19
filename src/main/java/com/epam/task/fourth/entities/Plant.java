package com.epam.task.fourth.entities;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
@XmlSeeAlso(Flower.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Plant", namespace = "http://www.example.com/greenhouse")
public class Plant {

    @XmlElement(name = "name",required = true, namespace = "http://www.example.com/gems")
    private String name;
    @XmlAttribute(name = "origin",required = true, namespace = "http://www.example.com/gems")
    private String origin;

    public Plant(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

    public Plant() {}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this) {
            return true;
        }
        if(object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Plant plantToBeCompared = (Plant) object;
        return plantToBeCompared.getName().equals(this.getName()) &&
                plantToBeCompared.getOrigin().equals(this.getOrigin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getOrigin());
    }
}
