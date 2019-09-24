package com.practicalddd.cargotracker.bookingms.interfaces.rest;

import com.practicalddd.cargotracker.bookingms.application.internal.commandservices.CargoBookingCommandService;
import com.practicalddd.cargotracker.bookingms.application.internal.queryservices.CargoBookingQueryService;
import com.practicalddd.cargotracker.bookingms.domain.model.aggregates.BookingId;
import com.practicalddd.cargotracker.bookingms.domain.model.aggregates.Cargo;
import com.practicalddd.cargotracker.bookingms.interfaces.rest.dto.BookCargoResource;
import com.practicalddd.cargotracker.bookingms.interfaces.rest.dto.RouteCargoResource;
import com.practicalddd.cargotracker.bookingms.interfaces.rest.transform.BookCargoCommandDTOAssembler;
import com.practicalddd.cargotracker.bookingms.interfaces.rest.transform.RouteCargoCommandDTOAssembler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@RequestMapping("/cargorouting")
public class CargoRoutingController {

    private CargoBookingCommandService cargoBookingCommandService; // Application Service Dependency


    /**
     * Provide the dependencies
     * @param cargoBookingCommandService
     */
    public CargoRoutingController(CargoBookingCommandService cargoBookingCommandService){
        this.cargoBookingCommandService = cargoBookingCommandService;
    }


    /**
     * POST method to route a cargo
     * @param routeCargoResource
     */
    @PostMapping
    @ResponseBody
    public BookingId routeCargo(@RequestBody RouteCargoResource routeCargoResource){
        cargoBookingCommandService.assignRouteToCargo(
                RouteCargoCommandDTOAssembler
                        .toCommandFromDTO(routeCargoResource));

        BookingId bookingId = new BookingId(routeCargoResource.getBookingId());
        return bookingId;
    }
}
