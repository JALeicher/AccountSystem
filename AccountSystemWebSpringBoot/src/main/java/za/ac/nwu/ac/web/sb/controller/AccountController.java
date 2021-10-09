package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.nwu.ac.domain.dto.CurrencyDto;
import za.ac.nwu.ac.domain.service.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.logic.flow.CreateAccountFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountFlow;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    private final CreateAccountFlow createAccountFlow;
    private final FetchAccountFlow fetchAccountFlow;

    @Autowired
    public AccountController(CreateAccountFlow accountFlow, FetchAccountFlow fetchAccountFlow) {
        this.createAccountFlow = accountFlow;
        this.fetchAccountFlow = fetchAccountFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value ="Gets all the configured accounts", notes = "gets a list of all accounts")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Currencies returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)})
    public ResponseEntity<Response<List<AccountDto>>> getAll() {
        List<AccountDto> DtoList = fetchAccountFlow.GetAllAccounts();
        Response<List<AccountDto>> response = new Response<>(true,DtoList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Creates a new account", notes = "Creates new account")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = " Created account YAY", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)
    })
    public ResponseEntity<Response<AccountDto>> create(
            @ApiParam(value = "RequestBody to create new account", required = true)
            @RequestBody AccountDto accountDto){
        AccountDto accountResponse = createAccountFlow.CreateAccount(accountDto);
        Response<AccountDto> response = new Response<>(true,accountResponse);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
