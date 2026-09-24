package pe.edu.utp.hoteldescansoeterno_v2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Muestra el formulario de login. Como este avance del entregable
 * no incluye Spring Security ni base de datos, el POST solo simula
 * el resultado (no autentica de verdad). Se reemplazará por
 * autenticación real (Spring Security) en un avance posterior.
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam String username,
            @RequestParam String password,
            RedirectAttributes redirectAttrs) {

        // TODO: reemplazar por autenticación real con Spring Security.
        redirectAttrs.addFlashAttribute("mensajeExito",
            "Bienvenido, " + username + " (inicio de sesión simulado).");
        return "redirect:/login";
    }
}