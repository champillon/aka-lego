package persists

import javax.inject.{Inject, Singleton}

import base.Exceptions.CannotCreateException
import entities.FruitingEntity
import nb.yoda.orm.PStatement
import play.api.db.Database

@Singleton
class FruitingPersist @Inject()(db: Database) {

  def insert(entity: FruitingEntity): FruitingEntity = db.withConnection { implicit conn =>
    PStatement(INSERT)
      .setString(entity.sensorId)
      .setInt(entity.thermal)
      .setDateTime(entity.created)
      .update match {
      case 1 => entity
      case _ => throw new CannotCreateException(entity)
    }
  }

  private lazy val INSERT =
    """
      | INSERT INTO fruiting(
      | sensor_id
      | , thermal
      | , created)
      | VALUES(
      | ?
      | , ?
      | , ?);
    """.stripMargin

}
