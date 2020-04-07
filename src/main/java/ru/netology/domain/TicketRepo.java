package ru.netology.domain;

import lombok.Data;

@Data
public class TicketRepo {
     Ticket [] list = {new Ticket(1, 1200,"PDL", "LED", 5.20),
    new Ticket(2, 1000, "TLV", "LED", 3.15),
    new Ticket(3, 850, "TLV", "LED", 5.15),
    new Ticket(4, 500, "TLV", "LED", 12.15),
    new Ticket(5, 700, "VKO", "LED", 1.00)};




    Ticket[] getAll() {
        return list;
    }

    void save(Ticket ticket) {
        int length = list.length + 1;
        Ticket[] addedTicket = new Ticket[length];
        for (int i = 0; i < list.length; i++) {
            addedTicket[i] = list[i];
        }
        int lastIndex = addedTicket.length - 1;
        addedTicket[lastIndex] = ticket;
        list = addedTicket;
    }

    void removeById(int id) {
        boolean b = false;
        for (Ticket item : list) {
            if (item.getId() == id) {
                b = true;
                break;
            }
        }
        if (b) {
            int length = list.length - 1;
            Ticket[] newArray = new Ticket[length];
            int index = 0;
            for (Ticket item : list) {
                if (item.getId() != id) {
                    newArray[index] = item;
                    index++;
                }
            }
            list = newArray;
        }
    }



}
