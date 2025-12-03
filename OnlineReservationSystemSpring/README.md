# 🚆 Online Railway Reservation System
### ✨ A Realistic Full-Stack Ticket Booking Application built with **Spring Boot, Thymeleaf & MySQL**

![Java](https://img.shields.io/badge/Java-23-orange?logo=coffeescript)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.1-brightgreen?logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?logo=mysql)
![License](https://img.shields.io/badge/License-MIT-yellow)
![Status](https://img.shields.io/badge/Project%20Status-Active-success)

> 💡 A full-fledged Online Railway Reservation System that allows users to register, log in, reserve tickets, view their bookings, and cancel reservations — all wrapped in a clean, realistic IRCTC-style interface.

---

## 🌟 Features

✅ **User Registration & Login**  
Secure authentication with session handling and error validation.

✅ **Ticket Booking**  
Users can reserve tickets with passenger details, source, destination, train info & journey date.  
Automatically generates a **unique PNR** for each booking.

✅ **My Reservations**  
Displays all booked tickets with complete details in a tabular format.

✅ **Cancellation**  
Cancel your ticket using your PNR number — instant confirmation shown.

✅ **Beautiful Realistic UI**  
Custom CSS + Railway background and ticket images for an immersive experience.

---

## 🧠 Tech Stack

| Layer | Technology |
|--------|-------------|
| 🧩 Backend | Spring Boot, Spring MVC, Spring Data JPA |
| 🎨 Frontend | Thymeleaf, HTML5, CSS3 |
| 🗄️ Database | MySQL |
| 🛠️ Tools | IntelliJ IDEA, Maven |
| 🌍 Version Control | Git & GitHub |

---

## 🧩 Project Structure

src/main/
├─ java/com/example/reservation/
│ ├─ controller/
│ │ ├─ AuthController.java
│ │ ├─ ReservationController.java
│ │ └─ CancellationController.java
│ ├─ model/
│ │ ├─ User.java
│ │ └─ Reservation.java
│ ├─ repository/
│ │ ├─ UserRepository.java
│ │ └─ ReservationRepository.java
│ ├─ service/
│ │ ├─ UserService.java
│ │ └─ ReservationService.java
│ └─ OnlineReservationSystemApplication.java
│
└─ resources/
├─ static/
│ ├─ css/style.css
│ └─ images/
│ ├─ train-bg.jpg
│ ├─ ticket.jpg
│ └─ logo.png
└─ templates/
├─ login.html
├─ register.html
├─ reservation.html
├─ myreservations.html
├─ cancel.html
└─ success.html


---

## ⚙️ How to Run Locally

1️⃣ **Clone the repository**
```bash
git clone https://github.com/MehulBhati/online-railway-reservation.git
cd online-railway-reservation


2️⃣ Configure MySQL

Create a database named reservation_db

Update credentials in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/reservation_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


3️⃣ Run the project

mvn spring-boot:run


4️⃣ Access the app
👉 http://localhost:8080/login

🖼️ Screenshots
Page	Preview
🧍 Login	

🎟️ Ticket Success	
🚀 Future Enhancements

✉️ Email notification after booking

🔐 Role-based admin dashboard

🪑 Seat selection system

🚉 Real-time train data integration via public APIs

👨‍💻 About the Developer
Mehul Bhati

B.Tech student | Java Backend Developer | Spring Boot Enthusiast

💬 "I love creating meaningful, production-ready applications that combine clean code with beautiful UI."