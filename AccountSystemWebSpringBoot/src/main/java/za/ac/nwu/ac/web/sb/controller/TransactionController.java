package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.domain.service.Response;
import za.ac.nwu.ac.logic.flow.CreateTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private CreateTransactionFlow createTransactionFlow;
    private FetchTransactionFlow fetchTransactionFlow;

    @Autowired
    public TransactionController(CreateTransactionFlow createTransactionFlow, FetchTransactionFlow fetchTransactionFlow) {
        this.createTransactionFlow = createTransactionFlow;
        this.fetchTransactionFlow = fetchTransactionFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value ="Gets all the configured transactions", notes = "gets a list of all transactions")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Currencies returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)})
    public ResponseEntity<Response<List<TransactionDto>>> getAll() {
        List<TransactionDto> DtoList = fetchTransactionFlow.getAll();
        Response<List<TransactionDto>> response = new Response<>(true,DtoList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
