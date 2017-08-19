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
      .setString(entity.id)
      .setString(entity.sensorId)
      .setDouble(entity.thermal)
      .setDouble(entity.humidity)
      .setDouble(entity.co2)
      .setDateTime(entity.created)
      .update match {
      case 1 => entity
      case _ => throw new CannotCreateException(entity)
    }
  }

  private lazy val INSERT =
    """
      | INSERT INTO fruiting(
      | id
      | , sensor_id
      | , thermal
      | , humidity
      | , co2
      | , created)
      | VALUES(
      | ?
      | , ?
      | , ?
      | , ?
      | , ?
      | , ?);
    """.stripMargin

}
