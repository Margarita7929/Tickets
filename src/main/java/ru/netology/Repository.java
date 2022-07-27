package ru.netology;

public class Repository {
    public TicketInformation[] tickets = new TicketInformation[0];

    public void save(TicketInformation id) {
        TicketInformation[] tmp = new TicketInformation[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = id;
        tickets = tmp;
    }

    public void removeById(int id) {
        TicketInformation[] tmp = new TicketInformation[tickets.length - 1];
        int copyToIndex = 0;
        for (TicketInformation ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public TicketInformation[] findAll() {
        return tickets;
    }
}


