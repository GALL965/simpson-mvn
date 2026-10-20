# Programa 5a

Este proyecto calcula la integral de la distribucion t desde `0` hasta `x` usando la regla de Simpson.

## Ejecucion

Desde la carpeta del proyecto:

```text
mvn test
mvn package
java -cp target/classes edu.usbi.App
```

Al ejecutar la aplicacion se ingresan, en este orden:

1. Numero inicial de segmentos, positivo y par.
2. Error aceptable.
3. Grados de libertad.
4. Limite `x`.

Tambien pueden pasarse como argumentos:

```text
java -cp target/classes edu.usbi.App 10 0.00001 9 1.1
```

## Valores de la Tabla 1

| x | dof | Resultado esperado |
|---:|---:|---:|
| 1.1 | 9 | 0.35006 |
| 1.1812 | 10 | 0.36757 |
| 2.750 | 30 | 0.49500 |
# simpson-mvn
# simpson-mvn
