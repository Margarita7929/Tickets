package ru.netology;

import java.util.Arrays;

public class TicketsManager {

    private Repository repo;

    public TicketsManager(Repository repo) {
        this.repo = repo;
    }


    public void add(TicketInformation ticket) {
        repo.save(ticket);
    }


    public TicketInformation[] searchBy(String from, String to) {
        TicketInformation[] result = new TicketInformation[0];
        for (TicketInformation ticket : repo.findAll()) {
            if ((matchesDepartureAirport(ticket, from)) && (matchesArrivalAirport(ticket, to))) {
                TicketInformation[] tmp = new TicketInformation[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                Arrays.sort(tmp);
                result = tmp;
            }
        }
        return result;
    }


    public boolean matchesDepartureAirport(TicketInformation ticket, String search) {
        if (ticket.getDepartureAirport().contains(search)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean matchesArrivalAirport(TicketInformation ticket, String search) {
        if (ticket.getArrivalAirport().contains(search)) {
            return true;
        } else {
            return false;
        }

    }


}