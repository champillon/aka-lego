package persists

import javax.inject.{Inject, Singleton}

import entities.ThermalEntity
import nb.yoda.orm.PStatement
import play.api.db.Database

@Singleton
class ThermalPersist @Inject()(db: Database) {

  def insert(entity: ThermalEntity): ThermalEntity = db.withConnection { implicit conn =>
    PStatement(INSERT)
      .setString(entity.sensorId)
      .setInt(entity.thermal)
      .setDateTime(entity.created)
      .update match {
      case 1 => entity
      case _ => throw new Exception("transaction fail.")
    }
  }

  private lazy val INSERT =
    """
      | INSERT INTO thermals(
      | sensor_id
      | , thermal
      | , created)
      | VALUES(
      | ?
      | , ?
      | , ?);
    """.stripMargin

}
