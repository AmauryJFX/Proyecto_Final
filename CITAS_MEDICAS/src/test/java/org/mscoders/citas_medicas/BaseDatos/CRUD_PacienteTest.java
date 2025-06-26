package org.mscoders.citas_medicas.BaseDatos;

import org.junit.jupiter.api.Test;
import org.mscoders.citas_medicas.model.Paciente;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CRUD_PacienteTest {

    @Test
    void create() {

        Paciente pa = new Paciente();
        boolean res = false;
        pa.setCorreo("A3");
        pa.setUsuario("B3");
        pa.setContrasena("C3");
        pa.setNombre("D3");
        pa.setNacimiento(LocalDate.now());
        pa.setTelefono("F3");
        pa.setHis_medico_id( 3 );

        res = CRUD_Paciente.Create( pa );

        assertTrue(res);
        System.out.println( pa );
    }

    @Test
    void read() {

    List<Paciente> pacientes = CRUD_Paciente.Read();
    assertNotNull( pacientes );
    assertFalse( pacientes.isEmpty() );
    assertEquals(2, pacientes.size());
    pacientes.stream().forEach(System.out::println);

    }

    @Test
    void Update() {

        Paciente pa = new Paciente();
        boolean res = false;
        pa.setId(1);
        pa.setCorreo("C2");
        pa.setUsuario("B2");
        pa.setContrasena("C2");
        pa.setNombre("A2");
        pa.setNacimiento(LocalDate.now());
        pa.setTelefono("T2");
        pa.setHis_medico_id( 2 );

        res = CRUD_Paciente.Update( pa );

        assertTrue(res);
        System.out.println( pa );

    }

    @Test
    void delete() {

        Paciente pa = new Paciente();
        boolean res = false;
        pa.setId(1);
        res = CRUD_Paciente.Delete( pa );
        assertEquals( true, res );



    }


}