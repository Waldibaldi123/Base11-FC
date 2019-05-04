package org.rocketproplab.marginalstability.flightcomputer.math;

/**
 * A vector class
 * @author Max Apodaca
 *
 */
public class Vector3 {
  
  private double x;
  private double y;
  private double z;
  
  public Vector3() {
    this.x = 0.0;
    this.y = 0.0;
    this.z = 0.0;
  }
  
  public Vector3(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public Vector3(Vector3 vector) {
    this.x = vector.getX();
    this.y = vector.getY();
    this.z = vector.getZ();
  }

  /**
   * @return the x component
   */
  public double getX() {
    return x;
  }

  /**
   * @return the y component
   */
  public double getY() {
    return y;
  }

  /**
   * @return the z component
   */
  public double getZ() {
    return z;
  }
  
  /**
   * @return the length of the vector
   */
  public double getLength() {
    return Math.sqrt((getX() * getX()) + (getY() * getY()) + (getZ() * getZ()));
  }
  
}
