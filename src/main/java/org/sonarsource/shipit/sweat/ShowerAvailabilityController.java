package org.sonarsource.shipit.sweat;

import java.io.IOException;
import org.sonarsource.shipit.sweat.sensor.SensorReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShowerAvailabilityController {

  private static ShowerAvailability WRONG_INPUT = new ShowerAvailability(-1, "Wrong Input");

  private SensorReader sensorReader;

  public ShowerAvailabilityController(SensorReader sensorReader) {
    this.sensorReader = sensorReader;
  }

  @RequestMapping("/shower")
  public ShowerAvailability greeting(@RequestParam(value="id", defaultValue="0") String id) {
    int parsedId = parseShowerId(id);
    if (parsedId == -1) {
      return WRONG_INPUT;
    }

    String status;
    try {
      status = sensorReader.isAvailable(parsedId)
        ? "available"
        : "occupied";
      return new ShowerAvailability(parsedId, status);
    } catch (IOException ioe) {
      return WRONG_INPUT;
    }
  }

  private int parseShowerId(String input) {
    int id;
    try {
      id = Integer.parseInt(input);
    }
    catch (NumberFormatException nfe) {
      id = -1;
    }
    if (id > 2) {
      id = -1;
    }
    return id;
  }
}
