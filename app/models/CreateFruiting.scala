package models

import forms.FruitingForm
import org.joda.time.DateTime

case class CreateFruiting(sensorId: String
                          , thermal: Int
                          , created: DateTime)

object CreateFruiting {

  def apply(form: FruitingForm): CreateFruiting =
    CreateFruiting(
      sensorId = form.sensorId
      , thermal = form.thermal.toInt
      , created = DateTime.now
    )
}