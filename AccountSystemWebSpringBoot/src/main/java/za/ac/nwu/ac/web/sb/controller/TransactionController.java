package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.dto.TransactionDto;
import za.ac.nwu.ac.domain.service.Response;
import za.ac.nwu.ac.logic.flow.CreateTransactionFlow;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private CreateTransactionFlow createTransactionFlow;

    @Autowired
    public TransactionController(CreateTransactionFlow createTransactionFlow) {
        this.createTransactionFlow = createTransactionFlow;
    }

    @PostMapping("/create")
    @ApiOperation(value = "Creates a new transaction", notes = "Creates new transaction")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = " Created transaction YAY", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)
    })
    public ResponseEntity<Response<TransactionDto>> createTransaction(
            @ApiParam(value = "RequestBody to create new Transaction", required = true)
            @RequestBody TransactionDto transactionDto){
        TransactionDto transResponse = createTransactionFlow.CreateTransaction(transactionDto);
        Response<TransactionDto> response = new Response<>(true,transResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
