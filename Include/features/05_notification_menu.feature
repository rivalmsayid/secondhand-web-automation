@Notification
Feature: notification menu

   Scenario: User wants to access the notification menu
     Given user login with valid credentials
     And user already to dashboard page
     When user click button notifikasi menu
     Then system will display a list of notifications received by the user

     
  