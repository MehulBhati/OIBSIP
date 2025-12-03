package com.example.reservation.repository;
import com.example.reservation.entity.Reservation;
import com.example.reservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    List<Reservation> findByUser(User user);
}
