package models

import forms.FruitingForm
import org.joda.time.DateTime

case class CreateFruiting(sensorId: String
                          , thermal: Double
                          , humidity: Double
                          , co2: Double
                          , uv: Double
                          , created: DateTime)

object CreateFruiting {

  def apply(form: FruitingForm): CreateFruiting =
    CreateFruiting(
      sensorId = form.sensorId
      , thermal = form.thermal
      , humidity = form.humidity
      , co2 = form.co2
      , uv = form.uv
      , created = DateTime.now
    )
}