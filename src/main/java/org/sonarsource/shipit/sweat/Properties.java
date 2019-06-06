package org.sonarsource.shipit.sweat;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sensor")
public class Properties {
  boolean gpio;
  // standard getters and setters

  public boolean isGpio() {
    return gpio;
  }

  public void setGpio(boolean gpio) {
    this.gpio = gpio;
  }
}
