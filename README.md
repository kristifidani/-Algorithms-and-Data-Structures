# Hotel Management System with Custom Algorithms and Data Structures

## Introduction

Welcome to the Hotel Management System (HMS) application, where Algorithms and Data Structures (ADS) are manually implemented to create an efficient and comprehensive solution for managing a hotel's operations within a single day. The system handles guest check-ins, check-outs, and room cleaning, showcasing the power of custom algorithms and data structures to streamline the hotel management process.

## System Properties

The hotel management system encompasses key components that interact seamlessly to ensure smooth operations:

1. **Hotel Components**:
   - Rooms: Different types of rooms, each with its own characteristics and statuses.
   - Clients: Guests checking in and out of the hotel.
   - Wings: Distinct sections of the hotel that impact room assignments and cleaning orders.

2. **Room Characteristics**:

   Rooms are defined by their properties, including:
   - Wing: The section of the hotel the room belongs to.
   - Room number: A unique identifier for each room.
   - Room status: Indicating whether the room is ready, occupied, or checked out.
   - Unique ID: A system-generated identifier for each room.

   The system classifies rooms into two types:
   - Double rooms: Accommodates two people and requires one hour for cleaning.
   - Family rooms: Accommodates four people and requires two hours for cleaning.

3. **Client Characteristics**:

   Clients are characterized by their information, which includes:
   - Name: Guest's name.
   - Email address: Contact information for communication.
   - Unique ID: A distinct identifier assigned to each guest.
   - Hotel room: The room assigned to the guest upon check-in.

## Check-in and Check-out Process

The hotel's check-in and check-out process follows a structured approach:

- If a "Ready" room is available, a new guest can check in immediately, and the room's status changes to "Occupied".
- In the absence of "Ready" rooms, a "Checked Out" room is assigned to the guest, but cleaning is required before occupancy.
- Upon check-out, a room's status transitions to "Checked Out", and it needs cleaning before the next guest arrives.

## Cleaning and Prioritization

Room cleaning is managed based on:

- The wing layout, using a shortest path algorithm, which optimizes the order of cleaning.
- A priority rule, giving family rooms precedence over double rooms in the cleaning order.
- All "Checked Out" rooms must undergo cleaning before being assigned to a new guest.

## Implemented Data Structures

This project showcases the implementation of essential data structures, including:

- Vector
- LinkedList
- Queue
- Stack
- Priority Queue
- Binary Tree
- Red and Black Tree
- Graph

By leveraging these custom data structures and algorithms, the Hotel Management System demonstrates enhanced efficiency, accurate room assignments, and a seamless experience for both guests and hotel staff.
