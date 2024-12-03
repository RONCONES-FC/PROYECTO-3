package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTest {

    private Usuario usuario1;
    private Usuario usuario2;
    private List<Usuario> usuarios;

    @BeforeEach
    void setUp() {
        usuario1 = new Usuario("usuario1", "password1");
        usuario2 = new Usuario("usuario2", "password2");

        usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
    }

    @Test
    void testAutenticarUsuario() {
        Usuario autenticado = Usuario.autenticarUsuario("usuario1", "password1", usuarios);
        assertNotNull(autenticado);
        assertEquals("usuario1", autenticado.getUsuario());

        Usuario noAutenticado = Usuario.autenticarUsuario("usuario1", "wrongPassword", usuarios);
        assertNull(noAutenticado);
    }
}


    