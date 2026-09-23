package edu.pe.utp.grupo3.hoteldescansoeterno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Página de contacto. El formulario no persiste nada en base de datos
 * para este avance: solo confirma el envío con un mensaje flash.
 */
@Controller
public class ContactoController {

    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("activePage", "contacto");
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarMensaje(
            @RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam String mensaje,
            RedirectAttributes redirectAttrs) {

        redirectAttrs.addFlashAttribute("mensajeExito",
            "Gracias " + nombre + ", recibimos tu mensaje. Te responderemos a " + correo + ".");
        return "redirect:/contacto";
    }
}