/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asesoftware.mechanics.service;

import co.com.asesoftware.mechanics.bean.WSMechanicsStateless;
import co.com.asesoftware.mechanics.dto.MechanicDto;
import co.com.asesoftware.mechanics.facade.IWSAppInterface;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author User
 */
@WebService(serviceName = "Mechanics")
public class Mechanics {

    
    /**
     * Web service operation
     * @param mechanic
     * @return 
     */
    @WebMethod(operationName = "registerMechanics")
    public String registerMechanics(@WebParam(name = "mechanic") MechanicDto mechanic) {
        //TODO write your implementation code here:
        String stateExecute;
        IWSAppInterface ser = new WSMechanicsStateless();
        stateExecute = ser.registerMechanic(mechanic)?"OK":"ERROR";
        return stateExecute;
    }

    /**
     * Web service operation
     * @param fechaProceso
     * @param tamanoListado
     * @return 
     */
    @WebMethod(operationName = "getAvailableMechanics")
    public List<MechanicDto> getAvailableMechanics(@WebParam(name = "fechaProceso") String fechaProceso, @WebParam(name = "tamanoListado") int tamanoListado) {
        //TODO write your implementation code here:
        IWSAppInterface ser = new WSMechanicsStateless();
        return ser.getAvailableMechanics(fechaProceso, tamanoListado);
    }
    
    
    
    
}
