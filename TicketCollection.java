package fit5171.monash.edu;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class  TicketCollection {
	
	public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();

	public static void addTickets(ArrayList<Ticket> tickets_db) {
		if (tickets_db == null) {
			throw new IllegalArgumentException("Ticket list cannot be null");
		}
		ArrayList<Ticket> validTickets = new ArrayList<>();

		for (Ticket ticket : tickets_db) {
			if (ticket == null || ticket.ticketStatus()) {
				continue;
			}

			boolean isDuplicate = false;

			for (Ticket validTicket: validTickets) {
				if (ticket.getTicket_id() == validTicket.getTicket_id()) {
					isDuplicate = true;
					break;
				}
			}

			if (isDuplicate) {
				continue;
			}

			for (Ticket exsitTicket: tickets) {
				if (exsitTicket.getTicket_id() == ticket.getTicket_id()) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				validTickets.add(ticket);
			}
		}
		TicketCollection.tickets.addAll(validTickets);
	}
	
	public static ArrayList<Ticket> getAllTickets() {
    	return tickets;
	}

	public static Ticket getTicketInfo(int ticket_id) {
		if (ticket_id < 0) {
			throw new IllegalArgumentException("Ticket id out of bounds");
		}
		for (Ticket ticket : tickets) {
			if (ticket.getTicket_id() == ticket_id) {
				return ticket;
			}
		}
		throw new IllegalArgumentException("Ticket with ID " + ticket_id + " not found");
	}

}
