package serializacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Date;

/**
 *
 * @author RafaMar
 */
public class Contacto implements Serializable{
    
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private Date nacimiento;
    private int grupo;
    private double deuda;
    
}
