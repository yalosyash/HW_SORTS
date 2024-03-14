import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private String from; // аэропорт откуда
    private String to; // аэропорт куда
    private int price; // цена
    private int timeFrom; // время вылета (по москве)
    private int timeTo; // время прилёта (по москве)

    public Ticket(String from, String to, int price, int timeFrom, int timeTo) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

//    public int getPrice() {
//        return price;
//    }

    public int getTimeFrom() {
        return timeFrom;
    }

    public int getTimeTo() {
        return timeTo;
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