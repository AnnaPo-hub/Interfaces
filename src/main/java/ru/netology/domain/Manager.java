package ru.netology.domain;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class Manager {
    TicketRepo list;

    public Ticket[] findAll(String from, String to, TicketComparator ticketC) {
        Ticket[] newList = new Ticket[0];
        for (Ticket ticket : list.getAll()) {
            if (ticket.arrivalAirport.equals(to) && ticket.departureAirport.equals(from)) {
                Ticket[] tmp = new Ticket[newList.length + 1];
                System.arraycopy(newList, 0, tmp, 0, newList.length);
                tmp[tmp.length - 1] = ticket;
                newList = tmp;
                Arrays.sort(newList, ticketC);
            }
        }
        return newList;
    }
}




