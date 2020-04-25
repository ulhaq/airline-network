package main;

public class AirlineEdge {
    AirlineNode from;
    AirlineNode to;
    double distance;
    double time;
    String airline_code;

    public AirlineEdge(AirlineNode from, AirlineNode to, double distance, double time, String airline_code) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.time = time;
        this.airline_code = airline_code;
    }

    public AirlineNode getFrom() {
        return from;
    }

    public void setFrom(AirlineNode from) {
        this.from = from;
    }

    public AirlineNode getTo() {
        return to;
    }

    public void setTo(AirlineNode to) {
        this.to = to;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getAirline_code() {
        return airline_code;
    }

    public void setAirline_code(String airline_code) {
        this.airline_code = airline_code;
    }
}