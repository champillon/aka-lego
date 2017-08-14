package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}

@Singleton
class ThermalController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {

  def stamp = Action { request: Request[AnyContent] =>
    Ok(request.body.asJson.get.toString) as "application/json"
  }

}
