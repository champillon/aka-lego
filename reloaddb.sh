#!/bin/bash

if [[ ! -n $REIMPORTDB_PATH  ]]; then
export REIMPORTDB_PATH=/usr/local/bin/
fi
${REIMPORTDB_PATH}dropdb --if-exists akalego
${REIMPORTDB_PATH}createdb -Uakalego -Oakalego akalego
${REIMPORTDB_PATH}psql -Uakalego akalego < sqls/schema.sql