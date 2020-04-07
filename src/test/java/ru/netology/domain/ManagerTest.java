package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    TicketRepo repo = new TicketRepo();
    Manager man = new Manager(repo);

    @Test
    void shouldFindAll() {
        Ticket[] expected = {new Ticket(4, 500, "TLV", "LED", 12.15),
                new Ticket(3, 850, "TLV", "LED", 5.15),
                new Ticket(2, 1000, "TLV", "LED", 3.15)};
        Ticket[] actual = man.findAll("LED", "TLV");
        assertArrayEquals(expected, actual);
    }
}