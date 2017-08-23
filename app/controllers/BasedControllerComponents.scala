package controllers

import javax.inject.Inject

import controllers.base.AuthenticatedAction
import play.api.http.FileMimeTypes
import play.api.i18n.{Langs, MessagesApi}
import play.api.mvc.{ControllerComponents, DefaultActionBuilder, PlayBodyParsers}

import scala.concurrent.ExecutionContext

case class BasedControllerComponents @Inject()(actionBuilder: DefaultActionBuilder
                                               , executionContext: ExecutionContext
                                               , fileMimeTypes: FileMimeTypes
                                               , langs: Langs
                                               , messagesApi: MessagesApi
                                               , parsers: PlayBodyParsers
                                               , authenticatedAction: AuthenticatedAction)
  extends ControllerComponents