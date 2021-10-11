package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.CurrencyDto;
import za.ac.nwu.ac.domain.service.Response;
import za.ac.nwu.ac.logic.flow.CreateAccountFlow;
import za.ac.nwu.ac.logic.flow.CreateCurrencyFlow;
import za.ac.nwu.ac.logic.flow.FetchCurrencyFLow;

import java.util.List;

@RestController
@RequestMapping("currency")
public class CurrencyController {
    private final FetchCurrencyFLow fetchCurrencyFLow;
    private final CreateCurrencyFlow createCurrencyFlow;

    @Autowired
    public CurrencyController(FetchCurrencyFLow fetchCurrencyFLow, CreateAccountFlow createAccountFlow, CreateCurrencyFlow createCurrencyFlow) {
        this.fetchCurrencyFLow = fetchCurrencyFLow;
        this.createCurrencyFlow = createCurrencyFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value ="Gets all the configured currencies", notes = "gets a list of all accounts")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Currencies returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)})
    public ResponseEntity<Response<List<CurrencyDto>>> getAll() {
        List<CurrencyDto> currencyDtoList = fetchCurrencyFLow.GetAllCurrencies();
        Response<List<CurrencyDto>> response = new Response<>(true,currencyDtoList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Creates a new currency", notes = "Creates new currency")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = " Created currency YAY", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)
    })
    public ResponseEntity<Response<CurrencyDto>> create(
            @ApiParam(value = "RequestBody to create new Currency", required = true)
            @RequestBody CurrencyDto currencyDto){
        CurrencyDto currencyResponse = createCurrencyFlow.CreateCurrency(currencyDto);
        Response<CurrencyDto> response = new Response<>(true,currencyResponse);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("{symbol}")
    @ApiOperation(value = "Retrieves currency based on symbol", notes = "returns currency")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Currencies returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)})
    public ResponseEntity<Response<CurrencyDto>> fetchFromSymbol(
            @ApiParam(value = "The symbol that represents a currency",
            example = "R",
            name="symbol",
            required = true)
            @PathVariable("symbol") final String symbol){
        CurrencyDto currencyDto = this.fetchCurrencyFLow.FetchCurrencyBySymbol(symbol);
        Response<CurrencyDto> response = new Response<>(true,currencyDto);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
