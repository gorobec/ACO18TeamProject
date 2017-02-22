package container;

import model.Product;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Мастер on 21.02.2017.
 */
public class TicketDB implements IDataBase<Ticket> {
    private List<Ticket> tickets = new ArrayList<>();


    @Override
    public boolean add(Ticket ticket) {
        return true;
    }

    @Override
    public Ticket remove(int id) {
        Ticket ticket = tickets.get(findTicketById(id));
        tickets.remove(ticket);
        return ticket;
    }

    @Override
    public Ticket get(int id) {
        return tickets.get(findTicketById(id));
    }

    @Override
    public List getAll() {
        return tickets;
    }


    private int findTicketById(int id){
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == id) return i;
        }
        return -1;
    }
}