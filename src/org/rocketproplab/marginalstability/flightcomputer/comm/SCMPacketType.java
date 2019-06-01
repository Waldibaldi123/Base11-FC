package org.rocketproplab.marginalstability.flightcomputer.comm;

public enum SCMPacketType {
  /**
   * Change the state of the valves, each index in data is a 1 or 0 that
   * Specifies valve 0-4.
   */
  VS("Valve State"), HB("HB"), // TODO fill this packet in

  /**
   * Position of the GPS x coordinate. Bits are hex integer value (m)
   */
  GX("GPS Position X"),

  /**
   * Position of the GPS y coordinate. Bits are hex integer value (m)
   */
  GY("GPS Position Y"),

  /**
   * Position of the GPS z coordinate. Bits are hex integer value (m)
   */
  GZ("GPS Position Z"),

  /**
   * Computed velocity along x axis. Bits are floating point value (m/s)
   */
  VX("GPS Velocity X"),

  /**
   * Computed velocity along y axis. Bits are floating point value (m/s)
   */
  VY("GPS Velocity Y"),

  /**
   * Computed velocity along z axis. Bits are floating point value (m/s)
   */
  VZ("GPS Velocity Z"),

  /**
   * Reading of thermocouple 0. Bits are floating point value (C)
   */
  T0("Thermocouple 0"),

  /**
   * Reading of thermocouple 1. Bits are floating point value (C)
   */
  T1("Thermocouple 1"),

  /**
   * Reading of thermocouple 2. Bits are floating point value (C)
   */
  T2("Thermocouple 2"),

  /**
   * Reading of thermocouple 3. Bits are floating point value (C)
   */
  T3("Thermocouple 3"),

  /**
   * Reading of thermocouple 4. Bits are floating point value (C)
   */
  T4("Thermocouple 4"),

  /**
   * Reading of pressure transducer 0. Bits are integer value (PSI)
   */
  P0("Pressure Transducer 0"),

  /**
   * Reading of pressure transducer 1. Bits are integer value (PSI)
   */
  P1("Pressure Transducer 1"),

  /**
   * Reading of pressure transducer 2. Bits are integer value (PSI)
   */
  P2("Pressure Transducer 2"),

  /**
   * Reading of pressure transducer 3. Bits are integer value (PSI)
   */
  P3("Pressure Transducer 3"),

  /**
   * Reading of pressure transducer 4. Bits are integer value (PSI)
   */
  P4("Pressure Transducer 4"),

  /**
   * Error. The bits are the error code
   */
  ER("Error"),

  /**
   * Warning. The bits are the warning code
   */
  WA("Warning");

  private String name;

  /**
   * Create a new SCMPacketType enum element with the appropriate name to print
   * when relevant
   * 
   * @param name the full name of the packet type
   */
  SCMPacketType(String name) {
    this.name = name;
  }

  /**
   * Returns the human readable name of the packet type
   * @return the human readable name of this packet type
   */
  public String getName() {
    return this.name;
  }
}
