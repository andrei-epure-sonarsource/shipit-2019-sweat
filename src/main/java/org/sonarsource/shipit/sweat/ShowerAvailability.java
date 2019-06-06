package org.sonarsource.shipit.sweat;

public class ShowerAvailability {

  private final int id;
  private final String status;

  public ShowerAvailability(int id, String status) {
    this.id = id;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public String getStatus() {
    return status;
  }
}
