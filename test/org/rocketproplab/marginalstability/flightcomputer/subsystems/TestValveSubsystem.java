package org.rocketproplab.marginalstability.flightcomputer.subsystems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.rocketproplab.marginalstability.flightcomputer.Settings;
import org.rocketproplab.marginalstability.flightcomputer.comm.PacketRouter;
import org.rocketproplab.marginalstability.flightcomputer.comm.PacketSources;
import org.rocketproplab.marginalstability.flightcomputer.comm.SCMPacket;
import org.rocketproplab.marginalstability.flightcomputer.comm.SCMPacketType;
import org.rocketproplab.marginalstability.flightcomputer.comm.TestPacketListener;
import org.rocketproplab.marginalstability.flightcomputer.events.SerialListener;
import org.rocketproplab.marginalstability.flightcomputer.hal.SerialPort;

public class TestValveSubsystem {

  private class TestSerialPort implements SerialPort {

    public ArrayList<String> lastWritten;

    public TestSerialPort() {
      this.lastWritten = new ArrayList<String>();
    }

    @Override
    public void registerListener(SerialListener listener) {
    }

    @Override
    public void write(String data) {
      this.lastWritten.add(data);
    }

  }

  @Test
  public void testValveSubsystemConstructor() {
    PacketRouter                  router         = new PacketRouter();
    TestPacketListener<SCMPacket> listener       = new TestPacketListener<SCMPacket>();
    router.addListener(listener, SCMPacket.class,
        PacketSources.EngineControllerUnit);
    ValveSubsystem                valveSubsystem = new ValveSubsystem(
        Settings.INITIAL_VALVE_STATE, router);
    SCMPacket testPacket = new SCMPacket(SCMPacketType.VS, "00000");
    assertEquals(testPacket, listener.lastPacket);
  }
  
  @Test
  public void testValveSubsystemChangeValveState() {
    PacketRouter                  router         = new PacketRouter();
    TestPacketListener<SCMPacket> listener       = new TestPacketListener<SCMPacket>();
    router.addListener(listener, SCMPacket.class,
        PacketSources.EngineControllerUnit);
    ValveSubsystem                valveSubsystem = new ValveSubsystem(
        Settings.INITIAL_VALVE_STATE, router);
    valveSubsystem.changeValveState("11010");
    SCMPacket testPacket = new SCMPacket(SCMPacketType.VS, "11010");
    assertEquals(testPacket, listener.lastPacket);
  }

}
