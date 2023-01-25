package com.techelevator.models;

import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger implements Closeable {

    // should open the file and the close the file.  Java has a method to close the file!

    private String txtFile = "Audit.txt";
    private File logFile;  // holds the logfile object
    private PrintWriter writer;  // writer instantiation of the Printwriter class

    public Logger(String pathName) { // constructor will set up File object
        this.logFile = new File(pathName);
        if (this.logFile.exists()) {
            try {
                this.writer = new PrintWriter(new FileWriter(this.logFile, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.writer = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // if this logFile exits we want to append
            // if it doesn't, we want to create!

        }
    }

    @Override
    public void close() throws IOException {
        this.writer.close();
    }


    //write a date format
    public String getDateAndTime() {
        DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        return dateformat.format(new Date());
    }

    //method to write the report
    public void auditFileWrite(String event, String location, String balanceBeforeTransaction,
                               String balanceAfterTransaction) {

        String auditOutput  = String.format("%-30s %-15s %-6s %-6s  %-6s\n", getDateAndTime(),event, location,
                balanceBeforeTransaction, balanceAfterTransaction);
        this.writer.print(auditOutput);
        this.writer.flush();

    }
}
