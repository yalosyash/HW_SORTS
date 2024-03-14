import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AviaSoulsTest {

    @Test
    public void shouldSortByPricePositive() {
        Ticket ticket1 = new Ticket("moscow", "samara", 15_000, 21, 23);
        Ticket ticket2 = new Ticket("moscow", "rostov on don", 8_000, 15, 17);

        int expect = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void shouldSortByPriceNegative() {
        Ticket ticket1 = new Ticket("moscow", "samara", 15_000, 21, 23);
        Ticket ticket2 = new Ticket("moscow", "rostov on don", 8_000, 15, 17);

        int expect = -1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void shouldSortByPriceEqual() {
        Ticket ticket3 = new Ticket("moscow", "volgograd", 5_000, 16, 17);

        int expect = 0;
        int actual = ticket3.compareTo(ticket3);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void shouldSortByPriceFromManager() {
        Ticket ticket1 = new Ticket("moscow", "samara", 15_000, 21, 23);
        Ticket ticket6 = new Ticket("moscow", "samara", 8_000, 21, 23);

        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket6);
        Ticket[] expect = {ticket6, ticket1};
        Ticket[] actual = manager.search("moscow", "samara");
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void shouldSortByFlyingTimeUsingComparator() {
        Ticket ticket1 = new Ticket("moscow", "samara", 15_000, 15, 20);
        Ticket ticket2 = new Ticket("moscow", "rostov on don", 8_000, 15, 17);
        Ticket ticket3 = new Ticket("moscow", "volgograd", 5_000, 15, 18);

        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] tickets = {ticket1, ticket2, ticket3};
        Arrays.sort(tickets, timeComparator);

        Ticket[] expect = {ticket2, ticket3, ticket1};

        Assertions.assertArrayEquals(expect, tickets);
    }

    @Test
    public void shouldSortByFlyingTimeUsingManager() {
        Ticket ticket1 = new Ticket("moscow", "samara", 15_000, 15, 20);
        Ticket ticket2 = new Ticket("moscow", "samara", 8_000, 15, 17);
        Ticket ticket3 = new Ticket("moscow", "samara", 5_000, 15, 18);
        Ticket ticket4 = new Ticket("moscow", "samara", 6_000, 15, 18);
        Ticket ticket5 = new Ticket("moscow", "vladivistok", 15_000, 21, 23);
        Ticket ticket6 = new Ticket("volgograd", "moscow", 8_000, 15, 17);

        AviaSouls manager = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Ticket[] expect = {ticket2, ticket3, ticket4, ticket1};
        Ticket[] actual = manager.searchAndSortBy("moscow", "samara", timeComparator);
        Assertions.assertArrayEquals(expect, actual);
    }
}