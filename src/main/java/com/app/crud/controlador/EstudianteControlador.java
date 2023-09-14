package com.app.crud.controlador;

import com.app.crud.entidad.Estudiante;
import com.app.crud.repositorio.EstudianteRepositorio;
import com.app.crud.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstudianteControlador {
    @Autowired
    private EstudianteServicio estudianteServicio;
    @GetMapping({"/estudiantes","/"})
    public String listar(Model model){
        model.addAttribute("estudiantes",estudianteServicio.listarEstudiantes());
        return "estudiantes";
    }

    @GetMapping("/estudiantes/nuevo")
    public String mostrarFormularioRegistroEstudiantes(Model model){
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante){
        estudianteServicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }
    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id,Model model){
        model.addAttribute("estudiante", estudianteServicio.obtenerEstudiantePorId(id));
        return "editar_estudiante";
    }
    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id,@ModelAttribute("estudiante") Estudiante estudiante,Model model){
        Estudiante estudianteExistente = estudianteServicio.obtenerEstudiantePorId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());
        estudianteServicio.actualizarEstudiante(estudianteExistente);
        return "redirect:/estudiantes";
    }
    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        estudianteServicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
