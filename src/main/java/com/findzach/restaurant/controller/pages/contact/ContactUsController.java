package com.findzach.restaurant.controller.pages.contact;

import com.findzach.restaurant.controller.BaseController;
import com.findzach.restaurant.model.entities.contact.RequestTicket;
import com.findzach.restaurant.model.entities.contact.TicketStatus;
import com.findzach.restaurant.model.session.SessionUser;
import com.findzach.restaurant.service.session.SessionService;
import com.findzach.restaurant.service.ticket.RequestTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author: Zach Smith
 * @date: 12/2/2023
 * @time: 8:47 PM
 */
@RequestMapping("contact")
@Controller
public class ContactUsController extends BaseController {

    private Set<UUID> ticketsCreatedUUIDSet = new HashSet<>();
    private final RequestTicketService requestTicketService;

    @Autowired
    public ContactUsController(SessionService sessionService, RequestTicketService requestTicketService) {
        super(sessionService, "pages/contact-us");
        this.requestTicketService = requestTicketService;
    }

    /**
     * @param model
     * @param session
     * @return
     */
    @GetMapping
    @Override
    public String showPage(Model model, HttpSession session) {
        String uniqueToken = UUID.randomUUID().toString();

        SessionUser sessionUser = sessionService.getSessionUser(session.getId());
        if (sessionUser != null) {
            session.setAttribute("contactToken", uniqueToken);
        }
        return super.showPage(model, session);
    }

    @PostMapping
    public String contactRequest(HttpSession session, @RequestParam("fullname") String fullname, @RequestParam("email") String email,
                                       @RequestParam("phone") String phone,
                                       @RequestParam("message") String message) {

        UUID contactToken = UUID.fromString(String.valueOf(session.getAttribute("contactToken")));
        if (ticketsCreatedUUIDSet.contains(contactToken)) {
            return "pages/contact-us";
        }
        // TODO: Create Ticket
        RequestTicket newTicket = new RequestTicket(fullname, email, phone, message, TicketStatus.AWAITING_EMPLOYEE_RESPONSE);
        requestTicketService.create(newTicket);
        ticketsCreatedUUIDSet.add(contactToken);

        System.out.println("Created Contact Ticket!");
        return "pages/contact-us";
    }
}
