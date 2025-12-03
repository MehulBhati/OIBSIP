package com.example.reservation.controller;
import com.example.reservation.entity.Reservation;
import com.example.reservation.entity.User;
import com.example.reservation.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class ReservationController {
    @Autowired private ReservationService reservationService;
    @GetMapping("/reserve") public String form(Model m){m.addAttribute("reservation",new Reservation());return "reservation";}
    @PostMapping("/reserve")
    public String reserve(@ModelAttribute Reservation reservation,HttpSession s,Model m){
        User user=(User)s.getAttribute("user"); if(user==null) return "redirect:/login";
        Reservation saved=reservationService.makeReservation(reservation,user);
        m.addAttribute("pnr",saved.getPnr()); return "success";
    }
    @GetMapping("/my-reservations")
    public String list(HttpSession s,Model m){User u=(User)s.getAttribute("user"); if(u==null)return"redirect:/login";
        m.addAttribute("list",reservationService.getReservations(u));return"myreservations";}
}
