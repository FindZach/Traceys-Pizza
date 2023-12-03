package com.findzach.restaurant.service.ticket.impl;

import com.findzach.restaurant.model.entities.contact.RequestTicket;
import com.findzach.restaurant.model.entities.contact.TicketStatus;
import com.findzach.restaurant.repository.ticket.RequestTicketRepository;
import com.findzach.restaurant.service.ticket.RequestTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Zach Smith
 * @date: 12/3/2023
 * @time: 9:15 AM
 */
@Service
public class RequestTicketServiceImpl implements RequestTicketService {

    private final RequestTicketRepository requestTicketRepository;

    @Autowired
    public RequestTicketServiceImpl(RequestTicketRepository requestTicketRepository) {
        this.requestTicketRepository = requestTicketRepository;
    }

    /**
     * @return
     */
    @Override
    public List<RequestTicket> findAll() {
        return requestTicketRepository.findAll();
    }

    /**
     * @param aLong
     * @return
     */
    @Override
    public RequestTicket findById(Long aLong) {
        return requestTicketRepository.findById(aLong).orElse(null);
    }

    /**
     * @param object
     * @return
     */
    @Override
    public RequestTicket create(RequestTicket object) {
        return requestTicketRepository.save(object);
    }

    /**
     * @param object
     * @return
     */
    @Override
    public boolean delete(RequestTicket object) {
        requestTicketRepository.delete(object);
        return true;
    }

    /**
     * @param aLong - The ID of the object
     * @return
     */
    @Override
    public boolean deleteById(Long aLong) {
        requestTicketRepository.deleteById(aLong);
        return true;
    }

    /**
     * @param status The TicketStatus you want to find
     * @return List<RequestTicket> All of the RequestTickets with the specific TicketStatus
     */
    @Override
    public List<RequestTicket> getRequestTicketByStatus(TicketStatus status) {
        return requestTicketRepository.findAllByTicketStatus(status);
    }
}
