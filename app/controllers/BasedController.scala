package controllers

import play.api.libs.json.JsValue
import play.api.mvc.{AbstractController, ControllerComponents}

abstract class BasedController(cc: ControllerComponents)
  extends AbstractController(cc) {

  protected def success(json: JsValue) = Ok(json.toString) as APPLICATION_JSON

  protected def fail(error: String) = InternalServerError(error)

  protected def invalidInput = BadRequest

  private lazy val APPLICATION_JSON = "application/json"

}
