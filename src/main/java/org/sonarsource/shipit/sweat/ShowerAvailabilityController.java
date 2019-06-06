package org.sonarsource.shipit.sweat;

import java.io.IOException;
import org.sonarsource.shipit.sweat.sensor.SensorReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShowerAvailabilityController {

  private static ShowerAvailability WRONG_INPUT = new ShowerAvailability(-1, ShowerAvailability.Status.WRONG_INPUT);
  private static ShowerAvailability IO_ERROR = new ShowerAvailability(-1, ShowerAvailability.Status.IO_ERROR);

  private SensorReader sensorReader;

  public ShowerAvailabilityController(SensorReader sensorReader) {
    this.sensorReader = sensorReader;
  }

  @RequestMapping("/shower/api")
  public ShowerAvailability greeting(@RequestParam(value="id", defaultValue="0") String id) {
    int parsedId = parseShowerId(id);
    if (parsedId == -1) {
      return WRONG_INPUT;
    }

    ShowerAvailability.Status status;
    try {
      status = sensorReader.isAvailable(parsedId)
        ? ShowerAvailability.Status.AVAILABLE
        : ShowerAvailability.Status.OCCUPIED;
      return new ShowerAvailability(parsedId, status);
    } catch (IOException ioe) {
      return IO_ERROR;
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
