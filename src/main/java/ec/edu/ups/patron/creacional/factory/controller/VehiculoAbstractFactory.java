package ec.edu.ups.patron.creacional.factory.controller;

import ec.edu.ups.patron.creacional.factory.model.Vehiculo;

/**
 *
 * @author Grupo 3
 */
public abstract class VehiculoAbstractFactory {
   public abstract Vehiculo crearVehiculoFactory(String tipoVehiculo);   
}
