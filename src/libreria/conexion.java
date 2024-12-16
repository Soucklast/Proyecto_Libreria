package libreria;

import java.sql.*;

public class conexion {
    private static Connection connection;
    
    // Método para establecer la conexión y validar tipo de usuario
    public static boolean conectar(String user, String password, String tipoDeUsuario) {
        try {
            // Establecer la conexión con la base de datos
            String url = "jdbc:mysql://localhost:3306/libreria"; // URL de la base de datos
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
            
            // Validar tipo de usuario después de la conexión
            if (validarTipoDeUsuario(user, password, tipoDeUsuario)) {
                return true; // Usuario validado y tipo correcto
            } else {
                // Si el tipo de usuario no es válido, cerramos la conexión y retornamos false
                desconectar();
                System.err.println("Tipo de usuario incorrecto.");
                return false; // Tipo de usuario no válido
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error de conexión: " + e.getMessage());
            return false; // Falló la conexión
        }
    }

    // Método para validar el tipo de usuario (administrador o cajero)
    private static boolean validarTipoDeUsuario(String user, String password, String tipoDeUsuario) {
        boolean esValido = false;
        try {
            // Consulta para validar el tipo de usuario
            String query = "SELECT * FROM usuarios WHERE correo_electronico = ? AND contrasena = ? AND tipo_de_usuario = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, user);
                stmt.setString(2, password);
                stmt.setString(3, tipoDeUsuario);
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) {
                    esValido = true; // Usuario encontrado y tipo validado
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return esValido;
    }

    // Método para obtener la conexión
    public static Connection getConnection() {
        return connection;
    }

    // Método para cerrar la conexión
    public static void desconectar() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

