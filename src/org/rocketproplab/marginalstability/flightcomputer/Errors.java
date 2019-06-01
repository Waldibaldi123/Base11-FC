package org.rocketproplab.marginalstability.flightcomputer;

public enum Errors {

  UNKNOWN_ERROR("Unexpected error occured!");
  
  private String errorMessage;
  
  /**
   * Sets the error message in the error
   * @param errorMessage
   */
  Errors(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  @Override
  public String toString() {
    return this.errorMessage;
  }
  
}
