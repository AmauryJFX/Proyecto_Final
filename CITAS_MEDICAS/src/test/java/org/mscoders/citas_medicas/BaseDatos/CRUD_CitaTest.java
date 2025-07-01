package org.mscoders.citas_medicas.BaseDatos;

import org.junit.jupiter.api.Test;
import org.mscoders.citas_medicas.model.Cita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CRUD_CitaTest {

    @Test
    void Create() {


        Cita cita = new Cita();
        boolean res = false;
        cita.setMotivo ("M1");
        cita.setFecha(LocalDate.now());
        cita.setHora(LocalTime.now());
        cita.setEstado("M1");
        cita.setDoctor_id(1);
        cita.setPaciente_id(1);
        res = CRUD_Cita.Create( cita );

        System.out.println( cita );
    }

    @Test
    void read() {

        Cita cita = new Cita();
        List<Cita> citas = CRUD_Cita.Read();
            assertNotNull(citas);
            assertTrue( citas.size() >= 0);
            assertEquals(2, citas.size());
        citas.stream().forEach(System.out::println);

    }

    @Test
    void update() {

        Cita cita = new Cita();
        boolean res = false;
        cita.setId(2);
        cita.setMotivo ("M1_01");
        cita.setFecha(LocalDate.now());
        cita.setHora(LocalTime.now());
        cita.setEstado("M2_01");
        cita.setDoctor_id(1);
        cita.setPaciente_id(1);
        res = CRUD_Cita.Update( cita );
        assertTrue( res );

        System.out.println( cita );

    }

    @Test
    void Delete() {

        Cita cita = new Cita();
        boolean res = false;
        cita.setId(3);
        res = CRUD_Cita.Delete(cita);
        assertEquals(true, res);

        System.out.println("Eliminado");

    }

    @Test
    void buscarCitaPorId() {

        Cita cita = CRUD_Cita.buscarCitaPorId(1);
        assertNotNull(cita);
        assertEquals(cita.getId(), 1);
        System.out.println(cita);

    }

}

