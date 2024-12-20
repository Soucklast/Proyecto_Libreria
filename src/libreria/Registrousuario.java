/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package libreria;

import java.security.SecureRandom;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI THIN GF63
 */
public class Registrousuario extends javax.swing.JFrame {
    private int filaSeleccionada = -1;
    Connection conn;

    /**
     * Creates new form Registrousuario
     */
    public Registrousuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.conn = conexion.getConnection();
        consultarDatos();
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        contraseña2 = new libreria.Contraseña();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboUsuario = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usuarios = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(contraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("INGRESAR USUARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombres");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 58, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/generatekeysarrows_generar_llave_1490.png"))); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 30, 30));

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 251, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Apellidos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 60, -1));

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 251, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Correo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 251, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Categoria");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, -1));

        comboUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Administrador", "Cajero", " " }));
        comboUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(comboUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Contraseña");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 76, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GuardarTodo.png"))); // NOI18N
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir_1.png"))); // NOI18N
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descarga.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 450));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 450));

        usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String[] {
                "ID Usuario", "Nombre", "Apellidos", "Correo Electrónico", "Tipo de Usuario"
            }
        )
    );
    usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            usuariosMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(usuarios);

    jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 570, 351));

    jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
    jButton3.setText("ELIMINAR USUARIO");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });
    jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 610, -1, -1));

    jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Recargar.png"))); // NOI18N
    jButton4.setText("MODIFICAR");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });
    jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 610, -1, -1));

    jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/encabezado.png"))); // NOI18N
    jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 170));

    getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 948, 680));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        // Variables que contienen los datos ingresados por el usuario

        String nombre = txtNombres.getText();  // Nombre del usuario
        String apellidos = txtApellidos.getText();  // Apellidos del usuario
        String correoElectronico = txtCorreo.getText();  // Correo electrónico
        String tipoUsuario = comboUsuario.getSelectedItem().toString();  // Tipo de usuario ('Administrador' o 'Cliente')
        String password = contraseña2.getPasswordText();
 

        if (nombre.isEmpty() || apellidos.isEmpty() || correoElectronico.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe completar todos los datos.");
        } else if (!nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$")) { // Validar que el nombre no tenga caracteres especiales ni números
        JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras y espacios.");
        } else if (!apellidos.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$")) { // Validar que los apellidos no tengan caracteres especiales ni números
        JOptionPane.showMessageDialog(null, "Los apellidos solo deben contener letras y espacios.");
        } else if (tipoUsuario.equalsIgnoreCase("Seleccionar")) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de usuario.");
        } else {
            try {
                // Consulta SQL con parámetros placeholders
                String sql = "INSERT INTO usuarios (nombre, apellidos, correo_electronico, tipo_de_usuario, contrasena) VALUES (?, ?, ?, ?, ?)";

                // Preparar la consulta
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Asignar valores a los placeholders

                pstmt.setString(1, nombre);
                pstmt.setString(2, apellidos);
                pstmt.setString(3, correoElectronico);
                pstmt.setString(4, tipoUsuario);
                pstmt.setString(5, password);  // Recomendación: encriptar antes de guardar

                // Ejecutar la consulta
                pstmt.executeUpdate();

                // Limpiar campos y mostrar mensaje de éxito
                limpiar();
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
                consultarDatos();

                pstmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al registrar el usuario.");
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         int selectedRow = usuarios.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione un usuario para eliminar.");
        return;
    }

    int idUsuario = (int) usuarios.getValueAt(selectedRow, 0);
    try {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, idUsuario);
        pstmt.executeUpdate();
        consultarDatos(); // Refrescar la tabla
        pstmt.close();
        JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el usuario: " + ex.getMessage());
        ex.printStackTrace();
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
                    // Recuperar los datos ingresados en los campos de texto
String nombre2 = txtNombres.getText();
String apellidos2 = txtApellidos.getText();
String correoElectronico2 = txtCorreo.getText();
String tipoDeUsuario2 = comboUsuario.getSelectedItem().toString(); // ComboBox para el tipo de usuario

// Validar que los campos obligatorios no estén vacíos
if (nombre2.isEmpty() || apellidos2.isEmpty() || correoElectronico2.isEmpty() || tipoDeUsuario2.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Por favor, completa los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Obtener el ID del usuario seleccionado en la tabla
int selectedRow = usuarios.getSelectedRow(); // Cambia "tablaUsuarios" por el nombre de tu JTable
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario para editar.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}
int idUsuario2 = Integer.parseInt(usuarios.getValueAt(selectedRow, 0).toString()); // Cambia el índice si la columna ID es diferente

// Preparar la consulta SQL para editar los datos
String sql = "UPDATE usuarios SET nombre = ?, apellidos = ?, correo_electronico = ?, tipo_de_usuario = ? WHERE id_usuario = ?";

try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, nombre2);
    stmt.setString(2, apellidos2);
    stmt.setString(3, correoElectronico2);
    stmt.setString(4, tipoDeUsuario2);
    stmt.setInt(5, idUsuario2); // Usamos el ID del usuario seleccionado

    // Ejecutar la consulta
    int rowsUpdated = stmt.executeUpdate();
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        // Limpiar los campos de texto
        limpiar();

        // Actualizar la tabla con los datos nuevos
        consultarDatos();
    } else {
        JOptionPane.showMessageDialog(this, "No se encontró un usuario con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Error al actualizar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Por favor, ingresa datos válidos en los campos correspondientes.", "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariosMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = source.columnAtPoint(evt.getPoint());

if (row >= 0 && column >= 0) {
    filaSeleccionada = row; // Almacena la fila seleccionada

    // Obtener los valores de la fila seleccionada
    String idUsuario2 = source.getValueAt(row, 0).toString(); // id_usuario
    String nombre2 = source.getValueAt(row, 1).toString();    // nombre
    String apellidos2 = source.getValueAt(row, 2).toString(); // apellidos
    String correoElectronico2 = source.getValueAt(row, 3).toString(); // correo_electronico
    String tipoDeUsuario2 = source.getValueAt(row, 4).toString(); // tipo_de_usuario

    // Mostrar los valores de la fila seleccionada en los JTextField
  
    txtNombres.setText(nombre2);
    txtApellidos.setText(apellidos2);
    txtCorreo.setText(correoElectronico2);
    comboUsuario.setSelectedItem(tipoDeUsuario2);
}
    
    }//GEN-LAST:event_usuariosMouseClicked

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void comboUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUsuarioActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        String generatedPassword = Generarcontraseña(14); // Generar contraseña de 14 caracteres
        contraseña2.setPasswordText(generatedPassword);

    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed
void limpiar(){
            txtNombres.setText("");
            txtApellidos.setText("");
            txtCorreo.setText("");
            contraseña2.setPasswordText("");
        }

private void consultarDatos() {
    try {
        // Consulta SQL para obtener los datos de la tabla usuarios
        String sql = "SELECT id_usuario, nombre, apellidos, correo_electronico, tipo_de_usuario FROM usuarios";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        // Obtén el modelo de la tabla para actualizar los datos
        DefaultTableModel model = (DefaultTableModel) usuarios.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

        // Recorre los resultados y agrega las filas a la tabla
        while (rs.next()) {
            // Extrae los valores de cada columna
            int idUsuario = rs.getInt("id_usuario");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String correoElectronico = rs.getString("correo_electronico");
            String tipoDeUsuario = rs.getString("tipo_de_usuario");

            // Agrega la fila con los datos a la tabla
            model.addRow(new Object[]{idUsuario, nombre, apellidos, correoElectronico, tipoDeUsuario});
        }
        rs.close();
        pstmt.close();
    } catch (SQLException ex) {
        // Manejo de excepciones, por ejemplo, mostrar un mensaje de error
        System.err.println("Error al consultar datos de usuarios: " + ex.getMessage());
    }
}
 public static String Generarcontraseña(int length) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            password.append(chars.charAt(randomIndex));
        }

        return password.toString();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registrousuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrousuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrousuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrousuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrousuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboUsuario;
    private libreria.Contraseña contraseña2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTable usuarios;
    // End of variables declaration//GEN-END:variables
}
