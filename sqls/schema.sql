DROP TABLE IF EXISTS fruiting;

CREATE TABLE fruiting
(
    sensor_id                   VARCHAR(64) NOT NULL,
    thermal                     INT NOT NULL,
    created                     TIMESTAMP WITH TIME ZONE NOT NULL
);

ALTER TABLE fruiting OWNER TO akalego;