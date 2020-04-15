package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String arrivalAirport;
    private String departureAirport;
    private int  travelTime;

    @Override
    public int compareTo(Ticket o) {
        return price - o.getPrice();
    }


    public static class TicketComparator implements Comparator<Ticket> {

        @Override
        public int compare(Ticket o1, Ticket o2) {
            return o1.getTravelTime() - o2.getTravelTime();
        }
    }
}