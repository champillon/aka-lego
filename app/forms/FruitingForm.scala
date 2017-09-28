package forms

import utilities.Json

case class FruitingForm(sensorId: String
                        , thermal: Double
                        , humidity: Double
                        , co2: Double
                        , uv: Double)
  extends Json