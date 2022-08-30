public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private double travelTime;

    public Ticket(int id, int price, String departureAirport, String arrivalAirport, double travelTime) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }


    public String getArrivalAirport() {
        return arrivalAirport;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}