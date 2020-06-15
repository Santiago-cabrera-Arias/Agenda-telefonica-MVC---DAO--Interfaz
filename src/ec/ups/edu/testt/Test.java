
package ec.ups.edu.testt;

import ec.ups.edu.controlador.ControladorTelefono;
import ec.ups.edu.dao.TelefonoDao;
import ec.ups.edu.vista.VentanaIngreso;


/**
 *
 * @author santi
 */
public class Test {
    
    public static void main(String[] args) {
    
    VentanaIngreso ventana1 = new VentanaIngreso();
    TelefonoDao teleDao = new TelefonoDao();
    ControladorTelefono controlador = new ControladorTelefono(teleDao, ventana1);
    controlador.iniciar();
    
    }
}
