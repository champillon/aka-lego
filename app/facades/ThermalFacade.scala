package facades

import javax.inject.{Inject, Singleton}

import entities.ThermalEntity
import models.CreatingThermal
import persists.ThermalPersist

@Singleton
class ThermalFacade @Inject()(persist: ThermalPersist) {

  def stamp(model: CreatingThermal): Boolean =
    persist.insert(ThermalEntity(model))

}
