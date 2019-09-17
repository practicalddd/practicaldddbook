# Eclipse MicroProfile DDD implementation using Project Helidon

This Chapter contains a complete DDD implementation of the Cargo Tracker application using the Eclipse MicroProfile platform.

The implementation adopts a microservices based architectural style and uses the following technologies
  - Project Helidon MP (1.2) as the MicroProfile implementation
  - MySql schemas for the Databases and
  - RabbitMQ as the microservices messaging choreography mechanism
  
The documentation covers the setup and testing process needed to run the microservices correctly. The details are given for each separate microservice (Booking / Routing / Tracking and Handling)

# Test Case

The test case is as follows

- A Cargo is booked to be delivered from Hong Kong to New York with the delivery deadline of 28 September 2019
- Based on the specifications the Cargo is routed accordingly by assigning an itinierary
- The Cargo is handled at the various ports of the itinerary and is finally claimed by the customer

# Microservices

Booking MS

    This MS takes care of all the operations associated with the booking of the Cargo. The MySql Schemas and the Rabbit MQ    Exchanges have to be setup (creation and binding) before running this microservice
    
    Server Port -> 8080
    Schema Name -> bookingmsdb
    Tables ->
    
    Cargo
    +-----------------------------------+--------------+------+-----+---------+----------------+
    | Field                             | Type         | Null | Key | Default | Extra          |
    +-----------------------------------+--------------+------+-----+---------+----------------+
    | ID                                | int(11)      | NO   | PRI | NULL    | auto_increment |
    | BOOKING_ID                        | varchar(20)  | NO   |     | NULL    |                |
    | TRANSPORT_STATUS                  | varchar(100) | NO   |     | NULL    |                |
    | ROUTING_STATUS                    | varchar(100) | NO   |     | NULL    |                |
    | spec_origin_id                    | varchar(20)  | YES  |     | NULL    |                |
    | spec_destination_id               | varchar(20)  | YES  |     | NULL    |                |
    | SPEC_ARRIVAL_DEADLINE             | date         | YES  |     | NULL    |                |
    | origin_id                         | varchar(20)  | YES  |     | NULL    |                |
    | BOOKING_AMOUNT                    | int(11)      | NO   |     | NULL    |                |
    | handling_event_id                 | int(11)      | YES  |     | NULL    |                |
    | next_expected_location_id         | varchar(20)  | YES  |     | NULL    |                |
    | next_expected_handling_event_type | varchar(20)  | YES  |     | NULL    |                |
    | next_expected_voyage_id           | varchar(20)  | YES  |     | NULL    |                |
    | last_known_location_id            | varchar(20)  | YES  |     | NULL    |                |
    | current_voyage_number             | varchar(100) | YES  |     | NULL    |                |
    | last_handling_event_id            | int(11)      | YES  |     | NULL    |                |
    | last_handling_event_type          | varchar(20)  | YES  |     | NULL    |                |
    | last_handling_event_location      | varchar(20)  | YES  |     | NULL    |                |
    | last_handling_event_voyage        | varchar(20)  | YES  |     | NULL    |                |
    +-----------------------------------+--------------+------+-----+---------+----------------+
    
    
    Leg
    +--------------------+--------------+------+-----+---------+----------------+
    | Field              | Type         | Null | Key | Default | Extra          |
    +--------------------+--------------+------+-----+---------+----------------+
    | ID                 | int(11)      | NO   | PRI | NULL    | auto_increment |
    | LOAD_TIME          | timestamp    | YES  |     | NULL    |                |
    | UNLOAD_TIME        | timestamp    | YES  |     | NULL    |                |
    | load_location_id   | varchar(20)  | YES  |     | NULL    |                |
    | unload_location_id | varchar(20)  | YES  |     | NULL    |                |
    | voyage_number      | varchar(100) | YES  |     | NULL    |                |
    | CARGO_ID           | int(11)      | YES  |     | NULL    |                |
    +--------------------+--------------+------+-----+---------+----------------+
    
    
    Location
    
    +----------+--------------+------+-----+---------+-------+
    | Field    | Type         | Null | Key | Default | Extra |
    +----------+--------------+------+-----+---------+-------+
    | ID       | int(11)      | YES  |     | NULL    |       |
    | NAME     | varchar(50)  | YES  |     | NULL    |       |
    | UNLOCODE | varchar(100) | YES  |     | NULL    |       |
    +----------+--------------+------+-----+---------+-------+
    
    
    Exchanges/Queues -> 
    
    Exchange (cargotracker.cargobookings) -> Queue (cargotracker.bookingsqueue) -> RoutingKey -> (cargobookings)
    Exchange (cargotracker.cargoroutings) -> Queue (cargotracker.routingqueue) -> RoutingKey -> (cargoroutings)
    
    Run command -> java -jar bookingms.jar
    
    JSON Requests (Test via Postman) ->
    
    Cargo Booking (http://localhost:8080/cargobooking)
    --------------------------------------------------

    {
        "bookingAmount": 100,
        "originLocation": "CNHKG",
        "destLocation" : "USNYC",
        "destArrivalDeadline" : "2019-09-28"
    }
    
    This returns a unique "Booking Id" which should be put into all requests with the placeholder <<BookingId>>
    
    Cargo Routing (http://localhost:8080/cargorouting)
    --------------------------------------------------
    {
      "bookingId": "<<BookingId>>"
    }


    Routing MS

    This MS takes care of all the operations associated with the routing of the Cargo. 
    The MySql Schemas and the Rabbit MQ Exchanges have to be setup (creation and binding) before running this microservice
    
    Server Port -> 8081
    Schema Name -> routingmsdb
    Tables ->
    
    voyage
    +---------------+-------------+------+-----+---------+----------------+
    | Field         | Type        | Null | Key | Default | Extra          |
    +---------------+-------------+------+-----+---------+----------------+
    | Id            | int(11)     | NO   | PRI | NULL    | auto_increment |
    | voyage_number | varchar(20) | NO   |     | NULL    |                |
    +---------------+-------------+------+-----+---------+----------------+
    
    carrier_movement
    +-----------------------+--------------+------+-----+---------+----------------+
    | Field                 | Type         | Null | Key | Default | Extra          |
    +-----------------------+--------------+------+-----+---------+----------------+
    | Id                    | int(11)      | NO   | PRI | NULL    | auto_increment |
    | arrival_location_id   | varchar(100) | YES  |     | NULL    |                |
    | departure_location_id | varchar(100) | YES  |     | NULL    |                |
    | voyage_id             | int(11)      | YES  |     | NULL    |                |
    | arrival_date          | date         | YES  |     | NULL    |                |
    | departure_date        | date         | YES  |     | NULL    |                |
    +-----------------------+--------------+------+-----+---------+----------------+
    
    Run command -> java -jar routingms.jar
    
    
Handling MS

Tracking MS
    
