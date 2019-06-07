package org.sonarsource.shipit.sweat.sensor;

import java.io.IOException;

public interface SensorReader {
   Boolean isAvailable(int id) throws IOException;
}
