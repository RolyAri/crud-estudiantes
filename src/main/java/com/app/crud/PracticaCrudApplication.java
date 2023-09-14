package com.app.crud;

import com.app.crud.entidad.Estudiante;
import com.app.crud.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticaCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PracticaCrudApplication.class, args);
	}

	@Autowired
	private EstudianteRepositorio estudianteRepositorio;
	@Override
	public void run(String... args) throws Exception {
		/*Estudiante estudiante1 = new Estudiante("Alan","Garcia","alan@mail.com");
		estudianteRepositorio.save(estudiante1);
		Estudiante estudiante2 = new Estudiante("Martin","Vizcarra","mvizcarra@mail.com");
		estudianteRepositorio.save(estudiante2);*/
	}
}
