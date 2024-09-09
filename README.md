# Employee Management
Desafío técnico realizado en septiembre del 2024.-

- POST /api/employees
- GET /api/employees/by-job
- GET /api/employees/hours
- GET /api/employees/payment
- POST /api/worked-hours

La aplicación está completamente dockerizada para facilitar su despliegue y gestión en entornos de desarrollo y producción. Utiliza Docker para crear y ejecutar un contenedor de MySQL que incluye la base de datos EMPLOYEE_MANAGEMENT. Los scripts incluidos en el contenedor se encargan de crear las tablas necesarias (GENDERS, JOBS, EMPLOYEES, EMPLOYEE_WORKED_HOURS) y de insertar datos iniciales en estas tablas para poblar la base de datos con información de muestra.
Para iniciar la aplicación, simplemente ejecuta
```bash
docker-compose up -d
```

para construir y desplegar los contenedores en segundo plano. 
Si necesitas detener los contenedores, utiliza 
```bash
docker-compose down. 
```
Los contenedores están configurados para ser accesibles en puertos específicos, y los scripts SQL se ejecutan automáticamente cuando el contenedor de MySQL se inicia, asegurando que la base de datos esté lista para usarse con los datos iniciales predefinidos.

### Pruebas unitarias
Realizadas con Mockito:
```bash
mvn test
```

Desde ya, si estás leyendo esto muchas gracias por tu tiempo y todas las sugerencias de mejoras son más que bienvenidas. ¡Gracias por la oportunidad de mostrar un poco de lo que sé hacer! 🌈
