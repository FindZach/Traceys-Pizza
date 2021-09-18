package com.findzach.restaurant.bootstrap;

import com.findzach.restaurant.model.Role;
import com.findzach.restaurant.model.customer.Customer;
import com.findzach.restaurant.model.employee.Employee;
import com.findzach.restaurant.repository.EmployeeRepository;
import com.findzach.restaurant.service.CustomerService;
import com.findzach.restaurant.service.printer.PrintJobWatcher;
import com.findzach.restaurant.service.printer.PrinterOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.print.*;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterName;
import java.util.Date;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
@Component
public class Bootstrap implements CommandLineRunner {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerService customerService;

    /**
     * Create Dummy Accounts for Testing purposes.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        Employee employee = new Employee();

        employee.setBirthday(new Date());
        employee.setFirstName("Zachary");
        employee.setLastName("Smith");
        employee.setEntityCreationDate(new Date());
        employee.setRole(Role.EMPLOYEE);

        employeeRepository.save(employee);

        Customer customer = new Customer();

        customer.setFirstName("Bret");
        customer.setLastName("Bock");
        customer.setEmail("bills@bills.com");
        customer.setRole(Role.CUSTOMER);

        customerService.create(customer);

    }


    private static void prepareBill() {
        PrinterOptions p=new PrinterOptions();

        p.resetAll();
        p.initialize();
        p.feedBack((byte)2);
        p.alignCenter();
        p.setText("Tracey's Pizza");
        p.newLine();
        p.setText("Rochesters Favorite Pizza");
        p.newLine();
        p.addLineSeperator();
        p.setText("go fuck urself bing bong");
        p.newLine();
        p.addLineSeperator();
        p.newLine();

        p.alignLeft();
        p.setText("Order #");
        p.alignRight();
        p.setText("9");
        p.alignLeft();
        p.newLine();

        p.setText("Res Date \t: " +  "01/01/1801 22:59");

        p.newLine();
        p.newLine();

        p.feed((byte)3);
        p.finit();

        feedPrinter(p.finalCommandSet().getBytes());
    }


    private static boolean feedPrinter(byte[] b) {
        try {
            AttributeSet attrSet = new HashPrintServiceAttributeSet(new PrinterName("POS-58", null)); //POS-58

            DocPrintJob job = PrintServiceLookup.lookupPrintServices(null, attrSet)[0].createPrintJob();
            //PrintServiceLookup.lookupDefaultPrintService().createPrintJob();

            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(b, flavor, null);
            PrintJobWatcher pjDone = new PrintJobWatcher(job);

            job.print(doc, null);
            pjDone.waitForDone();
            System.out.println("Done !");
        } catch (javax.print.PrintException pex) {
            System.out.println("Printer Error " + pex.getMessage());
            return false;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
