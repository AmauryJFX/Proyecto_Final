package org.mscoders.citas_medicas.BaseDatos;

import org.junit.jupiter.api.Test;
import org.mscoders.citas_medicas.model.Doctor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CRUD_DoctorTest {

    @Test
    void create() {

        Doctor doc = new Doctor();
        boolean res = false;
        doc.setId(null);
        doc.setCorreo("D1");
        doc.setUsuario("U1");
        doc.setContrasena("C1");
        doc.setNombre("N1");
        doc.setEspecialidad("E1");
        doc.setCedula("C1");
        doc.setTelefono("T1");
        res = CRUD_Doctor.Create(doc);

        System.out.println("OK");
    }

    @Test
    void read() {

        Doctor doc = new Doctor();
        List<Doctor> docs = CRUD_Doctor.Read();
        assertNotNull(docs);
        assertFalse(docs.isEmpty());
        assertEquals(5,  docs.size());
        docs.stream().forEach(System.out::println);


    }

    @Test
    void update() {

        Doctor doc = new Doctor();
        boolean res = false;
        doc.setId(1);
        doc.setCorreo("D2");
        doc.setUsuario("U2");
        doc.setContrasena("C2");
        doc.setNombre("N2");
        doc.setEspecialidad("E2");
        doc.setCedula("C2");
        doc.setTelefono("T2");
        res = CRUD_Doctor.Update( doc );
        assertTrue( res );
        System.out.println( doc );
    }

    @Test
    void delete() {

        Doctor doc = new Doctor();
        boolean res = false;
        doc.setId(2);
        res = CRUD_Doctor.Delete( doc );
        assertEquals(true, res);



    }
}
