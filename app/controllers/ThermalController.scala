package controllers

import javax.inject.{Inject, Singleton}

import controllers.base.BasedController
import facades.ThermalFacade
import forms.ThermalForm
import models.CreatingThermal
import play.api.mvc.{AnyContent, ControllerComponents, Request}
import views.ThermalView

@Singleton
class ThermalController @Inject()(cc: ControllerComponents
                                  , facade: ThermalFacade)
  extends BasedController(cc) {

  def stamp = Action { request: Request[AnyContent] =>
    validate[ThermalForm](request) {
      ThermalView(facade.stamp(
        CreatingThermal(as[ThermalForm](request).get)
      ))
    }
  }

}
