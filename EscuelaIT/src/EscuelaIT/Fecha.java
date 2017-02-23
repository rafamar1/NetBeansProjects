package EscuelaIT;

import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RafaMar
 */
class Fecha {

    private int dia;

    private int mes;

    private int año;

    private static final int[] diasMeses = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final char[] diasSemana = new char[]{'S', 'D', 'L', 'M', 'X', 'J', 'V'};

    public Fecha() {
        this(1, 1, 1);
    }

    public Fecha(int dia, int mes, int año) {
        this.set(dia, mes, año);
    }

    public Fecha(Fecha fecha) {
        this(fecha.dia, fecha.mes, fecha.año);
    }

    public Fecha(String fecha) {
        StringTokenizer analizador = new StringTokenizer(fecha, "/");
        setDia(Integer.parseInt(analizador.nextToken()));
        setMes(Integer.parseInt(analizador.nextToken()));
        setAño(Integer.parseInt(analizador.nextToken()));
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    /*------------------------------------------------------------*/
    public char diaSemana() {
        return diasSemana[(this.diasOrigen() - 1) % 7];
    }

    public boolean anterior(Fecha fecha) {
        return this.diasOrigen() < fecha.diasOrigen();
    }

    public boolean posterior(Fecha fecha) {
        return this.diasOrigen() > fecha.diasOrigen();
    }

    public boolean igual(Fecha fecha) {
        return fecha.getDia() == this.getDia()
                && fecha.getMes() == this.getMes()
                && fecha.getAño() == this.getAño();
    }

    public int diferencia(Fecha fecha) {
        return this.diasOrigen() - fecha.diasOrigen();
    }

    private int diasOrigen() {
        int resultado = this.diaDelAño();
        resultado += 365 * (this.getAño() - 1);
        for (int i = 1; i < año - 1; i++) {
            if (Fecha.bisiesto(i)) {
                resultado++;
            }
        }
        return resultado;
    }

    public boolean festivo() {
        char diaSemana = this.diaSemana();
        return diaSemana == 'S' || diaSemana == 'D';
    }

    public void mostrarFecha() {
        new GestorIO().out(this.getDia() + "/" + this.getMes() + "/" + this.getAño());
    }

    public String toStringUSA() {
        return this.getMes() + "/" + this.getDia() + "th, " + this.getAño();
    }

    public void set(int dia, int mes, int año) {
        this.setDia(dia);
        this.setMes(mes);
        this.setAño(año);
    }

    public void set(Fecha fecha) {
        this.set(fecha.getDia(), fecha.getMes(), fecha.getAño());
    }

    private String estacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int numeroSemana() {
        return (this.diasOrigen() - new Fecha(1, 1, año).diasOrigen() / 7 + 1);
    }

    private void incrementar() {
        dia++;
        if (dia > diasMeses[mes - 1]) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                año++;
            }
        }
    }

    public void incrementar(int dias) {
        for (int i = 0; i < dias; i++) {
            this.incrementar();
        }
    }

    private boolean checkBisiesto() {
        return Fecha.bisiesto(this.getAño());
    }

    public static boolean bisiesto(int año) {
        return año % 4 == 0 && año % 100 != 0 || año % 400 == 0;
    }

    public static int diasAño(int año) {
        int dias = 365;
        if (Fecha.bisiesto(año)) {
            return dias++;
        }
        return dias;
    }
    
    public int diaDelAño() {
        int resultado = this.getDia();
        for (int i = 0; i < (this.getMes() - 1); i++) {
            resultado += diasMeses[i];
        }
        if (this.checkBisiesto() && mes > 2) {
            resultado++;
            }
        return resultado;
       
    }

    public static void main(String[] args) {
        Fecha fecha = new Fecha(5, 7, 2000);
        fecha.mostrarFecha();
        Fecha.bisiesto(1985);
    }
}
