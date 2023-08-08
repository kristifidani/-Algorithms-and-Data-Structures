## Introduction

A Hotel Management System (HMS) application with manually implemented Algorithms and Data Structures (ADS), without the use of any third-party code or Java libraries (e.g. java.Util). 
This system is going to be responsible for managing a hotel for a single day.  
Some clients are going to check in, others are going to check out and some rooms need to be cleaned. 

#### Properties
1. A hotel consists of:
    - rooms
    - clients
    - wings
  
2. The room is characterized by these properties:

    - Wing
    - Room number
    - Status of the room - READY (free&clean) / OCCUPIED / CHECKED OUT
    - Unique id

    There are 2 types of rooms:
    - A double room can accommodate 2 people and needs 1 hour to be cleaned.
    - A family room can accommodate 4 people and needs 2 hours to be cleaned.

3. The client is characterized by these properties:

    - Name
    - EmailAddress
    - Unique id
    - Hotel Room

#### Check-in and Check-out

When a new client is checking in to the hotel, the following happens:

- If there is a room with the status “Ready”, the check-in can be completed. The “Ready” room can accommodate the new client and the room’s status changes to “Occupied”. The client doesn’t have to wait.
- If there is not a “Ready” room but there is a “CheckedOut” room available, it can be assigned to a client. The client has to wait for the room to be cleaned.
- When a client checks out from a room, the status of that room changes to “CheckedOut” and the room needs to be cleaned before a new client can check in to it.

#### Cleaning

The cleaning order of the rooms depends on:

- The wing plan of the hotel. (shortest path algorithm implemented)
- The priority rule: Family rooms have priority over Double rooms.
- All rooms with the status “checkedOut” need to be cleaned.
 

## Data Structures implemented
- Vector
- LinkedList
- Queue
- Stack
- Priority Queue
- Binary Tree
- Red and Black Tree
- Graph
