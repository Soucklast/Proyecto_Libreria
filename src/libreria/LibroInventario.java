/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import libreria.Loging.SesionUsuario;
/**
 *
 * @author daniela
 */
public class LibroInventario extends javax.swing.JFrame {

    /**
     * Creates new form LibroInventario
     */
    private int filaSeleccionada = -1;
    Connection conn;
    public LibroInventario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.conn = conexion.getConnection();
        consultarDatos();
        
           if (SesionUsuario.tipoUsuario.equalsIgnoreCase("Cajero")) {
           eliminar.setEnabled(false); // Bloquea el botón Eliminar
           ingresar.setEnabled(false); // Bloquea el botón Ingresar
           editar.setEnabled(false);   // Bloquea el botón Editar
        }
    }

    private boolean validarCamposLibro() {
        // Validar ISBN
        String isbnTexto = isbn.getText().trim();
        if (isbnTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'ISBN' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            isbn.requestFocus();
            return false;
        }
        if (!isbnTexto.matches("\\d{10}|\\d{13}")) {
            JOptionPane.showMessageDialog(this, "El ISBN debe contener 10 o 13 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            isbn.requestFocus();
            return false;
        }

        // Validar Stock
        String stockTexto = stock.getText().trim();
        if (stockTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El campo 'Stock' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        stock.requestFocus();
        return false;
        }
        if (!stockTexto.matches("^[0-9]+$")) { // Validar que solo sean números
            JOptionPane.showMessageDialog(this, "El Stock debe ser un número válido y no puede contener letras ni caracteres especiales.", "Error", JOptionPane.ERROR_MESSAGE);
        stock.requestFocus();
        return false;
        }
        int stockValor = Integer.parseInt(stockTexto);
        if (stockValor < 0) {
        JOptionPane.showMessageDialog(this, "El Stock no puede ser negativo.", "Error", JOptionPane.ERROR_MESSAGE);
        stock.requestFocus();
        return false;
        }

        // Validar Título
        String tituloTexto = titulo.getText().trim();
        if (tituloTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El campo 'Título' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        titulo.requestFocus();
        return false;
        }
        if (!tituloTexto.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9\\s\\-]+$")) { // Letras, números, espacios, guiones y acentos permitidos
        JOptionPane.showMessageDialog(this, "El título solo puede contener letras, números, espacios, guiones y acentos.", "Error", JOptionPane.ERROR_MESSAGE);
        titulo.requestFocus();
        return false;
        }

        // Validar Autor
        String autorTexto = autor.getText().trim();
        if (autorTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El campo 'Autor' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        autor.requestFocus();
        return false;
        }
        if (!autorTexto.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s\\-]+$")) { // Letras, espacios, guiones y acentos permitidos
        JOptionPane.showMessageDialog(this, "El autor solo puede contener letras, espacios, guiones y acentos.", "Error", JOptionPane.ERROR_MESSAGE);
        autor.requestFocus();
        return false;
        }

        // Validar Número de Páginas
        String noPaginasTexto = noPaginas.getText().trim();
        if (noPaginasTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El campo 'No. de Páginas' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        noPaginas.requestFocus();
        return false;
        }
        if (!noPaginasTexto.matches("^[0-9]+$")) { // Validar que solo sean números
     JOptionPane.showMessageDialog(this, "El campo 'No. de Páginas' debe contener solo números.", "Error", JOptionPane.ERROR_MESSAGE);
     noPaginas.requestFocus();
     return false;
        }
        int paginas = Integer.parseInt(noPaginasTexto);
        if (paginas <= 0) {
        JOptionPane.showMessageDialog(this, "El número de páginas debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
        noPaginas.requestFocus();
        return false;
        }

// Validar Año de Publicación (sin cambios)
String anioTexto = anioPublicacion.getText().trim();
if (anioTexto.isEmpty()) {
    JOptionPane.showMessageDialog(this, "El campo 'Año de Publicación' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
    anioPublicacion.requestFocus();
    return false;
}
try {
    int anio = Integer.parseInt(anioTexto);
    if (anio < 1500 || anio > java.time.Year.now().getValue()) {
        JOptionPane.showMessageDialog(this, "El año de publicación debe ser entre 1500 y el año actual.", "Error", JOptionPane.ERROR_MESSAGE);
        anioPublicacion.requestFocus();
        return false;
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "El campo 'Año de Publicación' debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
    anioPublicacion.requestFocus();
    return false;
}

// Validar Precio de Referencia (sin cambios)
String precioTexto = precioReferencia.getText().trim();
if (precioTexto.isEmpty()) {
    JOptionPane.showMessageDialog(this, "El campo 'Precio de Referencia' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
    precioReferencia.requestFocus();
    return false;
}
try {
    double precio = Double.parseDouble(precioTexto);
    if (precio <= 0) {
        JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
        precioReferencia.requestFocus();
        return false;
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "El campo 'Precio de Referencia' debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
    precioReferencia.requestFocus();
    return false;
}

return true; // Todos los campos son válidos

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Libros = new javax.swing.JTable();
        ingresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        isbn = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        titulo = new javax.swing.JTextField();
        autor = new javax.swing.JTextField();
        editorial = new javax.swing.JTextField();
        categoria = new javax.swing.JTextField();
        noPaginas = new javax.swing.JTextField();
        anioPublicacion = new javax.swing.JTextField();
        idioma = new javax.swing.JTextField();
        precioReferencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Lista de libros ");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 850, 10));

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Recargar.png"))); // NOI18N
        editar.setText("EDITAR");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        jPanel1.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, -1, -1));

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        eliminar.setText("ELIMINAR");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir_1.png"))); // NOI18N
        jButton3.setText("CERRAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 540, -1, -1));

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        Libros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Libro", "ISBN", "Stoc", "Título", "Autor", "Editorial", "Categoría", 
                "No. Páginas", "Año de Publicación", "Idioma", "Precio de Referencia"
            }
        )
    );
    Libros.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            LibrosMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(Libros);

    jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 950, 277));

    ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GuardarTodo.png"))); // NOI18N
    ingresar.setText("INGRESAR");
    ingresar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ingresarActionPerformed(evt);
        }
    });
    jPanel1.add(ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, -1, -1));

    jLabel3.setBackground(new java.awt.Color(102, 0, 0));
    jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Categoria");
    jLabel3.setOpaque(true);
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 590, 90, -1));

    jLabel4.setBackground(new java.awt.Color(102, 0, 0));
    jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("ISBN");
    jLabel4.setOpaque(true);
    jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 37, -1));

    jLabel5.setBackground(new java.awt.Color(102, 0, 0));
    jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setText("No paginas");
    jLabel5.setOpaque(true);
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 620, -1, -1));

    jLabel6.setBackground(new java.awt.Color(102, 0, 0));
    jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setText("Stock");
    jLabel6.setOpaque(true);
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 69, -1));

    jLabel7.setBackground(new java.awt.Color(102, 0, 0));
    jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("Idioma");
    jLabel7.setOpaque(true);
    jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 680, 60, -1));

    jLabel8.setBackground(new java.awt.Color(102, 0, 0));
    jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Año de publiación");
    jLabel8.setOpaque(true);
    jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 650, 120, -1));

    jLabel9.setBackground(new java.awt.Color(102, 0, 0));
    jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("Titulo");
    jLabel9.setOpaque(true);
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 37, -1));

    jLabel10.setBackground(new java.awt.Color(102, 0, 0));
    jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setText("Autor");
    jLabel10.setOpaque(true);
    jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 43, -1));

    jLabel11.setBackground(new java.awt.Color(102, 0, 0));
    jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(255, 255, 255));
    jLabel11.setText("Precio ref");
    jLabel11.setOpaque(true);
    jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 710, 70, -1));

    jLabel12.setBackground(new java.awt.Color(102, 0, 0));
    jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(255, 255, 255));
    jLabel12.setText("Editorial");
    jLabel12.setOpaque(true);
    jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, 57, -1));
    jPanel1.add(isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 210, -1));

    stock.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            stockActionPerformed(evt);
        }
    });
    jPanel1.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 210, -1));
    jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 650, 210, -1));
    jPanel1.add(autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 680, 210, -1));
    jPanel1.add(editorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 710, 210, -1));
    jPanel1.add(categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 590, 170, -1));
    jPanel1.add(noPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 620, 170, -1));
    jPanel1.add(anioPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 650, 170, -1));
    jPanel1.add(idioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 680, 170, -1));
    jPanel1.add(precioReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 710, 170, -1));

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/encabezado.png"))); // NOI18N
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 170));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        
        if (!validarCamposLibro()) {
            return; // Detener si las validaciones fallan
        }
         // ID del libro
        String isbn2 = isbn.getText();  // ISBN
        String stock2 = stock.getText();  // Número de serie
        String titulo2 = titulo.getText();  // Título
        String autor2 = autor.getText();  // Autor
        String editorial2 = editorial.getText();  // Editorial
        String categoria2 = categoria.getText();  // Categoría
        String noPaginas2 = noPaginas.getText();  // Número de páginas
        String anioPublicacion2 = anioPublicacion.getText();  // Año de publicación
        String idioma2 = idioma.getText();  // Idioma
        String precioReferencia2 = precioReferencia.getText();  // Precio de referencia

        try {
                String sql = "INSERT INTO libros (isbn, stock, titulo, autor, editorial, categoria, no_paginas, anio_de_publicacion, idioma, precio_referencia) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, isbn2);  // ISBN
            pstmt.setInt(2, Integer.parseInt(stock2));  // Número de serie
            pstmt.setString(3, titulo2);  // Título
            pstmt.setString(4, autor2);  // Autor
            pstmt.setString(5, editorial2);  // Editorial
            pstmt.setString(6, categoria2);  // Categoría
            pstmt.setInt(7, Integer.parseInt(noPaginas2));  // Número de páginas
            pstmt.setInt(8, Integer.parseInt(anioPublicacion2));  // Año de publicación
            pstmt.setString(9, idioma2);  // Idioma
            pstmt.setDouble(10, Double.parseDouble(precioReferencia2));  // Precio de referencia

 

        pstmt.executeUpdate();  // Ejecutar la actualización
        consultarDatos();  // Actualizar la tabla
        pstmt.close();
            } catch (SQLException ex) {
    // Manejo de excepciones
        System.err.println("Error: " + ex.getMessage());
        }

    }//GEN-LAST:event_ingresarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        if (!validarCamposLibro()) {
            return; // Detener si las validaciones fallan
        }
        // Recuperar los datos ingresados en los campos de texto
                    // Obtener los datos de los campos de texto
        String isbn2 = isbn.getText();
        String stock2 = stock.getText();
        String titulo2 = titulo.getText();
        String autor2 = autor.getText();
        String editorial2 = editorial.getText();
        String categoria2 = categoria.getText();
        String noPaginas2 = noPaginas.getText();
        String anioPublicacion2 = anioPublicacion.getText();
        String idioma2 = idioma.getText();
        String precioReferencia2 = precioReferencia.getText();

        // Validar que los campos obligatorios no estén vacíos
        if (isbn2.isEmpty() ||stock2.isEmpty()|| titulo2.isEmpty() || autor2.isEmpty() || precioReferencia2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el ID del libro seleccionado en la tabla
        int selectedRow = Libros.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un libro para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idLibro2 = Integer.parseInt(Libros.getValueAt(selectedRow, 0).toString()); // Cambia el índice de la columna si es diferente

        // Preparar la consulta SQL para editar los datos
        String sql = "UPDATE libros SET isbn = ?, stock = ?, titulo = ?, autor = ?, editorial = ?, categoria = ?, " +
                     "no_paginas = ?, anio_de_publicacion = ?, idioma = ?, precio_referencia = ? WHERE id_libro = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, isbn2);
            stmt.setString(2, stock2);
            stmt.setString(3, titulo2);
            stmt.setString(4, autor2);
            stmt.setString(5, editorial2);
            stmt.setString(6, categoria2);
            stmt.setInt(7, Integer.parseInt(noPaginas2));
            stmt.setInt(8, Integer.parseInt(anioPublicacion2));
            stmt.setString(9, idioma2);
            stmt.setDouble(10, Double.parseDouble(precioReferencia2));
            stmt.setInt(11, idLibro2); // Usamos el ID del libro seleccionado

            // Ejecutar la consulta
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Libro actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Limpiar los campos de texto
                limpiar();

                // Actualizar la tabla con los datos nuevos
                consultarDatos();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un libro con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el libro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos en los campos correspondientes.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_editarActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = source.columnAtPoint(evt.getPoint());

        if (row >= 0 && column >= 0) {
            filaSeleccionada = row; // Almacena la fila seleccionada

            // Obtener los valores de la fila seleccionada
            String idLibro = source.getValueAt(row, 0).toString();  // id_libro
            String isbn = source.getValueAt(row, 1).toString();  // isbn
            String stock = source.getValueAt(row, 2).toString();  // no_de_serie
            String titulo = source.getValueAt(row, 3).toString();  // titulo
            String autor = source.getValueAt(row, 4).toString();  // autor
            String editorial = source.getValueAt(row, 5).toString();  // editorial
            String categoria = source.getValueAt(row, 6).toString();  // categoria
            String noPaginas = source.getValueAt(row, 7).toString();  // no_paginas
            int anioPublicacion = Integer.parseInt(source.getValueAt(row, 8).toString());  // Convertir a entero
            String idioma = source.getValueAt(row, 9).toString();  // idioma
            String precioReferencia = source.getValueAt(row, 10).toString();  // precio_referencia

        }

    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockActionPerformed

    private void LibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LibrosMouseClicked
        // TODO add your handling code here:
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = source.columnAtPoint(evt.getPoint());

        if (row >= 0 && column >= 0) {
        filaSeleccionada = row; // Almacena la fila seleccionada
    
            // Obtener los valores de la fila seleccionada
            String idLibro2 = source.getValueAt(row, 0).toString();  // id_libro
            String isbn2 = source.getValueAt(row, 1).toString();  // isbn
            String stock2 = source.getValueAt(row, 2).toString();  // no_de_serie
            String titulo2 = source.getValueAt(row, 3).toString();  // titulo
            String autor2 = source.getValueAt(row, 4).toString();  // autor
            String editorial2 = source.getValueAt(row, 5).toString();  // editorial
            String categoria2 = source.getValueAt(row, 6).toString();  // categoria
            String noPaginas2 = source.getValueAt(row, 7).toString();  // no_paginas
            String anioPublicacion2 = source.getValueAt(row, 8).toString();  // anio_de_publicacion
            String idioma2 = source.getValueAt(row, 9).toString();  // idioma
            String precioReferencia2 = source.getValueAt(row, 10).toString();  // precio_referencia

            // Mostrar los valores de la fila seleccionada en los JTextField

            isbn.setText(isbn2);
            stock.setText(stock2);
            titulo.setText(titulo2);
            autor.setText(autor2);
            editorial.setText(editorial2);
            categoria.setText(categoria2);
            noPaginas.setText(noPaginas2);
            anioPublicacion.setText(anioPublicacion2);
            idioma.setText(idioma2);
            precioReferencia.setText(precioReferencia2);
        }

    }//GEN-LAST:event_LibrosMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
      
        int selectedRow = Libros.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un libro para eliminar.");
            return;
        }

        int idLibro = (int) Libros.getValueAt(selectedRow, 0); // Suponiendo que la primera columna es el id_libro

        // Mostrar un cuadro de confirmación
        int confirm = JOptionPane.showConfirmDialog(null, 
                "¿Está seguro de que desea eliminar el libro seleccionado?", 
                "Confirmar eliminación", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            // Si el usuario selecciona "Sí", proceder con la eliminación
            try {
                String sql = "DELETE FROM libros WHERE id_libro = ?";  // Asegúrate de que el nombre de la tabla sea 'libros'
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idLibro);  // Pasa el id del libro para eliminar
                pstmt.executeUpdate();
                consultarDatos();  // Refrescar la tabla con los datos actualizados
                pstmt.close();
                JOptionPane.showMessageDialog(null, "Libro eliminado con éxito.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el libro: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            // Si el usuario selecciona "No", no se hace nada
            JOptionPane.showMessageDialog(null, "Eliminación cancelada.");
        }


    }//GEN-LAST:event_eliminarActionPerformed
    private void consultarDatos() {
        try {
            // Actualiza la consulta SQL con los nuevos campos
            String sql = "SELECT id_libro, isbn, stock, titulo, autor, editorial, categoria, no_paginas, anio_de_publicacion, idioma, precio_referencia FROM libros";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // Obtén el modelo de la tabla para actualizar los datos
            DefaultTableModel model = (DefaultTableModel) Libros.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

            // Recorre los resultados y agrega las filas a la tabla
            while (rs.next()) {
                // Extrae los valores de cada columna
                int idLibro = rs.getInt("id_libro");
                String isbn = rs.getString("isbn");
                int stock = rs.getInt("stock");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String editorial = rs.getString("editorial");
                String categoria = rs.getString("categoria");
                int noPaginas = rs.getInt("no_paginas");
                int anioDePublicacion = rs.getInt("anio_de_publicacion");
                String idioma = rs.getString("idioma");
                double precioReferencia = rs.getDouble("precio_referencia");

                // Agrega la fila con los datos a la tabla
                model.addRow(new Object[]{idLibro, isbn, stock, titulo, autor, editorial, categoria, noPaginas, anioDePublicacion, idioma, precioReferencia});
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            // Manejo de excepciones, por ejemplo, mostrar un mensaje de error
            System.err.println("Error: " + ex.getMessage());
        }
    }

    private void limpiar() {
        isbn.setText("");
        stock.setText("");
        titulo.setText("");
        autor.setText("");
        editorial.setText("");
        categoria.setText("");
        noPaginas.setText("");
        anioPublicacion.setText("");
        idioma.setText("");
        precioReferencia.setText("");
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
            java.util.logging.Logger.getLogger(LibroInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibroInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibroInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibroInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibroInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Libros;
    private javax.swing.JTextField anioPublicacion;
    private javax.swing.JTextField autor;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField categoria;
    private javax.swing.JButton editar;
    private javax.swing.JTextField editorial;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField idioma;
    private javax.swing.JButton ingresar;
    private javax.swing.JTextField isbn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField noPaginas;
    private javax.swing.JTextField precioReferencia;
    private javax.swing.JTextField stock;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
