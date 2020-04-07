package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {
    int id;
    int price;
    String arrivalAirport;
    String departureAirport;
    double travelTime;

    @Override
    public int compareTo(Ticket o) {
        return price - o.getPrice();
    }


    public static class TicketComparator implements Comparator<Ticket> {

        @Override
        public int compare(Ticket o1, Ticket o2) {
            return (int) (o1.getTravelTime() - o2.getTravelTime());
        }
    }
}