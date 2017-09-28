DROP TABLE IF EXISTS fruiting;

CREATE TABLE fruiting
(
    id                          VARCHAR(64) NOT NULL,
    sensor_id                   VARCHAR(64) NOT NULL,
    thermal                     REAL,
    humidity                    REAL,
    co2                         REAL,
    uv                          REAL,
    created                     TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT  fruiting_pk PRIMARY KEY (id)
);

ALTER TABLE fruiting OWNER TO akalego;