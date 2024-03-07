package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num,flag=0;
        Event event = new Event();
        System.out.println("Enter the event ID: ");
        String eventID = scanner.nextLine();
        event.setEventID(eventID);
        System.out.println("Enter the event name: ");
        String eventName = scanner.nextLine();
        event.setEventName(eventName);
        System.out.println("Enter the event venue: ");
        String eventVenue = scanner.nextLine();
        event.setEventVenue(eventVenue);

        do {
            System.out.println("Enter the event date(format: yyyy/MM/dd):");
            String eventDate = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            try {
                Date date = dateFormat.parse(eventDate);
                event.setEventDate(date);
                flag=1;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in the format yyyy/MM/dd.");
            }
        }while (flag==0);
        System.out.println("Enter the number of attendees: ");
        num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the name of attendee " + (i + 1) + ": ");
            String attendee = scanner.nextLine();
            event.getEventAttendees().add(attendee);
        }
        event.organizeEvent();
        System.out.println(event);
        scanner.close();
    }
}