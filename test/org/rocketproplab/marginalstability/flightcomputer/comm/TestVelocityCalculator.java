package org.rocketproplab.marginalstability.flightcomputer.comm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.rocketproplab.marginalstability.flightcomputer.math.Vector3;
import org.rocketproplab.marginalstability.flightcomputer.tracking.VelocityCalculator;

public class TestVelocityCalculator {
  
  private static final double EPSILON = 0.00000001;

  @Test
  public void testGetVelocity1() {
    String    nEMA1   = "$GPGGA,172814.0,3723.46587704,N,12202.26957864,W,2,6,1.2,"
        + "18.0,M,-25.669,M,2.0,0031*4F";
    GPSPacket prevpacket = new GPSPacket(nEMA1); 
    String    nEMA2   = "$GPGGA,172815.0,3723.46587704,N,12202.26957864,W,2,6,1.2,"
        + "19.0,M,-25.669,M,2.0,0031*4F";
    GPSPacket curpacket = new GPSPacket(nEMA2);
    VelocityCalculator vC = new VelocityCalculator();
    
    assertEquals(1, vC.getSpeed(prevpacket, curpacket), EPSILON);
  }
  
  @Test
  public void testGetVelocity2() {
    String    nEMA1   = "$GPGGA,172814.0,30.0,N,50.0,W,2,6,1.2,"
        + "1800.0,M,-25.669,M,2.0,0031*4F";
    GPSPacket prevpacket = new GPSPacket(nEMA1);
    String    nEMA2   = "$GPGGA,172815.0,35.0,N,60.0,W,2,6,1.2,"
        + "2800.0,M,-25.669,M,2.0,0031*4F";
    GPSPacket curpacket = new GPSPacket(nEMA2);
    VelocityCalculator vC = new VelocityCalculator();
    Vector3 velocity = vC.getVelocityVector(prevpacket, curpacket);
    
    assertEquals(63781000.0, velocity.getX(), EPSILON);
    assertEquals(31890500.0, velocity.getY(), EPSILON);
    assertEquals(1000.0, velocity.getZ(), EPSILON);
    
    assertEquals(71309325.8434687489228, vC.getSpeed(prevpacket, curpacket), EPSILON);
  }
}
