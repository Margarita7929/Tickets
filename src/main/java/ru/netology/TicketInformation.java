package ru.netology;

public class TicketInformation implements Comparable<TicketInformation> {
    protected int id;
    protected int price;
    protected String departureAirport;
    protected String arrivalAirport;
    protected int timeInTransit;

    public TicketInformation(int id, int price, String departureAirport, String arrivalAirport, int timeInTransit) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.timeInTransit = timeInTransit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getTimeInTransit() {
        return timeInTransit;
    }

    public void setTimeInTransit(int timeInTransit) {
        this.timeInTransit = timeInTransit;
    }


    @Override
    public int compareTo(TicketInformation o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else return 0;
    }


}
