package org.sonarsource.shipit.sweat;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sensor")
public class Properties {
  boolean real;
  boolean firstEnabled;
  int firstGpio;
  boolean secondEnabled;
  int secondGpio;

  // standard getters and setters

  public boolean isReal() {
    return real;
  }

  public void setReal(boolean real) {
    this.real = real;
  }

  public boolean isFirstEnabled() {
    return firstEnabled;
  }

  public void setFirstEnabled(boolean firstEnabled) {
    this.firstEnabled = firstEnabled;
  }

  public int getFirstGpio() {
    return firstGpio;
  }

  public void setFirstGpio(int firstGpio) {
    this.firstGpio = firstGpio;
  }

  public boolean isSecondEnabled() {
    return secondEnabled;
  }

  public void setSecondEnabled(boolean secondEnabled) {
    this.secondEnabled = secondEnabled;
  }

  public int getSecondGpio() {
    return secondGpio;
  }

  public void setSecondGpio(int secondGpio) {
    this.secondGpio = secondGpio;
  }
}
