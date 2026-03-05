# Simulador de Fútbol (Java por consola)

Este proyecto es un simulador de fútbol por consola hecho en Java. La idea es poder crear competiciones, generar calendarios o cuadros, simular partidos (rápido o en directo) y consultar resultados y clasificaciones según el tipo de torneo.

---

## Requisitos

- Java 17 (o superior recomendado)
- Ejecutar desde IntelliJ / VS Code / terminal

---

## Cómo ejecutar

1. Abre el proyecto en tu IDE.
2. Ejecuta la clase principal:
   - `main.Main`

Al arrancar, se abre el menú del simulador.

---

## Cómo se usa (flujo normal)

Para que todo funcione sin errores, lo normal es seguir este orden:

1. Elegir competición
2. Crear equipos
3. Generar (calendario en liga / cuadro en torneos)
4. Ver calendario o cuadro
5. Simular (siguiente jornada o siguiente ronda)
6. Ver últimos resultados
7. Ver clasificación (solo en liga)

Si intentas ver calendario o simular sin haber generado antes, el programa te avisará con mensajes tipo “Primero genera…” o “Crea liga…”.

---

## Competiciones disponibles

Desde el menú de competiciones puedes entrar a:

1. Liga
2. Champions
3. Europa League
4. Copa del Rey
5. Supercopa

---

## Reglas generales del simulador

### Equipos y datos
- Los clubes se cargan desde la parte de `datos` (cargador de datos).
- Cada club tiene un nivel (valor numérico) y ese nivel influye en los resultados.
- Al crear equipos, también se crean plantillas con jugadores y se van guardando estadísticas.

### Modos de simulación
El simulador tiene dos formas de jugar:

- Simulación rápida: calcula el resultado y lo muestra directamente.
- En directo: simula con narración (minutos, acciones, etc.).

En el menú hay una opción para activar o desactivar el modo “directo”.

### Partido en vivo (elegir partido)
Existe una opción para elegir un partido “disponible” (que aún no se ha jugado) y simularlo en vivo.

- En Liga funciona (elige partido de la jornada).
- En Champions / Copa / Supercopa está preparado.
- En Europa League, en el menú actual aparece como “No disponible”.

---

## Cómo se simula un partido (reglas del resultado)

La simulación de goles se basa en el nivel del equipo y el nivel del rival.

### Media de goles (idea general)
Se calcula una media de gol usando:
- diferencia de nivel entre los equipos
- una pequeña ventaja para el equipo local

Además hay límites para que no salgan resultados absurdos:
- la media no baja de un mínimo
- la media no supera un máximo

### Goles finales
- Los goles se generan con un método tipo Poisson (implementado dentro del proyecto).
- Hay un límite para que no se disparen:
  - mínimo 0
  - máximo 6 goles por equipo

### Estadísticas de jugadores
Durante la simulación se van sumando estadísticas como:
- goles
- asistencias
- tarjetas (amarilla/roja)
- porterías a cero (cuando toca)

---

# Reglas por competición

## 1) LIGA (LaLiga / Hypermotion / Premier / Serie A / Bundesliga / Ligue 1)

### Calendario
- Formato ida y vuelta.
- Si el número de equipos es impar, se añade un “descanso” para cuadrar las jornadas.
- Total jornadas: `(n - 1) * 2`

### Puntuación
- Victoria: 3 puntos
- Empate: 1 punto
- Derrota: 0 puntos

### Orden de clasificación (desempates)
1. Puntos
2. Diferencia de goles (GF - GC)
3. Goles a favor (GF)
4. Nombre (orden alfabético)

### Simular jornada
- Si no has elegido equipo: simula toda la jornada.
- Si eliges un equipo: el simulador puede centrarse en su partido.

### Saltar a jornada
Hay una opción para ir a la jornada X y el programa simula las anteriores automáticamente.

---

## 2) CHAMPIONS LEAGUE (cuadro de 16)

### Formato
- Octavos, cuartos y semifinales: ida y vuelta
- Final: partido único

### Desempates
- Se decide por global (suma de goles).
- Si el global queda empate, pasa uno al azar como desempate directo.

---

## 3) EUROPA LEAGUE (cuadro de 16)

### Formato
- Misma idea que Champions: cuadro de 16, eliminatorias y final.
- Desempates: global y si empatan, ganador aleatorio.

### Nota del menú
“Partido en vivo” en Europa League no está habilitado desde el menú (sale “No disponible”).

---

## 4) COPA DEL REY (eliminatoria con previa)

### Participantes
Se juntan equipos de LaLiga y Hypermotion para jugar una copa con todos.

### Rondas
1. Ronda previa (si hace falta para cuadrar potencia de 2)
2. Dieciseisavos
3. Octavos
4. Cuartos
5. Semifinales (ida y vuelta)
6. Final (partido único)

### Desempates
- Partido único: si empatan, “penaltis” y ganador aleatorio.
- Semifinales ida/vuelta: por global y si empatan, “penaltis” y ganador aleatorio.

---

## 5) SUPERCOPA (4 equipos)

### Formato
- 2 semifinales + final
- Partidos únicos
- Si empatan: penaltis (ganador aleatorio)

---

## Premios individuales (si se usan)

Existe un sistema de premios que se calcula con las estadísticas acumuladas de los jugadores (goles, asistencias, porterías a cero, etc.), dependiendo de cómo esté conectado al menú.

---

## Estructura del proyecto (resumen simple)

- `main/` → arranque del programa y menú
- `datos/` → carga de clubes y creación de plantillas
- `competicion/` → lógica de liga y torneos
- `partido/` → simulación de partidos
- `jugadores/` → jugador, posición, estadísticas
- `ui/` / `utilidades/` → tablas, pausas, texto lento, etc.

---

## Curso

- 1º DAM (Desarrollo de Aplicaciones Multiplataforma)

---

## Autores

- Omar
- Juanda
- Jp