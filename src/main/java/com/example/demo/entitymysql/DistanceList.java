package com.example.demo.entitymysql;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "distance-city")
@XmlAccessorType (XmlAccessType.FIELD)
public class DistanceList extends Distance {

    @XmlElement(name = "distance-class")
    private List<Distance> distanceList = null;
    public List<Distance> getDistanceList() {
        return distanceList;
    }
    public void setDistanceList(List<Distance> distanceList) {
        this.distanceList = distanceList;
    }
}
