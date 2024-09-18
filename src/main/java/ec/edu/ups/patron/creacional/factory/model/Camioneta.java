package ec.edu.ups.patron.creacional.factory.model;

/**
 *
 * @author Grupo 3
 */
public class Camioneta extends Vehiculo{
  
    @Override
    public double costoMatricula() {
    	double resultado = (this.getAvaluo() / ((this.getCilindraje() / this.getImpuesto()) * 1.5));
	    return Math.round(resultado * 100.0) / 100.0;
    }
}
