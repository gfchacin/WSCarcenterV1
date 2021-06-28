package co.com.asesoftware.mechanics.facade;

import co.com.asesoftware.mechanics.dto.MechanicDto;
import java.util.List;



public interface IWSAppInterface {
       
    //public List<MechanicDto> getAvailableMechanics();
    public boolean registerMechanic(MechanicDto mechanic);

    /**
     *
     * @param fechaProceso
     * @param tamanoListado
     * @return
     */
    public List<MechanicDto> getAvailableMechanics(String fechaProceso, int tamanoListado);
	
}
