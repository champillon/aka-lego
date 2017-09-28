package persists

import java.sql.ResultSet
import javax.inject.{Inject, Singleton}

import base.Exceptions.CannotCreateException
import entities.FruitingEntity
import nb.yoda.orm.JavaSqlImprovement._
import nb.yoda.orm.PStatement
import play.api.db.Database

@Singleton
class FruitingPersist @Inject()(db: Database) {

  def selectBySensor(sensorId: String): List[FruitingEntity] = db.withConnection { implicit conn =>
    PStatement(SELECT_BY_SENSOR)
      .setString(sensorId: String)
      .queryList(parse)
  }

  def insert(entity: FruitingEntity): FruitingEntity = db.withConnection { implicit conn =>
    PStatement(INSERT)
      .setString(entity.id)
      .setString(entity.sensorId)
      .setDouble(entity.thermal)
      .setDouble(entity.humidity)
      .setDouble(entity.co2)
      .setDouble(entity.uv)
      .setDateTime(entity.created)
      .update match {
      case 1 => entity
      case _ => throw new CannotCreateException(entity)
    }
  }

  private def parse(rs: ResultSet): FruitingEntity =
    FruitingEntity(
      id = rs.getString("id")
      , sensorId = rs.getString("sensor_id")
      , thermal = rs.getDouble("thermal")
      , humidity = rs.getDouble("humidity")
      , co2 = rs.getDouble("co2")
      , uv = rs.getDouble("uv")
      , created = rs.getDateTime("created")
    )

  private lazy val SELECT_BY_SENSOR =
    """
      | SELECT *
      | FROM fruiting
      | WHERE sensor_id = ?
      | ORDER BY created DESC
    """.stripMargin

  private lazy val INSERT =
    """
      | INSERT INTO fruiting(
      | id
      | , sensor_id
      | , thermal
      | , humidity
      | , co2
      | , uv
      | , created)
      | VALUES(
      | ?
      | , ?
      | , ?
      | , ?
      | , ?
      | , ?
      | , ?);
    """.stripMargin

}
