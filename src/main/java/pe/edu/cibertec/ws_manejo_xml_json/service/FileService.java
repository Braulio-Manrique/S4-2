package pe.edu.cibertec.ws_manejo_xml_json.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ws_manejo_xml_json.model.Persona;
import pe.edu.cibertec.ws_manejo_xml_json.model.PersonaLista;
import java.io.File;
import java.util.List;

@Slf4j
@Service
public class FileService {
    private  final  String XML_FILE_PATH = "alumno.xml";
    private  final  String JSON_FILE_PATH = "alumno.json";

    public void crearArchivoXML(Persona persona) throws Exception{
        JAXBContext context = JAXBContext.newInstance(Persona.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(persona, new File(XML_FILE_PATH));
    }
    public void crearArchivoXMLList(List<Persona> personaList) throws Exception{
        PersonaLista personas = new PersonaLista(personaList);
        JAXBContext context = JAXBContext.newInstance(PersonaLista.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(personas, new File(XML_FILE_PATH));

    }
    public  void  crearJson(Persona persona) throws Exception{
        ObjecMapper objecMapper = new ObjectMapper();
        objecMapper.writerWithDefaltPretyPrinter().writeValue(new File(JSON_FILE_PATH),persona);
    }
}
