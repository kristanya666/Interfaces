import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketManager manager = new TicketManager();


    Ticket ticket1 = new Ticket(1, 974, "VKO", "KZN", 1.5);
    Ticket ticket2 = new Ticket(2, 2188, "VKO", "KZN", 1.5);
    Ticket ticket3 = new Ticket(3, 3500, "VKO", "KZN", 7.5);
    Ticket ticket4 = new Ticket(4, 3495, "VKO", "KZN", 6.5);
    Ticket ticket5 = new Ticket(5, 8798, "VKO", "KJA", 4);
    Ticket ticket6 = new Ticket(6, 1390, "SVO", "KGD", 2.5);


    @Test
    public void shouldFindAllTickets() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        manager.save(ticket6);


        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = manager.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTickets() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        manager.save(ticket6);


        Ticket[] expected = {ticket1, ticket2, ticket4, ticket3};
        Ticket[] actual = manager.findAll("VKO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsTwo() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        manager.save(ticket6);


        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll("VKO", "KJA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        manager.save(ticket6);

        manager.remove(5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket6};
        Ticket[] actual = manager.getTickets();

        Assertions.assertArrayEquals(expected, actual);


    }


}
