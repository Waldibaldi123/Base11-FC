package org.rocketproplab.marginalstability.flightcomputer.subsystems;

import org.rocketproplab.marginalstability.flightcomputer.Settings;
import org.rocketproplab.marginalstability.flightcomputer.comm.PacketRelay;
import org.rocketproplab.marginalstability.flightcomputer.comm.PacketSources;
import org.rocketproplab.marginalstability.flightcomputer.comm.SCMPacket;
import org.rocketproplab.marginalstability.flightcomputer.comm.SCMPacketType;

/**
 * A subsystem that controls the states of the valves.
 * 
 * @author Daniel Walder
 *
 */

public class ValveSubsystem implements Subsystem {

  private String currentValveState; // 5 characters in binary e.g. "10110"
  private PacketRelay packetRelay;

  /**
   * Create a new valve subsystem
   * 
   * @param valveState
   */
  public ValveSubsystem(String valveState, PacketRelay packetRelay) {
    currentValveState = valveState;
    this.packetRelay = packetRelay;
    //set default valve state
    changeValveState(valveState);
  }
  
  /**
   * Changes valveState by sending SCMPacket to the ECU
   * @param newValveState
   */
  public void changeValveState(String newValveState) {
    
    SCMPacket newValvePacket = new SCMPacket(SCMPacketType.VS, newValveState);
   
    if(newValvePacket.isValid())
      packetRelay.sendPacket(newValvePacket, PacketSources.EngineControllerUnit);
  }

  @Override
  public void update() {
    //empty 
  }

}
