package ec.edu.ups.patron.creacional.factory.controller;

import ec.edu.ups.patron.creacional.factory.model.Auto;
import ec.edu.ups.patron.creacional.factory.model.Camion;
import ec.edu.ups.patron.creacional.factory.model.Camioneta;
import ec.edu.ups.patron.creacional.factory.model.Vehiculo;

/**
 *
 * @author Grupo 3
 */
public class VehiculoFactory extends VehiculoAbstractFactory{
  @Override
    public Vehiculo crearVehiculoFactory(String tipoVehiculo) {
     switch (tipoVehiculo) {
         case "auto":
             return new Auto();
         case "camioneta":
             return new Camioneta();
         case "camion":
             return new Camion();
         default:
             throw new IllegalArgumentException("Parámetro inválido");
     }
}
}
