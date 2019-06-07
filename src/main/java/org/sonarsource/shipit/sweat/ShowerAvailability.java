package org.sonarsource.shipit.sweat;

import sun.security.x509.AVA;

public class ShowerAvailability {

  public enum Status {
    NONE,
    AVAILABLE,
    OCCUPIED,
    IO_ERROR,
    WRONG_INPUT
  }

  private final int id;
  private final Status status;

  public ShowerAvailability(int id, boolean isAvailable) {
    this(id, isAvailable
        ? Status.AVAILABLE
        : Status.OCCUPIED);
  }

  public ShowerAvailability(int id, Status status) {
    this.id = id;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public Status getStatus() {
    return status;
  }
}
