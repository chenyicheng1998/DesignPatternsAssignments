# Assignment 15 - Calendar Adapter

This assignment applies the Adapter design pattern by adapting `java.util.Calendar` to a new client-facing interface.

## Implemented Classes

- `NewDateInterface`: target interface used by client code
- `CalendarToNewDateAdapter`: adapter implementation that wraps `Calendar`
- `Main`: demo client that sets a date and advances it by multiple day counts

## Notes

- Interface month values are **1-12**.
- `Calendar` month values are **0-11**.
- The adapter handles this conversion internally.

## Run

From the project root:

```powershell
mvn -pl Assignment15 -am compile
java -cp Assignment15/target/classes adapter.calendar.Main
```

