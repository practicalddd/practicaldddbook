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
    Schema Name -> bookingmsdb (user: bookingmsdb / pw: bookingmsdb)
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
    Schema Name -> routingmsdb (user: routingmsdb / pw: routingmsdb)
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
    
    
Tracking MS

    This MS takes care of all the tracking operations associated with the Cargo. 
    The MySql Schemas and the Rabbit MQ Exchanges have to be setup (creation and binding) before running this microservice
    
    Server Port -> 8082
    Schema Name -> trackingmsdb (user: trackingmsdb/pw:trackingmsdb)
    Tables ->
    
    tracking_activity
    +-----------------+-------------+------+-----+---------+----------------+
    | Field           | Type        | Null | Key | Default | Extra          |
    +-----------------+-------------+------+-----+---------+----------------+
    | Id              | int(11)     | NO   | PRI | NULL    | auto_increment |
    | tracking_number | varchar(20) | NO   |     | NULL    |                |
    | booking_id      | varchar(20) | YES  |     | NULL    |                |
    +-----------------+-------------+------+-----+---------+----------------+
    
    tracking_handling_events
    +---------------+--------------+------+-----+---------+----------------+
    | Field         | Type         | Null | Key | Default | Extra          |
    +---------------+--------------+------+-----+---------+----------------+
    | Id            | int(11)      | NO   | PRI | NULL    | auto_increment |
    | tracking_id   | int(11)      | YES  |     | NULL    |                |
    | event_type    | varchar(225) | YES  |     | NULL    |                |
    | event_time    | timestamp    | YES  |     | NULL    |                |
    | location_id   | varchar(100) | YES  |     | NULL    |                |
    | voyage_number | varchar(20)  | YES  |     | NULL    |                |
    +---------------+--------------+------+-----+---------+----------------+
    
    Run command -> java -jar trackingms.jar
    

Handling MS
    
    This MS takes care of all the handling operations associated with the Cargo. 
    The MySql Schemas and the Rabbit MQ Exchanges have to be setup (creation and binding) before running this microservice
    
    Server Port -> 8084
    Schema Name -> handlingmsdb (user: handlingmsdb/pw:handlingmsdb)
    Tables ->

    handling_activity
    +-----------------------+--------------+------+-----+---------+----------------+
    | Field                 | Type         | Null | Key | Default | Extra          |
    +-----------------------+--------------+------+-----+---------+----------------+
    | id                    | int(11)      | NO   | PRI | NULL    | auto_increment |
    | event_completion_time | timestamp    | YES  |     | NULL    |                |
    | event_type            | varchar(225) | YES  |     | NULL    |                |
    | booking_id            | varchar(20)  | YES  |     | NULL    |                |
    | voyage_number         | varchar(100) | YES  |     | NULL    |                |
    | location              | varchar(100) | YES  |     | NULL    |                |
    +-----------------------+--------------+------+-----+---------+----------------+
    
    Exchanges/Queues -> 
    
    Exchange (cargotracker.cargohandlings) -> Queue (cargotracker.handlingqueue) -> RoutingKey -> (cargohandlings)
    
    Run command -> java -jar handlingms.jar
    
    JSON Requests (Test via Postman) ->
     
    Cargo Handling (http://localhost:8084/cargohandling)
    --------------------------------------------------
    
    Run in sequence
    
    Recieved at port
    {
	    "bookingId" : "<<BookingId>>",
	    "unLocode" : "CNHKG",
	    "handlingType" : "RECEIVE",
	    "completionTime": "2019-08-23",
	    "voyageNumber" : ""
    }
    
    Loaded onto carrier
    {
	    "bookingId" : "<<BookingId>>",
	    "unLocode" : "CNHKG",
	    "handlingType" : "LOAD",
	    "completionTime": "2019-08-25",
	    "voyageNumber" : "0100S"
    }
    
    Unloaded
    {
	    "bookingId" : "<<BookingId>>",
	    "unLocode" : "CNHGH",
	    "handlingType" : "UNLOAD",
	    "completionTime": "2019-08-28",
	    "voyageNumber" : "0100S"
    }
    
    Loaded onto next carrier
    {
	    "bookingId" : "<<BookingId>>",
	    "unLocode" : "CNHGH",
	    "handlingType" : "LOAD",
	    "completionTime": "2019-09-01",
	    "voyageNumber" : "0101S"
    }
    
    Unloaded
    {
	    "bookingId" : "<<BookingId>>",
	    "unLocode" : "JNTKO",
	    "handlingType" : "UNLOAD",
	    "completionTime": "2019-09-10",
	    "voyageNumber" : "0101S"
    }
    
    Loaded onto next carrier
    {
	    "bookingId" : "<<BookingId>>",
	    "unLocode" : "JNTKO",
	    "handlingType" : "LOAD",
	    "completionTime": "2019-09-15",
	    "voyageNumber" : "0102S"
    }
    
    Unloaded
    {
	    "bookingId" : "<<BookingId>>",
	    "unLocode" : "USNYC",
	    "handlingType" : "UNLOAD",
	    "completionTime": "2019-09-25",
	    "voyageNumber" : "0102S"
    }
    
    Customs
    {
	    "bookingId" : "<<BookingId>>",
	    "unLocode" : "USNYC",
	    "handlingType" : "CUSTOMS",
	    "completionTime": "2019-09-26",
	    "voyageNumber" : ""
    }
    
    Claimed
    {
	    "bookingId" : "<<BookingId>>",
	    "unLocode" : "USNYC",
	    "handlingType" : "CLAIM",
	    "completionTime": "2019-09-28",
	    "voyageNumber" : ""
    }
    
    
     
    
    
