package EscuelaIT;

class Intervalo {

    private double puntoMedio;
    private double longitud;

    public Intervalo(double inferior, double superior) {
        assert inferior <=superior;
        setInferior(inferior);
        setInferior(superior);
    }
    
    public Intervalo(Intervalo intervalo) {
        this(intervalo.getInferior(), intervalo.getSuperior()) ;
    }

    public Intervalo(double superior) {
       this(0,superior);
    }
    
    public Intervalo(){
        this(0,0);
    }    
    
    public double getInferior() {
        return puntoMedio - this.longitud/2;
    }

    public void setInferior(double inferior) {
        longitud = this.getSuperior() - inferior;
        puntoMedio = inferior + longitud/2;
    }

    public double getSuperior() {
        return puntoMedio + this.longitud/2;
    }

    public void setSuperior(double superior) {
        longitud = superior - this.getInferior();
        puntoMedio = superior - longitud/2;
    }

    public Intervalo desplazado(double superior) {
        Intervalo intervalo=this.clone();
        intervalo.desplazar(superior);
        return intervalo;
    }
    


    @Override
    public Intervalo clone() {
        return new Intervalo(this);
    }
    
    public double longitud() {
        return getSuperior() - getInferior();
    }

    public void desplazar(double desplazamiento) {
        setInferior(getInferior() + desplazamiento);
        setSuperior(getSuperior() + desplazamiento);
    }

    public boolean incluye(Intervalo intervalo) {
        assert intervalo!=null;
        return this.incluye(intervalo.getInferior()) &&
               this.incluye(intervalo.getSuperior());
    }

    public boolean incluye(double valor) {
        return getInferior() <= valor && getSuperior() >= valor;
    }

    public boolean equals(Intervalo intervalo) {
        assert intervalo!=null;
        return getInferior() == intervalo.getInferior()
                && getSuperior() == intervalo.getSuperior();
    }

    public boolean intersecta(Intervalo intervalo) {
        assert intervalo!=null;
        return this.incluye(intervalo.getInferior()) ||
               this.incluye(intervalo.getSuperior()) ||
               intervalo.incluye(this);
    }

    public Intervalo interseccion(Intervalo intervalo) {
        assert this.intersecta(intervalo);
        if (this.incluye(intervalo)){
            return intervalo.clone();
        }else if (intervalo.incluye(this)){
            return this.clone();
        }else if (this.incluye(intervalo.getInferior())){
            return new Intervalo(intervalo.getInferior(), getSuperior());
        }else if (this.incluye(intervalo.getSuperior())){
            return new Intervalo(getInferior(), intervalo.getSuperior());
        }
        return null;
    }

    public void recoger() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Inferior?");
        setInferior(gestorIO.inDouble());
        gestorIO.out("Superior?");
        setSuperior(gestorIO.inDouble());
    }

    public void mostrar() {
        new GestorIO().out("["+getInferior()+","+getSuperior()+"]");
    }

    public void oponer() {
        double inferiorInicial = getInferior();
        double superiorInicial = getSuperior();
        setInferior(-inferiorInicial);
        setSuperior(-superiorInicial);
    }

    public void doblar() {
        double longitudInicial = this.longitud();
        setInferior(getInferior() - longitudInicial / 2);
        setSuperior(getSuperior() + longitudInicial / 2);
    }
    
    public static void main(String [] args){
        Intervalo intervalo = new Intervalo();
        intervalo.recoger();
        intervalo.mostrar();;
        new GestorIO().out("\nLongitud: "+intervalo.longitud+
                            "; Punto Medio: "+intervalo.puntoMedio);
}

}
