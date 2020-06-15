
package ec.ups.edu.dao;

import ec.ups.edu.idao.ITelefonoDao;
import ec.ups.edu.modelo.Telefono;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author santi
 */
public class TelefonoDao implements ITelefonoDao{

    private List<Telefono> listaTelefono;

    public TelefonoDao() {
    
    listaTelefono = new ArrayList<>();
        
    }
    
    @Override
    public void create(Telefono telefono) {
        
        listaTelefono.add(telefono);
        
    }

    @Override
    public Telefono read(int codigo) {
        for (Telefono telefono1 : listaTelefono) {
            
            if (telefono1.getCodigo() == codigo) {
                
                return telefono1;
                
            }
            
        }
        
        return null;
        
    }

    @Override
    public void update(Telefono telefono) {
     for (int i = 0; i < listaTelefono.size(); i++) {
            Telefono t = listaTelefono.get(i);
            if(t.getCodigo()== telefono.getCodigo()){
                listaTelefono.set(i, telefono);
            }
        }
    
    }

    @Override
    public void delete(Telefono telefono) {
         Iterator<Telefono> it = listaTelefono.iterator();
        while (it.hasNext()) {
            Telefono t = it.next();
            if (t.getCodigo() == telefono.getCodigo()){
                it.remove();
                break;
            }
        }
        
        
    }

    @Override
    public List<Telefono> listaTelefono() {
        return listaTelefono;
    }
    
    
    
    
}
