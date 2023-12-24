Feature: Installer Tasks

Scenario: Add free appointment
 Given that installer is logged in with email "s12028227@stu.najah.edu" and he wants to add a free appointment
 And he enters appointment date "20/12/2023" and appointment day "Wedensday" and appointment hour "2:30 AM" and his name "Installer Name"
 Then the appointment will be added successfully
 
 Scenario: View the appointments added by installer
 Given that installer is logged in with email "s12028227@stu.najah.edu" and he wants to see his appointments
 Then the appointments will found and printed
 
 Scenario: Installer with no free appointments tries to view his appointments
 Given that installer is logged in with email "dana@gmail.com" and he wants to see his appointments
 Then the appointments will not be found and printed
 
 Scenario: View the appointments that are booked by customers
 Given that installer is logged in with email "s12028227@stu.najah.edu" and he wants to see the booked appointments
 Then the booked appointments will found and printed
 
 Scenario: Installer that has no booked appointments from customers tries to see the booked appointments
 Given that installer is logged in with email "leema@gmail.com" and he wants to see the booked appointments
 Then the booked appointments will not be found and printed
 
Scenario: Delete appointment
 Given that installer is logged in with email "s12028227@stu.najah.edu" and he wants to delete the appointment that has the number 1
 Then the appointment will be deleted
