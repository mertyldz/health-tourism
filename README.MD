# Health Tourism Project

## Project Explanation
### Project
The Health Tourism Management System is a comprehensive web application designed to streamline and facilitate health 
tourism services. This system encompasses various categories such as patients, doctors, hospitals, hotels, flights, 
and airplane tickets, allowing users to search for doctors based on their medical specialties like hair transplantation,
eye surgery, etc. Here's an overview of the key functionalities and features of the system:
### Roles
Public Users: They can search for doctors, flights, and hotels without the need to log in.

Registered Users: They can make reservations for medical appointments. Registration is required to access this feature.

Admin Users: They have the authority to manage the system, including defining hospitals, airplanes, and hotels. 
They also handle the availability of hotel rooms and flight tickets.

Doctor Users: They have the authority to manage the examinations.

### System Workflow
1. Doctor and Hospital Selection: Before making an appointment, users need to select a hospital and a doctor. 
The choice of hospitals depends on the location (city) of the hospital.
2. Flight Reservation: After selecting a doctor and hospital, users can search for available flights. 
They choose departure and arrival locations (e.g., Istanbul to Izmir) and view the list of suitable flights. 
Once they pick a flight, they can proceed with the hotel selection.
3. Hotel Reservation: Following the flight reservation, users need to book a hotel for their stay. 
They have a limited time (e.g., 10 minutes) to complete the hotel booking. If they fail to book a hotel within the 
allocated time, their flight reservation will be canceled.
4. Medical Appointment: After completing the flight and hotel reservations, users attend their medical appointment. 
Doctors then examine patients and generate medical reports. These reports are stored as text data in the system.
5. Security: The application employs security measures to protect its endpoints. Only authorized users can access 
specific features based on their roles.

## Prerequisites 
 
Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK) 17**: Download and install JDK 17 or a compatible version.
- **Maven**: Download and install Maven for managing project dependencies.
- **Database (e.g., PostgreSQL)**: You'll need a database system to store data.

Follow these steps to set up the project:
```bash
git clone https://github.com/mertyldz/health-tourism.git
cd health-tourism
mvn clean install
mvn spring-boot:run
```
The application will run at http://localhost:8080 by default.