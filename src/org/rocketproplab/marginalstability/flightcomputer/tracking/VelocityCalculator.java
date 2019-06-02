package org.rocketproplab.marginalstability.flightcomputer.tracking;

import org.rocketproplab.marginalstability.flightcomputer.comm.GPSPacket;
import org.rocketproplab.marginalstability.flightcomputer.events.VelocityListener;
import org.rocketproplab.marginalstability.flightcomputer.math.InterpolatingVector3;
import org.rocketproplab.marginalstability.flightcomputer.math.Vector3;

public class VelocityCalculator implements VelocityListener, InterpolatingVector3 {
  
  private static Vector3 prevVelocity;
  private static Vector3 currVeloctiy;
  
  public VelocityCalculator() {
    //default constructor
  }

  @Override
  public void onVelocityUpdate(Vector3 velocity, double time) {
    // TODO Auto-generated method stub

  }
  
  @Override
  public Vector3 getAt(double time) {
    
    return null;
  } 

  /**
   * Takes last two GPSPackets and calculates 3 dimensional velocity-vector 
   * @param prevGPSPacket the previous packet
   * @param curGPSPacket the current packet
   * @return Vector3 Velocity Vector
   */
  public Vector3 getVelocityVector(GPSPacket prevGPSPacket,
      GPSPacket curGPSPacket) {
    double deltaLat = curGPSPacket.getLatitude() - prevGPSPacket.getLatitude();
    double deltaLon  = curGPSPacket.getLongitude() - prevGPSPacket.getLongitude();
    double deltaTime = curGPSPacket.getTime() - prevGPSPacket.getTime();
    double angVelocityX = deltaLon / deltaTime;
    double angVelocityY = deltaLat / deltaTime;
    int radiusEarth = 6378100;
    double velocityX = angVelocityX * radiusEarth;
    double velocityY = angVelocityY * radiusEarth;
    double deltaZ = curGPSPacket.getAltitude() - prevGPSPacket.getAltitude();
    double velocityZ = deltaZ / deltaTime;
    return new Vector3(velocityX, velocityY, velocityZ);
  }
  
  /**
   * Calculates speed from velocity vector
   * @param prevGPSPacket
   * @param curGPSPacket
   * @return speed 
   */
  public double getSpeed(GPSPacket prevGPSPacket, GPSPacket curGPSPacket) {
    Vector3 velocityVector = getVelocityVector(prevGPSPacket, curGPSPacket);
    return velocityVector.getLength();
  }
  
  public double getAcceleration(GPSPacket prevGPSPacket, GPSPacket curGPSPacket) {
    Vector3 velocityVector = getVelocityVector(prevGPSPacket, curGPSPacket);
    return 0.0; //TODO
  }
  
}
