package org.rocketproplab.marginalstability.flightcomputer.commands;

/**
 * Abstract class that defines basic Command methods every Command has
 * 
 * @author Daniel Walder
 *
 */
public abstract class Command {
  
  /**
   * called when command gets first initialized
   */
  public abstract void initialize();
  
  /**
   * executes the command
   */
  public abstract void execute();
  
  /**
   * Called when command is finished
   * @return true if command finishes without errors
   */
  public abstract boolean isFinished();
}
