package org.mscoders.citas_medicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;

class ConexionTest {

    @Test
    void conectarbd() {
        Connection connection = Conexion.conectarBD();
        assertNotNull(connection);
    }
}