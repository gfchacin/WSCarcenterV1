/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asesoftware.mechanics.impl;

import co.com.asesoftware.mechanics.database.ConsultaBD;
import co.com.asesoftware.mechanics.dto.MechanicDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author User
 */
public class WSAppImplementacion {

	public static boolean registerMechanics(MechanicDto mechanic) {
            return ConsultaBD.registerMechanics(mechanic);
        }
        
        public static List<MechanicDto> getAvailableMechanics(String fechaProceso, int tamanoLista) {
            List<MechanicDto> availableMechanicsList = new ArrayList<MechanicDto>();
            ResultSet rs = ConsultaBD.getAvailableMechanics(fechaProceso, tamanoLista);
            try {
                while(rs.next())
                {
                    MechanicDto mechanicDto = new MechanicDto();
                    mechanicDto.setDocumentType(rs.getString(1));
                    mechanicDto.setDocument(String.valueOf(rs.getInt(2)));
                    mechanicDto.setFirstName(rs.getString(3));
                    mechanicDto.setSecondName(rs.getString(4));
                    mechanicDto.setFirstLastName(rs.getString(5));
                    mechanicDto.setSecondLastName(rs.getString(6));
                    mechanicDto.setPhone(rs.getString(7));
                    mechanicDto.setAddress(rs.getString(8));
                    mechanicDto.setEmail(rs.getString(9));
                    mechanicDto.setState(rs.getString(10));
                    mechanicDto.setHorasTrabajadas(rs.getInt(11));
                    availableMechanicsList.add(mechanicDto);
                    
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
            return availableMechanicsList;
            
        }
	
}

