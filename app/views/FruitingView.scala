package views

import models.Fruiting
import org.joda.time.{DateTime, DateTimeZone}
import utilities.Json

case class FruitingView(id: String
                        , sensorId: String
                        , thermal: Double
                        , humidity: Double
                        , co2: Double
                        , created: DateTime)
  extends Json

object FruitingView {

  def apply(model: Fruiting): FruitingView =
    FruitingView(
      id = model.id
      , sensorId = model.sensorId
      , thermal = model.thermal
      , humidity = model.humidity
      , co2 = model.co2
      , created = model.created.withZone(DateTimeZone.forID("Asia/Bangkok"))
    )
}