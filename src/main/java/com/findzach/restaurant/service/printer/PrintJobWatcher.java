package com.findzach.restaurant.service.printer;

import javax.print.DocPrintJob;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/17/2021
 */
public class PrintJobWatcher {
    // true if it is safe to close the print job's input stream
    private boolean done = false;

    public PrintJobWatcher() {

    }

    public PrintJobWatcher(DocPrintJob job) {
        setPrintJob(job);
    }

    public void setPrintJob(DocPrintJob job) {
        // Add a listener to the print job
        job.addPrintJobListener(
                new PrintJobAdapter() {
                    public void printJobCanceled(PrintJobEvent printJobEvent) {
                        allDone();
                    }

                    public void printJobCompleted(PrintJobEvent printJobEvent) {
                        allDone();
                    }

                    public void printJobFailed(PrintJobEvent printJobEvent) {
                        allDone();
                    }

                    public void printJobNoMoreEvents(PrintJobEvent printJobEvent) {
                        allDone();
                    }

                    void allDone() {
                        synchronized (PrintJobWatcher.this) {
                            done = true;
                            PrintJobWatcher.this.notify();
                        }
                    }
                });
    }

    public synchronized void waitForDone() {
        try {
            while (!done) {
                wait();
            }
        } catch (InterruptedException e) {
        }
    }
}
