/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asesoftware.mechanics.bean;
import co.com.asesoftware.mechanics.dto.MechanicDto;
import co.com.asesoftware.mechanics.facade.IWSAppInterface;
import co.com.asesoftware.mechanics.impl.WSAppImplementacion;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author User
 */
@Stateless
public class WSMechanicsStateless implements IWSAppInterface {
    
    @Override
    public boolean registerMechanic(MechanicDto mechanic)
    {
        return WSAppImplementacion.registerMechanics(mechanic);
    }
    
    @Override
    public List<MechanicDto> getAvailableMechanics(String fechaProceso, int tamanoLista)
    {
        return WSAppImplementacion.getAvailableMechanics(fechaProceso, tamanoLista);
    }
    
}