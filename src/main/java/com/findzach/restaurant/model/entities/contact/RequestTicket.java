package com.findzach.restaurant.model.entities.contact;

import com.findzach.restaurant.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author: Zach Smith
 * @date: 12/3/2023
 * @time: 9:08 AM
 *
 * Represents a Ticket that will sustain state for our
 */
@Entity
public class RequestTicket extends BaseEntity {

    private final String fullName;
    private final String email;
    private final String phone;
    private final String message;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    public RequestTicket(String fullName, String email, String phone, String message, TicketStatus ticketStatus) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.message = message;
        this.ticketStatus = ticketStatus;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMessage() {
        return message;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
