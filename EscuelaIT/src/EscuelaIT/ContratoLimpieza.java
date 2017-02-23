/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscuelaIT;

/**
 *
 * @author RafaMar
 */
public class ContratoLimpieza {
    
    private String empresa;
    
    private int año;
    
    private Intervalo[] jornadas;
    
    public ContratoLimpieza(String empresa, int año){
        this.empresa=empresa;
        this.año=año;
        jornadas = new Intervalo[Fecha.diasAño(año)];
        for (int i = 0; i < Fecha.diasAño(año); i++) {
            jornadas[i] = new Intervalo(8,12);
        }
    }
    
    private Intervalo getJornada(Fecha fecha){
        return jornadas[fecha.diaDelAño()-1];
    }
    
    private void setJornada(Fecha fecha, Intervalo intervalo){
        jornadas[fecha.diaDelAño()-1] = intervalo;
    }
    
    public void anular(Fecha fecha){
        this.setJornada(fecha, null);
    }
    
    public void doblar(Fecha fecha){
        this.getJornada(fecha).doblar();
    }
    
    public void desplazar(Fecha fecha,int cantHoras){
        this.getJornada(fecha).desplazar(cantHoras);
    }
    
    public void mostrar() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("EMPRESA: "+empresa);
        Fecha fecha = new Fecha(1,1,año);
        for (int i = 0; i < Fecha.diasAño(año); i++) {
            if(this.getJornada(fecha)!=null){
                fecha.mostrarFecha();
                this.getJornada(fecha).mostrar();;
            }
            fecha.incrementar(i);
        }
    }
    
    public double coste(){
        return 0.0;
    }
}
