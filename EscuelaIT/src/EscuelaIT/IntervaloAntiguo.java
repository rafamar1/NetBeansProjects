package EscuelaIT;

class IntervaloAntiguo {

    private double inferior;
    private double superior;
    private double longitud;

    public IntervaloAntiguo(double inferior, double superior) {
        assert inferior <=superior;
        this.inferior = inferior;
        this.superior = superior;
    }

    public IntervaloAntiguo(IntervaloAntiguo intervalo) {
        this(intervalo.inferior, intervalo.superior) ;
    }

    public IntervaloAntiguo(double superior) {
       this(0,superior);
    }
    
    public IntervaloAntiguo desplazado(double superior) {
        IntervaloAntiguo intervalo=this.clone();
        intervalo.desplazar(superior);
        return intervalo;
    }
    
    public IntervaloAntiguo(){
        this(0,0);
    }

    @Override
    public IntervaloAntiguo clone() {
        return new IntervaloAntiguo(this);
    }
    
    public double longitud() {
        return superior - inferior;
    }

    public void desplazar(double desplazamiento) {
        inferior += desplazamiento;
        superior += desplazamiento;
    }

    public boolean incluye(IntervaloAntiguo intervalo) {
        assert intervalo!=null;
        return this.incluye(intervalo.inferior) &&
               this.incluye(intervalo.superior);
    }

    public boolean incluye(double valor) {
        return inferior <= valor && superior >= valor;
    }

    public boolean equals(IntervaloAntiguo intervalo) {
        assert intervalo!=null;
        return inferior == intervalo.inferior
                && superior == intervalo.superior;
    }

    public boolean intersecta(IntervaloAntiguo intervalo) {
        assert intervalo!=null;
        return this.incluye(intervalo.inferior) ||
               this.incluye(intervalo.superior) ||
               intervalo.incluye(this);
    }

    public IntervaloAntiguo interseccion(IntervaloAntiguo intervalo) {
        assert this.intersecta(intervalo);
        if (this.incluye(intervalo)){
            return intervalo.clone();
        }else if (intervalo.incluye(this)){
            return this.clone();
        }else if (this.incluye(intervalo.inferior)){
            return new IntervaloAntiguo(intervalo.inferior,superior);
        }else if (this.incluye(intervalo.superior)){
            return new IntervaloAntiguo(inferior,intervalo.superior);
        }
        return null;
    }

    public void recoger() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Inferior?");
        inferior = gestorIO.inDouble();
        gestorIO.out("Superior?");
        superior = gestorIO.inDouble();
    }

    public void mostrar() {
        new GestorIO().out("["+inferior+","+superior+"]");
    }

    public void oponer() {
        double inferiorInicial = inferior;
        double superiorInicial = superior;
        inferior = -inferiorInicial;
        superior = -superiorInicial;
    }

    public void doblar() {
        double longitudInicial = this.longitud();
        inferior -= longitudInicial / 2;
        superior += longitudInicial / 2;
    }
}
