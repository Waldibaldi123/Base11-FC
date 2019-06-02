package org.rocketproplab.marginalstability.flightcomputer.commands;

import org.rocketproplab.marginalstability.flightcomputer.comm.PacketDirection;
import org.rocketproplab.marginalstability.flightcomputer.comm.SCMPacket;
import org.rocketproplab.marginalstability.flightcomputer.events.PacketListener;

/**
 * If a received SCMPacket contains a command it gets dispatched here
 * 
 * @author Daniel Walder
 *
 */

public class CommandDispatcher implements PacketListener<SCMPacket> {

  @Override
  public void onPacket(PacketDirection directionReceived, SCMPacket packet) {
    if (directionReceived != PacketDirection.RECIVE) {
      return;
    }

    determineCommand(packet);
  }

  /**
   * Determine, create and execute the command here
   * @param packet the packet that contains the command
   */
  public void determineCommand(SCMPacket packet) {
    switch (packet.getID()) {

    case VS:
      //TODO
      break;
      
    //TODO
      
    default:
      break;
    }

  }
}
