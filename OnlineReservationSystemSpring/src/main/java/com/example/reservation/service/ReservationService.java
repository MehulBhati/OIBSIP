package com.example.reservation.service;
import com.example.reservation.entity.Reservation;
import com.example.reservation.entity.User;
import com.example.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ReservationService {
    @Autowired private ReservationRepository reservationRepository;
    public Reservation makeReservation(Reservation r, User user) {
        r.setPnr(UUID.randomUUID().toString().substring(0,8));
        r.setUser(user);
        r.setTrainName(getTrainName(r.getTrainNumber()));
        return reservationRepository.save(r);
    }
    public boolean cancelReservation(String pnr, User user) {
        Optional<Reservation> res = reservationRepository.findById(pnr);
        if (res.isPresent()) {
            reservationRepository.deleteById(pnr); return true;
        } return false;
    }
    public List<Reservation> getReservations(User user) {
        return reservationRepository.findByUser(user);
    }
    private String getTrainName(String trainNumber) {
        return switch (trainNumber) {
            case "101" -> "Rajdhani Express";
            case "102" -> "Shatabdi Express";
            case "103" -> "Duronto Express";
            default -> "Local Passenger";
        };
    }
}
