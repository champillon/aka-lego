package models

import forms.ThermalForm
import org.joda.time.DateTime

case class CreatingThermal(sensorId: String
                          , thermal: Int
                          , created: DateTime)

object CreatingThermal {

  def apply(form: ThermalForm): CreatingThermal =
    CreatingThermal(
      sensorId = form.sensorId
      , thermal = form.thermal.toInt
      , created = DateTime.now
    )
}