package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.TicketRepo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagerTest {
    Ticket[] list = {new Ticket(1, 1200, "PDL", "LED", 320),
            new Ticket(2, 1000, "TLV", "LED", 189),
            new Ticket(3, 850, "TLV", "LED", 309),
            new Ticket(4, 500, "TLV", "LED", 729),
            new Ticket(5, 700, "VKO", "LED", 60)};
    TicketRepo repo = new TicketRepo(list);
    Manager man = new Manager(repo);

    @Test
    void shouldFindAll() {
        Ticket[] expected = {new Ticket(2, 1000, "TLV", "LED", 189),
                new Ticket(3, 850, "TLV", "LED", 309),
                new Ticket(4, 500, "TLV", "LED", 729)};
        Ticket[] actual = man.findAll("LED", "TLV", new Ticket.TicketComparator());
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSingleTicket() {
        Ticket[] expected = {new Ticket(1, 1200, "PDL", "LED", 320)};
        Ticket[] actual = man.findAll("LED", "PDL", new Ticket.TicketComparator());
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSingleTicket() {
        Ticket[] actual = man.findAll("LED", "NJC", new Ticket.TicketComparator());
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCheckSortingByTravelTime() {
        Ticket[] actual = man.findAll("LED", "TLV", new Ticket.TicketComparator());
        Ticket prevTicket = null;
        for (Ticket ticket : actual) {
            if (prevTicket != null) {
                assertTrue(prevTicket.getTravelTime() < ticket.getTravelTime());
            }
            prevTicket = ticket;
        }
    }
}
