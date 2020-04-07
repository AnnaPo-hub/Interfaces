package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

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
}