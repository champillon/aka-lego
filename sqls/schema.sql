DROP TABLE IF EXISTS fruiting;

CREATE TABLE fruiting
(
    sensor_id                   VARCHAR(64) NOT NULL,
    thermal                     REAL,
    humidity                    REAL,
    co2                         REAL,
    created                     TIMESTAMP WITH TIME ZONE NOT NULL
);

ALTER TABLE fruiting OWNER TO akalego;