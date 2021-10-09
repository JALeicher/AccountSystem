package za.ac.nwu.ac.web.sb.controller;


import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.Response;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("account-type")
public class AccountController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;

    @Autowired
    public AccountController(FetchAccountTypeFlow accountTypeFlow, CreateAccountTypeFlow createAccountTypeFlow){
        this.fetchAccountTypeFlow =accountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value ="Gets all the configured account types", notes = "gets a list of all account types")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Account types returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)})
    public ResponseEntity<Response<List<AccountTypeDto>>> getAll(){
        List<AccountTypeDto> accountTypeDtoList = fetchAccountTypeFlow.getAllAccountTypes();
        Response<List<AccountTypeDto>> response = new Response<List<AccountTypeDto>>(true,accountTypeDtoList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Creates a new Account Type", notes = "Whatever")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "AccountType Created YAY", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)
    })
    public ResponseEntity<Response<AccountTypeDto>> CreateAccountType(
            @ApiParam(value = "Requestbody to create new AccountType", required = true)
            @RequestBody AccountTypeDto accountTypeDto){
        AccountTypeDto accountResponse = createAccountTypeFlow.CreateAccountType(accountTypeDto);
        Response<AccountTypeDto> response = new Response<>(true,accountResponse);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("{date}")
    @ApiOperation(value = "Creates a new Account Type", notes = "Whatever")
    @ApiResponses(value ={
            @ApiResponse(code = 201, message = "AccountType Created YAY", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Resource not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)
    })
    public ResponseEntity<Response<List<AccountTypeDto>>> FetchByDate(
            @ApiParam(value = "The date on which the account types were created",
            example = "2020-01-01",
            name="date",
            required = true)
            @PathVariable("date") final String date){
        List<AccountTypeDto> accountTypeDtoList = fetchAccountTypeFlow.getAllAccountTypesByDate(date);
        Response<List<AccountTypeDto>> response = new Response<>(true,accountTypeDtoList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    };
}
