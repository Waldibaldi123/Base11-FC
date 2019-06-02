package org.rocketproplab.marginalstability.flightcomputer;

public class Settings {

  // Flight State Settings

  /**
   * The speed we are at during our apogee period
   */
  public static double APOGEE_SPEED = 10; // m/s

  /**
   * The speed we need to be moving less than to be considered landed
   */
  public static double LANDED_SPEED = 1; // m/s

  // Parachute Deploy Settings

  /**
   * The height at which we should deploy the main chute in meters above sea
   * level
   */
  public static double MAIN_CHUTE_HEIGHT = 5000; // m

  // Unit conversions

  /**
   * Conversion constant for how many milliseconds are in a second
   */
  public static double MS_PER_SECOND = 1000; // ms/s
  
  //Valve states
  /**
   * Initial state of valves when subsystem is first initialized
   */
  public static String INITIAL_VALVE_STATE = "00000";
}
