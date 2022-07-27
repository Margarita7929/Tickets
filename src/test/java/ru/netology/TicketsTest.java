package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketsTest {

    TicketInformation ticket1 = new TicketInformation(1, 100, "Moscow", "LA", 12);
    TicketInformation ticket2 = new TicketInformation(2, 200, "Minsk", "Stambul", 3);
    TicketInformation ticket3 = new TicketInformation(3, 300, "Rio", "Mexico", 5);
    TicketInformation ticket4 = new TicketInformation(4, 400, "Rome", "Paris", 3);
    TicketInformation ticket5 = new TicketInformation(5, 450, "Rome", "Paris", 2);

    Repository repo = new Repository();
    TicketsManager manager = new TicketsManager(repo);

    @Test
    public void searchOneTicket() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        TicketInformation[] expected = {ticket3};
        TicketInformation[] actual = manager.searchBy("Rio", "Mexico");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchIfThereAreNoSuchTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);


        TicketInformation[] expected = {};
        TicketInformation[] actual = manager.searchBy("London", "Vancouver");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfOnlyOneSuitAirport() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);


        TicketInformation[] expected = {};
        TicketInformation[] actual = manager.searchBy("Rio", "Venice");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfSeveralSuitableTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);


        TicketInformation[] expected = {ticket4, ticket5};
        TicketInformation[] actual = manager.searchBy("Rome", "Paris");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchIfNoAddedTickets() {


        TicketInformation[] expected = {};
        TicketInformation[] actual = manager.searchBy("Rome", "Paris");
        Assertions.assertArrayEquals(expected, actual);
    }


}
