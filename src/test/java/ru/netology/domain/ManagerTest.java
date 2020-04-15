package ru.netology.domain;

import org.junit.jupiter.api.Test;

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
        Ticket[] expected = {new Ticket(4, 500, "TLV", "LED", 729),
                new Ticket(3, 850, "TLV", "LED", 309),
                new Ticket(2, 1000, "TLV", "LED", 189)};
        Ticket[] actual = man.findAll("LED", "TLV");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSingleTicket() {
        Ticket[] expected = {new Ticket(1, 1200, "PDL", "LED", 320)};
        Ticket[] actual = man.findAll("LED", "PDL");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSingleTicket() {
        Ticket[] actual = man.findAll("LED", "NJC");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCheckSortingByPrice() {
        Ticket[] actual = man.findAll("LED", "TLV");
        Ticket prevTicket = null;
        for (Ticket ticket : actual) {
            if (prevTicket != null) {
                assertTrue(prevTicket.getPrice() < ticket.getPrice());
            }
            prevTicket = ticket;
        }
    }
}
