┌─────────────────┐
│      User       │
├─────────────────┤
│ - userId        │
│ - name          │
│ - email         │
│ - phone         │
└─────────────────┘
│
│ makes
▼
┌─────────────────┐         ┌─────────────────┐
│    Booking      │────────▶│   Passenger     │
├─────────────────┤  has    ├─────────────────┤
│ - bookingId     │         │ - passengerId   │
│ - userId        │         │ - name          │
│ - trainId       │         │ - age           │
│ - bookingDate   │         │ - gender        │
│ - status        │         │ - bookingId     │
│ - totalAmount   │         └─────────────────┘
└─────────────────┘
│
│ contains
▼
┌─────────────────┐
│   BookingSeat   │
├─────────────────┤
│ - id            │
│ - bookingId     │
│ - seatId        │
│ - fromStationId │
│ - toStationId   │
│ - status        │
└─────────────────┘
│
▼
┌─────────────────┐         ┌─────────────────┐
│      Seat       │◀────────│     Coach       │
├─────────────────┤  has    ├─────────────────┤
│ - seatId        │         │ - coachId       │
│ - coachId       │         │ - trainId       │
│ - seatNumber    │         │ - coachNumber   │
│ - seatType      │         │ - coachType     │
│ - version       │         │ - totalSeats    │
└─────────────────┘         └─────────────────┘
│
│ belongs to
▼
┌─────────────────┐         ┌─────────────────┐
│     Train       │────────▶│   TrainRoute    │
├─────────────────┤  has    ├─────────────────┤
│ - trainId       │         │ - routeId       │
│ - trainNumber   │         │ - trainId       │
│ - trainName     │         │ - stationId     │
│ - totalCoaches  │         │ - stopNumber    │
└─────────────────┘         │ - arrivalTime   │
│ - departureTime │
│ - dayOffset     │
└─────────────────┘
│
▼
┌─────────────────┐
│    Station      │
├─────────────────┤
│ - stationId     │
│ - stationCode   │
│ - stationName   │
│ - city          │
└─────────────────┘