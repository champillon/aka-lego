DROP TABLE IF EXISTS thermals;

CREATE TABLE thermals
(
    sensor_id                   VARCHAR(64) NOT NULL,
    thermal                     INT NOT NULL,
    created                     TIMESTAMP WITH TIME ZONE NOT NULL
);

ALTER TABLE thermals OWNER TO akalego;