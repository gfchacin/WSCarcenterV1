/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asesoftware.mechanics.database;

import co.com.asesoftware.mechanics.dto.MechanicDto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author User
 */
public class ConsultaBD {
    
    public static boolean registerMechanics(MechanicDto mechanic)
    {
        Connection con;
        CallableStatement stmt;
        boolean status;
        try {
            con = DbConnection.getConnection();
            stmt = con.prepareCall("CALL public.prc_reg_mecanicos(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, mechanic.getDocumentType());
            stmt.setInt(2, Integer.valueOf(mechanic.getDocument()));
            stmt.setString(3, mechanic.getFirstName());
            stmt.setString(4, mechanic.getSecondName());
            stmt.setString(5, mechanic.getFirstLastName());
            stmt.setString(6, mechanic.getSecondLastName());
            stmt.setString(7, mechanic.getPhone());
            stmt.setString(8, mechanic.getAddress());
            stmt.setString(9, mechanic.getEmail());
            stmt.setString(10, mechanic.getState());
            stmt.execute();
            status = true;
            stmt.close();
            con.close();
            return status;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
     public static ResultSet getAvailableMechanics(String Fecha, int tamanoLista)
    {
        Connection con;
        Statement stmt;
        ResultSet rs;
        con = DbConnection.getConnection();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT MC.\"TIPO_DOC\", MC.\"DOCUMENTO\", MC.\"PRIMER_NOMBRE\", MC.\"SEGUNDO_NOMBRE\", MC.\"PRIMER_APELLIDO\", MC.\"SEGUNDO_APELLIDO\", MC.\"CELULAR\", MC.\"DIRECCION\", MC.\"EMAIL\", MC.\"ESTADO\", CASE WHEN SUM(SM.\"TIEMPO_ESTIMADO\") IS NOT NULL THEN SUM(SM.\"TIEMPO_ESTIMADO\") ELSE 0 END FROM public.\"MECANICOS\" MC\n" +
            "LEFT JOIN public.\"MANTENIMIENTOS\" MN ON MC.\"TIPO_DOC\" = MN.\"MEC_TPO_DOC\" AND MC.\"DOCUMENTO\" = MN.\"MEC_DOC\"\n" +
            "LEFT JOIN public.\"SERVICIOS_X_MANTENIMIENTOS\" SM ON MN.\"CODIGO\" = SM.\"CODIGO_MANTENIMIENTO\"\n" +
            "WHERE MC.\"ESTADO\" = 'L' \n" +
            "GROUP BY  MC.\"TIPO_DOC\", MC.\"DOCUMENTO\" ORDER BY 11");
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    	
    
}
