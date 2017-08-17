package facades

import javax.inject.{Inject, Singleton}

import entities.ThermalEntity
import models.{CreatingThermal, Thermal}
import persists.ThermalPersist
import utilities.Uuid

@Singleton
class ThermalFacade @Inject()(persist: ThermalPersist) {

  def stamp(model: CreatingThermal): Thermal = {
    Thermal(
      persist.insert(ThermalEntity(model, Uuid.get))
    )
  }


}
