package edu.pe.utp.grupo3.hoteldescansoeterno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.pe.utp.grupo3.hoteldescansoeterno.viewmodel.HabitacionView;

import java.util.List;

/**
 * Catálogo de habitaciones y formulario de "solicitud de reserva".
 * Para este avance del entregable NO persiste nada en base de datos:
 * solo confirma la solicitud con un mensaje flash.
 */
@Controller
public class HabitacionesController {

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        List<HabitacionView> habitaciones = DatosDemo.habitacionesDestacadas();

        model.addAttribute("activePage", "habitaciones");
        model.addAttribute("habitaciones", habitaciones);
        return "habitaciones";
    }

    @PostMapping("/habitaciones/solicitar")
    public String solicitarReserva(
            @RequestParam String nombre,
            @RequestParam String habitacion,
            @RequestParam String fechaEntrada,
            @RequestParam String fechaSalida,
            RedirectAttributes redirectAttrs) {

        // Aún no se guarda en base de datos: solo se confirma al usuario.
        redirectAttrs.addFlashAttribute("mensajeExito",
            "Gracias " + nombre + ", tu solicitud para la habitación " + habitacion +
            " (" + fechaEntrada + " a " + fechaSalida + ") fue recibida. Te contactaremos para confirmar.");
        return "redirect:/habitaciones";
    }
}