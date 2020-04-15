package ru.netology.repository;

import ru.netology.domain.Ticket;

import java.util.NoSuchElementException;

public class TicketRepo {
    Ticket[] list;

    public TicketRepo(Ticket[] list) {
        this.list = list;
    }

    public Ticket[] getAll() {
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
                } else {
                    throw new NoSuchElementException();
                }
            }
            list = newArray;
        }
    }
}
