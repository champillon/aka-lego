package controllers

import javax.inject.{Inject, Singleton}

import forms.ThermalForm
import play.api.mvc.{AnyContent, ControllerComponents, Request}

@Singleton
class ThermalController @Inject()(cc: ControllerComponents)
  extends BasedController(cc) {

  def stamp = Action { request: Request[AnyContent] =>
    form[ThermalForm](request) {
      as[ThermalForm](request).get
    }
  }

}
