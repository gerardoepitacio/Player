
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Control;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    //int i = 0;
    Clip clipx;
    int posActual;
    boolean aleatorio;
    Timer t1;
    ArrayList<String> rutas = new ArrayList<String>();
    private AudioInputStream flujolectura;
    ArrayList<Clip> clips = new ArrayList<Clip>();
    ArrayList<Long> bufferPausa = new ArrayList<Long>();
    ArrayList<Integer> historialrepro = new ArrayList<Integer>();
    AudioFileFormat.Type formatosSoportados[];

    Timer timerMuestra20;
    Mixer.Info mezclador;
    Listener esc;

    int max = 0;
    int nr = -1;

    public Principal() {
        initComponents();
        //mezclador = AudioSystem.get
        formatosSoportados = AudioSystem.getAudioFileTypes();
        t1 = new Timer(300, tiempo);
        timerMuestra20 = new Timer(20000, listenerTimerMuestra);
        jProgressBar1.setMaximum(100);
        esc = new Listener(this);
        reproducirMuestra.setSelected(false);
        //jProgressBar1.setBackground(new Color(0x003366));
        //jProgressBar1.setOpaque(false);
        cargaROLAS();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        botonPlay = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonBack = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        botonStop = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuReproducir = new javax.swing.JMenu();
        reproducirMuestra = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jProgressBar1.setBackground(new java.awt.Color(204, 255, 204));
        jProgressBar1.setBorderPainted(false);
        jProgressBar1.setOpaque(true);
        jProgressBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProgressBar1MouseClicked(evt);
            }
        });

        botonPlay.setText("Play");
        botonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPlayActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        botonBack.setText("Back");
        botonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBackActionPerformed(evt);
            }
        });

        botonSiguiente.setText("Forward");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonStop.setText("Stop");
        botonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonStopActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jCheckBox1.setText("Aleatorio");
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Agregar archivos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Agregar directorio");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        menuReproducir.setText("Reproducir");

        reproducirMuestra.setSelected(true);
        reproducirMuestra.setText("Muestra");
        reproducirMuestra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                reproducirMuestraStateChanged(evt);
            }
        });
        reproducirMuestra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reproducirMuestraActionPerformed(evt);
            }
        });
        menuReproducir.add(reproducirMuestra);

        jMenuBar1.add(menuReproducir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonStop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonPlay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonSiguiente)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonPlay)
                            .addComponent(botonSiguiente)
                            .addComponent(botonBack)
                            .addComponent(botonStop))
                        .addGap(28, 28, 28)
                        .addComponent(jCheckBox1)
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void botonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPlayActionPerformed
//START
        if (jTable1.getRowCount() != 0) {//hay canciones en la tabla (lista)

            if (botonPlay.getText().equals("Pausa")) {//hay reproduccion en curso (pausamos)
                t1.stop();
                for (int i = 0; i < clips.size(); i++) {
                    clips.get(i).stop();
                    bufferPausa.add(clips.get(i).getMicrosecondPosition());
                }
                botonPlay.setText("Resume");
            } else {
                if (bufferPausa.size() != 0 && botonPlay.getText().equals("Resume")) {//no hay reproduccion y buscamos pausas
                    startPausa();  
                } else {
                    //GESTION PAUSAS....

                    if (jTable1.getSelectedRows().length == 0) {
                        try {
                            // no hay seleccion
                            reproduce();
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            //hay seleccion
                            detenRep();
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (jTable1.getSelectedRows().length > 1) {//muchas
                            reproduceMuchos();//no necesario listener
                        } else {//una
                            reproduceUna();
                        }

                        t1.start();

                    }
                    botonPlay.setText("Pausa");
                }

            }
        } else {
            System.out.println("No tienes lista de reproduccion cargada!");
            jLabel1.setForeground(Color.red);
            jLabel1.setText("No tienes una lista de reproduccion cargada");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            jLabel1.setForeground(Color.black);
            jLabel1.setText("Sin reproduccion...");

        }


    }//GEN-LAST:event_botonPlayActionPerformed


    private void jProgressBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar1MouseClicked
        // TODO add your handling code here:
        if (!botonPlay.getText().equals("Play")) {//mover solo cuando haya reproduccion en curso.

            if (clips.size() > 1) {
                //multiples clips reproduciendose;
                ///int promedio;
                //int tiempoMax

            } else {

                //only a clip
                if (botonPlay.getText().equals("Pausa")) {
                    int porcentajeBarra = getPorcentajeBarra(evt.getX());
                    setPorcentajeCancion(porcentajeBarra, true);
                    setPorcentajeBarra(porcentajeBarra);

                } else {

                    int porcentajeBarra = getPorcentajeBarra(evt.getX());
                    setPorcentajeCancion(porcentajeBarra, false);
                    setPorcentajeBarra(porcentajeBarra);
                }

            }
        }


    }//GEN-LAST:event_jProgressBar1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        if (jTable1.getSelectedRow() != nr) {
            botonPlay.setText("Play");

        } else {
            botonPlay.setText("Pausa");
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // SELECTOR POR ARCHIVOS SELECCIONADOS
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];
        JFileChooser selector = new JFileChooser();
        selector.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("archivos wav", "wav", "aiff", "ogg");
        selector.setFileFilter(filtroImagen);
        int r = selector.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            try {
                File archivos[] = selector.getSelectedFiles();
                int i = 0;
                for (File f : archivos) {
                    rutas.add(f.getAbsolutePath());
                    System.out.println("ruta:" + f.getAbsolutePath());
                    fila[0] = (i + 1) + "  " + f.getName();

                    i++;
                    modelo.addRow(fila);
                }
                i = 0;
            } catch (Exception e) {
            }

        }


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void botonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBackActionPerformed
//boton back
        if (!historialrepro.isEmpty()) {
            try {
                detenRep();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            posActual = posActual - 1;
            if (posActual == 0) {
                posActual = 1;
            }

            nr = historialrepro.get(posActual - 1);
            try {
                flujolectura = AudioSystem.getAudioInputStream(new File(rutas.get(nr)));
                Clip clipSeleccionado = AudioSystem.getClip();
                clipSeleccionado.open(flujolectura);
                clipSeleccionado.addLineListener(esc);
                clipSeleccionado.start();
                clips.add(clipSeleccionado);

                jTable1.setRowSelectionInterval(nr, nr);
                t1.start();
            } catch (UnsupportedAudioFileException e) {
                setTitle("Modo de audio no soportado");
            } catch (IOException e) {
                setTitle("No se pudo abrir o leer el archivo...");
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            botonPlay.setText("Pausa");

            //historialrepro.add(nr);
            //posActual = historialrepro.size();
        }


    }//GEN-LAST:event_botonBackActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // SELECCION DE UN DIRECTORIO PARA CREA LA LISTA
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];

        JFileChooser s = new JFileChooser();
        s.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        s.showOpenDialog(null);

        //File f = new File("."); // current directory
        File f = s.getSelectedFile();

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".wav") || lowercaseName.endsWith(".aiff")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        File[] files = f.listFiles(textFilter);
        int i = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("directory:");
            } else {
                System.out.print("file:");
            }

            rutas.add(file.getAbsolutePath());
            fila[0] = (i + 1) + "  " + file.getName();
            i++;
            modelo.addRow(fila);
        }


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void detenRep() throws IOException {
        if (clips.size() != 0) {
            t1.stop();

            if (timerMuestra20.isRunning()) {
                timerMuestra20.restart();
                timerMuestra20.stop();
            }

            for (int i = 0; i < clips.size(); i++) {
                clips.get(i).removeLineListener(esc);
                clips.get(i).stop();
                clips.get(i).flush();
                clips.get(i).close();
            }
            
            bufferPausa.clear();
            
            
            clips.clear();
            //flujolectura.close();
            //t1.restart();
            botonPlay.setText("Play");
            jProgressBar1.setValue(0);
            jProgressBar1.setString("00:00:00");

        }

    }

    private void botonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonStopActionPerformed
        try {
            // STOP
            detenRep();

        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTable1.clearSelection();

    }//GEN-LAST:event_botonStopActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed


    }//GEN-LAST:event_jCheckBox1ActionPerformed

    public void ff() throws IOException {
        //detenRep();

        if (aleatorio) {
            reproduce();
        } else {

            if (posActual == historialrepro.size()) {//si no ha habido backs
                nr++;
                if (nr >= rutas.size()) {
                    nr = 0;
                }
                detenRep();
                //codigo para decirir quie aleatorio o no aleatorio  
                System.out.println("pista:" + nr);
                try {
                    flujolectura = AudioSystem.getAudioInputStream(new File(rutas.get(nr)));
                    Clip clipSeleccionado = AudioSystem.getClip();
                    clipSeleccionado.open(flujolectura);
                    clipSeleccionado.addLineListener(esc);
                    clipSeleccionado.start();
                    clips.add(clipSeleccionado);

                    jTable1.setRowSelectionInterval(nr, nr);

                    t1.start();
                } catch (UnsupportedAudioFileException e) {
                    setTitle("Modo de audio no soportado");
                } catch (IOException e) {
                    setTitle("No se pudo abrir o leer el archivo...");
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                botonPlay.setText("Pausa");
                historialrepro.add(nr);
                posActual = historialrepro.size();

            } else {

                detenRep();
                posActual = posActual + 1;
                nr = historialrepro.get(posActual - 1);
                try {
                    flujolectura = AudioSystem.getAudioInputStream(new File(rutas.get(nr)));
                    Clip clipSeleccionado = AudioSystem.getClip();
                    clipSeleccionado.open(flujolectura);
                    clipSeleccionado.addLineListener(esc);
                    clipSeleccionado.start();
                    clips.add(clipSeleccionado);
                    jTable1.setRowSelectionInterval(nr, nr);
                    t1.start();
                } catch (UnsupportedAudioFileException e) {
                    setTitle("Modo de audio no soportado");
                } catch (IOException e) {
                    setTitle("No se pudo abrir o leer el archivo...");
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                botonPlay.setText("Pausa");

            }
        }
    }

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed

        try {
            ff();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        // TODO add your handling code here:
        aleatorio = jCheckBox1.isSelected();
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void reproducirMuestraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reproducirMuestraActionPerformed
        // TODO add your handling code here:
        if (reproducirMuestra.isSelected()) {
            try {
                ff();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            timerMuestra20.stop();
            timerMuestra20.restart();

        }

    }//GEN-LAST:event_reproducirMuestraActionPerformed

    private void reproducirMuestraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_reproducirMuestraStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_reproducirMuestraStateChanged

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBack;
    private javax.swing.JButton botonPlay;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JButton botonStop;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenu menuReproducir;
    private javax.swing.JCheckBoxMenuItem reproducirMuestra;
    // End of variables declaration//GEN-END:variables

    ActionListener tiempo = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (!clips.isEmpty()) {
                if (clips.size() > 1) {//reproduccion simultanea.
                    //multiples clips reproduciendose;
                    ///int promedio;
                    //int tiempoMax
                    int suma = 0;
                    long promTiempo = 0;
                    for (int i = 0; i < clips.size(); i++) {
                        suma = suma + getPorcentajeCancion(clips.get(i).getMicrosecondPosition(), clips.get(i).getMicrosecondLength());
                        promTiempo = clips.get(i).getMicrosecondPosition();
                    }
                    promTiempo = promTiempo / clips.size();
                    int prom = suma / clips.size();
                    setPorcentajeBarra(prom);
                    jProgressBar1.setString(promTiempo + "");
                    jProgressBar1.setStringPainted(true);
                } else {
                    //only a clip
                    long porcentajeRepActual = getPorcentajeCancion(clips.get(0).getMicrosecondPosition(), clips.get(0).getMicrosecondLength());
                    setPorcentajeBarra((int) porcentajeRepActual);
                    jProgressBar1.setString("" + clips.get(0).getMicrosecondPosition());
                    jProgressBar1.setStringPainted(true);
                }
                //reproduccion autimatica
            }
        }
    };

    ActionListener listenerTimerMuestra = new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            try {
                ff();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    };

    private int getPorcentajeCancion(long posicionActual, long tiempoTotal) {
        long porcentaje = (posicionActual * 100) / tiempoTotal;
        return (int) porcentaje;
    }

    private void setPorcentajeCancion(int porciento, boolean reproduce) {
        long tiempoTotal = clips.get(0).getMicrosecondLength();
        long resultadoTiempo = (porciento * tiempoTotal) / 100;
        //clips.get(0).stop();
        clips.get(0).setMicrosecondPosition(resultadoTiempo);

        if (reproduce) {//play
            clips.get(0).start();
        } else {//pausa(no reproduce.
            bufferPausa.set(0, resultadoTiempo);
        }

    }

    /**
     * Marcamos a la barra en funcion de algun porcentaje recibido
     *
     * @param porcentajeCancion el porcentaje de avance de la cancion que debe
     * corresponder al de la barra.
     */
    private void setPorcentajeBarra(int porcentajeCancion) {

        //int longBarra = jProgressBar1.getWidth();
        //int actual = (porcentajeCancion * longBarra) / 100;
        //jProgressBar1.setValue(actual);
        jProgressBar1.setValue(porcentajeCancion);
    }

    /**
     * Obtenemos el porcentaje de la barra en funcion del valor recibido. que
     * valor de la barra en porcentaje corresponde al valor recibido
     *
     * @param valor coordenada x del evento de clic
     * @return el porcentaje 0-100;
     */
    private int getPorcentajeBarra(int valor) {
        int longBarra = jProgressBar1.getWidth();
        int porcentaje = (valor * 100) / longBarra;
        return porcentaje;
    }

    private void reproduceMuchos() {
        jLabel1.setText("Reproduccion Simultanea...");

        long aux = 0;
        try {
            int indices[] = jTable1.getSelectedRows();

            for (int i = 0; i < indices.length; i++) {
                flujolectura = AudioSystem.getAudioInputStream(new File(rutas.get(indices[i])));
                Clip clipSeleccionado = AudioSystem.getClip();
                clipSeleccionado.open(flujolectura);
                //clipSeleccionado.start();
                if (aux < clipSeleccionado.getMicrosecondLength()) {
                    aux = clipSeleccionado.getMicrosecondLength();
                    max = i;
                }
                clips.add(clipSeleccionado);
                //t1.start();
            }

            for (int i = 0; i < clips.size(); i++) {
                clips.get(i).start();
            }

        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void reproduceUna() {
        System.out.println("Reproduzco solo una rolita");
        System.out.println("num." + jTable1.getSelectedRow());
        System.out.println("size rutas" + rutas.size());

        try {
            flujolectura = AudioSystem.getAudioInputStream(new File(rutas.get(jTable1.getSelectedRow())));
            nr = jTable1.getSelectedRow();
            Clip clipSeleccionado = AudioSystem.getClip();
            clipSeleccionado.open(flujolectura);
            clipSeleccionado.addLineListener(esc);
            //clips.get(jTable1.getSelectedRow()).addLineListener(esc);
            clipSeleccionado.start();
            clips.add(clipSeleccionado);

        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        historialrepro.add(nr);
        posActual = historialrepro.size();

    }

    private void reproduce() throws IOException {
        nr = 0;
        if (aleatorio) {
            Random r = new Random();
            nr = r.nextInt(rutas.size() - 1) + 0;
            System.out.println("pista:" + nr);
        }

        System.out.println("no tienes nada selecionado, reproduzco por default or random....");
        detenRep();
        //codigo para decidir que aleatorio o no aleatorio  
        System.out.println("pista:" + nr);
        try {
            flujolectura = AudioSystem.getAudioInputStream(new File(rutas.get(nr)));
            Clip clipSeleccionado = AudioSystem.getClip();
            clipSeleccionado.open(flujolectura);
            clipSeleccionado.addLineListener(esc);
            clipSeleccionado.start();
            clips.add(clipSeleccionado);
            jTable1.setRowSelectionInterval(nr, nr);
            t1.start();
        } catch (UnsupportedAudioFileException e) {
            setTitle("Modo de audio no soportado");
        } catch (IOException e) {
            setTitle("No se pudo abrir o leer el archivo...");
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        botonPlay.setText("Pausa");
        historialrepro.add(nr);
        posActual = historialrepro.size();

    }

    public String getPlayState() {
        return botonPlay.getText();
    }

    private void cargaROLAS() {

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];

        File f = new File("C:/Users/Jorge/Documents/ROLAS");

        FilenameFilter textFilter = new FilenameFilter() {

            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".wav") || lowercaseName.endsWith(".aiff") || lowercaseName.endsWith(".au")) {
                    return true;
                } else {
                    return false;
                }

            }
        };

        File[] files = f.listFiles(textFilter);
        int i = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("directory:");
            } else {
                System.out.print("file:");
            }

            rutas.add(file.getAbsolutePath());
            fila[0] = (i + 1) + "  " + file.getName();
            i++;
            modelo.addRow(fila);
        }

    }

    void setStateBar(String estado) {

        jLabel1.setText(estado);

    }

    String getActualPlay() {
        if (clips.size() > 1) {//reproduccion simultanea.
            //multiples clips reproduciendose;
            ///int promedio;
            //int tiempoMax
            System.out.println("repro Simultanea");
            return "Reproduccion Simultanea!";
        } else {

            //only a clip
            jProgressBar1.setString("" + clips.get(0).getMicrosecondPosition());
            /*Line.Info inf = clips.get(0).getLineInfo();
            Control []ctrl = clips.get(0).getControls();
            Control.Type tipo = ctrl[0].getType();
              */          
            
            jProgressBar1.setStringPainted(true);

            File archivo = new File(rutas.get(nr));
            return ("Actual: " + archivo.getName());

        }
    }

    private void startPausa() {
        t1.start();
        for (int i = 0; i < clips.size(); i++) {
            clips.get(i).setMicrosecondPosition(bufferPausa.get(i));
            clips.get(i).start();
        }
        bufferPausa.clear();
        botonPlay.setText("Pausa");
    }

}
