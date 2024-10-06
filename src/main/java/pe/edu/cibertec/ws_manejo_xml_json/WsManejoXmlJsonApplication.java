package pe.edu.cibertec.ws_manejo_xml_json;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.cibertec.ws_manejo_xml_json.model.Persona;
import pe.edu.cibertec.ws_manejo_xml_json.service.FileService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@SpringBootApplication
public class WsManejoXmlJsonApplication implements CommandLineRunner {
private final FileService fileService;
	public static void main(String[] args) {
		SpringApplication.run(WsManejoXmlJsonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Persona persona = new Persona("Braulio", "manrique","Callao",18);
		List<Persona> personaList = new ArrayList<>();
		personaList.add(persona);
		fileService.crearArchivoXMLList(personaList);
		//fileService.crearArchivoXML(persona);
		fileService.crearJson(persona);
	}
}
