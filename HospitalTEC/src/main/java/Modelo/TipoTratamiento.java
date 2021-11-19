
package Modelo;

/**
 * Esta clase enum perimite tener los tipos de tratamientos requeridos
 * @author Pablo Chaves, Aaron Soto y Luis Leitón
 * @version (17/11/2021)
 */
public enum TipoTratamiento {
 Medicamento,
Cirugía,
Curación,
Sutura,
Radiografía,
Ultrasonido,
Otros;

public static TipoTratamiento getMedicamento() {
  return Medicamento;
}

public static TipoTratamiento getCirugía() {
  return Cirugía;
}

public static TipoTratamiento getCuración() {
  return Curación;
}

public static TipoTratamiento getSutura() {
  return Sutura;
}

public static TipoTratamiento getRadiografía() {
  return Radiografía;
}

public static TipoTratamiento getUltrasonido() {
  return Ultrasonido;
}

public static TipoTratamiento getOtros() {
  return Otros;
}

  

}
