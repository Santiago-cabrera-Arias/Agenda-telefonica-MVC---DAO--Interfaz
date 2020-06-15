package ec.ups.edu.controlador;

import ec.ups.edu.idao.ITelefonoDao;
import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.vista.VentanaIngreso;
import ec.ups.edu.vista.VentanaInicioSesion;
import ec.ups.edu.vista.VentanaListar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class ControladorTelefono implements ActionListener{

    ITelefonoDao telefonoDao;
    VentanaIngreso ventanaIngr;
    VentanaListar ventanaList = new VentanaListar();
    Telefono telefono;

    public ControladorTelefono(ITelefonoDao telefonoDao, VentanaIngreso ventanaIngr) {
        this.telefonoDao = telefonoDao;
        this.ventanaIngr = ventanaIngr;
        this.ventanaIngr.btnCrear.addActionListener(this);
        this.ventanaIngr.btnListar.addActionListener(this);

    }

    public void crearTelefono() {

        telefono = ventanaIngr.crearTelefono();
        System.out.println(telefono);
        if (telefono == null) {

            JOptionPane.showMessageDialog(null, "Error ");

        } else {
            JOptionPane.showMessageDialog(null, "Telefono registrado correctamente");
            telefonoDao.create(telefono);

        }
    }

    public void listarTelefonos() {
        List<Telefono> telefonos;
        telefonos = telefonoDao.listaTelefono();
        if (!telefonos.isEmpty()) {
            ventanaList.txtArea.setText(telefonos.toString());
        } else {
            ventanaList.txtArea.setText("Agenda Vacia");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ventanaIngr.btnCrear)) {
            crearTelefono();
        }
        if (e.getSource().equals(ventanaIngr.btnListar)) {
            listarTelefonos();
            ventanaList.setVisible(true);
            ventanaList.setLocationRelativeTo(null);
        }
    }

    public void iniciar() {
        VentanaInicioSesion ventanaInicio = new VentanaInicioSesion();
        ventanaInicio.setLocationRelativeTo(null);
        ventanaInicio.setVisible(true);
        
    }

}
