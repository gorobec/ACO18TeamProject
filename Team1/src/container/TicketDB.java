package container;

import container.IDB.IDataBase;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Мастер on 21.02.2017.
 */
public class TicketDB implements IDataBase<Ticket> {
    private List<Ticket> tickets = new ArrayList<>();

    public TicketDB(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public TicketDB() {
    }

    @Override
    public boolean add(Ticket ticket) {
        return tickets.add(ticket);
    }

    @Override
    public Ticket remove(int id) {
        Ticket ticket = tickets.get(id);
        tickets.remove(ticket);
        return ticket;
    }

    @Override
    public Ticket get(int id) {
        return tickets
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Ticket> getAll() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}