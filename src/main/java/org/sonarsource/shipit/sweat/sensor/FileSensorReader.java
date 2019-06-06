package org.sonarsource.shipit.sweat.sensor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
public class FileSensorReader implements SensorReader {
  Logger logger = LoggerFactory.getLogger(FileSensorReader.class);

  @Override
  public boolean isAvailable(int id) throws IOException {
    logger.info("Will read sensor for shower {}", id);

    String status;
    try (BufferedReader br = new BufferedReader(new FileReader("/opt/s-w-e-a-t/shower.txt"))) {
      status = br.readLine();
      if (status.equals("1")) {
        logger.info("Return TRUE");
        return true;
      } else if (status.equals("0")) {
        logger.info("Return FALSE");
        return false;
      }
    } catch (Exception e) {
      logger.info("Could not read file");
      throw e;
    }

    logger.info("Could not read TRUE or FALSE");
    throw new IOException("Unsupported status " + status);
  }
}
