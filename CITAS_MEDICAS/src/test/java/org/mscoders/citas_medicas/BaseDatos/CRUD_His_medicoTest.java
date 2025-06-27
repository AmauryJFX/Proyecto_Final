package org.mscoders.citas_medicas.BaseDatos;

import org.junit.jupiter.api.Test;
import org.mscoders.citas_medicas.model.His_Medico;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CRUD_His_medicoTest {

    @Test
    void create() {

        His_Medico hm = new His_Medico();
        boolean res = false;
        hm.setAlergia( "A1" );
        hm.setAntecedente( "B1 " );
        //res = CRUD_His_medico.Create( hm );
        System.out.println( hm );
    }

    @Test
    void read() {

        His_Medico hm = new His_Medico();
        List<His_Medico> hms = CRUD_His_medico.Read();
        assertNotNull(hms);
        assertFalse( hms.isEmpty() );
        assertEquals(2, hms.size());
        hms.stream().forEach(System.out::println);
    }

    @Test
    void update() {

        His_Medico hisMedico = new His_Medico();
        boolean res = false;

        hisMedico.setId( 2 );
        hisMedico.setAlergia("A2");
        hisMedico.setAntecedente("B2");

        res = CRUD_His_medico.Update( hisMedico );

        assertTrue( res );
        System.out.println( hisMedico );
    }

    @Test
    void delete() {

        His_Medico hm = new His_Medico();
        boolean res = false;
        hm.setId(1);
        res = CRUD_His_medico.Delete( hm );
        assertTrue( res );

    }
}