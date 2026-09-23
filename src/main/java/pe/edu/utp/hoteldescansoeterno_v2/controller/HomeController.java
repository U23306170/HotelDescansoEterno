package edu.pe.utp.grupo3.hoteldescansoeterno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.pe.utp.grupo3.hoteldescansoeterno.viewmodel.HabitacionView;

import java.util.List;

/**
 * Página de inicio.
 * Los datos de habitaciones son estáticos (no vienen de base de datos),
 * solo para propósitos de este avance del entregable.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        List<HabitacionView> habitaciones = DatosDemo.habitacionesDestacadas();

        long libres = habitaciones.stream().filter(HabitacionView::isDisponible).count();

        model.addAttribute("activePage", "home");
        model.addAttribute("habitaciones", habitaciones);
        model.addAttribute("habitacionesLibres", libres);
        model.addAttribute("totalHabitaciones", habitaciones.size());
        return "index";
    }
}