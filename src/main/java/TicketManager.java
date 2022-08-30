import java.util.Arrays;

public class TicketManager {
    TicketRepository repo = new TicketRepository();


    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getDepartureAirport().contains(from)) {
            if (ticket.getArrivalAirport().contains(to)) {
                return true;
            }
        }
        return false;
    }


    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repo.getAllTickets()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;

            }
        }
        return result;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] tickets = searchBy(from, to);

        Arrays.sort(tickets);

        return tickets;
    }

    public void save(Ticket ticket) {
        repo.add(ticket);
    }

    public void remove(int id) {
        repo.removeTicketById(id);
    }

    public Ticket[] getTickets() {
        return repo.getAllTickets();
    }


}

