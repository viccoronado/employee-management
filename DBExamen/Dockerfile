FROM mysql:latest

# Copia el script SQL al contenedor
COPY create_tables.sql /docker-entrypoint-initdb.d/
COPY insert_sample_data.sql /docker-entrypoint-initdb.d/