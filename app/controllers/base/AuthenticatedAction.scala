package controllers.base

import java.util.concurrent.TimeUnit
import javax.inject.Inject

import com.google.common.base.Stopwatch
import com.typesafe.scalalogging.LazyLogging
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class AuthenticatedAction @Inject()(playParser: PlayBodyParsers)
                                   (implicit val executionContext: ExecutionContext)
  extends ActionBuilder[Request, AnyContent]
    with LazyLogging {

  override def invokeBlock[A](request: Request[A]
                              , block: Request[A] => Future[Result]): Future[Result] = {
    val stopwatch = Stopwatch.createStarted()
    try {
      block(request)
    } finally {
      logger.info(s"${request.method} ${request.uri} in ${stopwatch.stop.elapsed(TimeUnit.MILLISECONDS)} ms.")
    }
  }

  val parser: BodyParser[AnyContent] = playParser.anyContent

}
