package com.example.reservation.controller;
import com.example.reservation.entity.User;
import com.example.reservation.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class CancellationController {
    @Autowired private ReservationService reservationService;
    @GetMapping("/cancel") public String page(){return"cancel";}
    @PostMapping("/cancel")
    public String cancel(@RequestParam String pnr,HttpSession s,Model m){
        User u=(User)s.getAttribute("user"); if(u==null) return"redirect:/login";
        boolean c=reservationService.cancelReservation(pnr,u);
        m.addAttribute("message",c?"✅ Ticket cancelled!":"⚠️ Invalid PNR!"); return"cancel";
    }
}
