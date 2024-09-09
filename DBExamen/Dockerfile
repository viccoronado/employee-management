# Use the official MySQL image
FROM mysql:latest

# Set environment variables for MySQL
ENV MYSQL_ROOT_PASSWORD=root_password
ENV MYSQL_DATABASE=EMPLOYEE_MANAGEMENT

# Copy SQL files to the initialization directory
COPY create_tables.sql /docker-entrypoint-initdb.d/
COPY insert_data.sql /docker-entrypoint-initdb.d/
COPY stored_procedures.sql /docker-entrypoint-initdb.d/

# Expose the port the MySQL server runs on
EXPOSE 3306