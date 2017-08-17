package controllers.base

import play.api.mvc.{AbstractController, ControllerComponents}
import utilities.Json

abstract class ResultController(cc: ControllerComponents)
  extends AbstractController(cc) {

  def success(json: Json) = Ok(json.toText) as APPLICATION_JSON

  def fail(error: String) = InternalServerError(error)

  def invalidInput(error: String) = BadRequest(error)

  private lazy val APPLICATION_JSON = "application/json"
}
