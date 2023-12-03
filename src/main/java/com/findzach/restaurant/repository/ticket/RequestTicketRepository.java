package com.findzach.restaurant.repository.ticket;

import com.findzach.restaurant.model.entities.contact.RequestTicket;
import com.findzach.restaurant.model.entities.contact.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Zach Smith
 * @date: 12/3/2023
 * @time: 9:13 AM
 */
@Repository
public interface RequestTicketRepository extends JpaRepository<RequestTicket, Long> {

    List<RequestTicket> findAllByTicketStatus(TicketStatus status);

}
