package main;

import java.util.List;

public class AirlineNode {
    String code;
    String name;
    String city;
    String country;

    boolean isVisited;

    public AirlineNode() {
    }

    public AirlineNode(String code, String name, String city, String country, boolean isVisited) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
        this.isVisited = isVisited;
    }

    public AirlineNode(String code, String name, String city, String country) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
