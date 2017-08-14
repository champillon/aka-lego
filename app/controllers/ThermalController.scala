package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{AnyContent, ControllerComponents, Request}

@Singleton
class ThermalController @Inject()(cc: ControllerComponents)
  extends BasedController(cc) {

  def stamp = Action { request: Request[AnyContent] =>
    if (request.hasBody)
      success(request.body.asJson.get)
    else
      invalidInput
  }

}
