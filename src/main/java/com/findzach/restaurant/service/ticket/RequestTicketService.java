package com.findzach.restaurant.service.ticket;

import com.findzach.restaurant.model.entities.contact.RequestTicket;
import com.findzach.restaurant.model.entities.contact.TicketStatus;
import com.findzach.restaurant.service.BaseEntityCrudService;

import java.util.List;

/**
 * @author: Zach Smith
 * @date: 12/3/2023
 * @time: 9:14 AM
 */
public interface RequestTicketService extends BaseEntityCrudService<RequestTicket, Long> {

    List<RequestTicket> getRequestTicketByStatus(TicketStatus status);

}
