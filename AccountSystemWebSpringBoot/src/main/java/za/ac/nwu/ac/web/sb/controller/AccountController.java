package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.nwu.ac.domain.service.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountDto;
import za.ac.nwu.ac.logic.flow.CreateAccountFlow;
import za.ac.nwu.ac.logic.flow.EditAccountFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountFlow;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    private final CreateAccountFlow createAccountFlow;
    private final FetchAccountFlow fetchAccountFlow;
    private final EditAccountFlow editAccountFlow;

    @Autowired
    public AccountController(CreateAccountFlow accountFlow, FetchAccountFlow fetchAccountFlow, EditAccountFlow editAccountFlow) {
        this.createAccountFlow = accountFlow;
        this.fetchAccountFlow = fetchAccountFlow;
        this.editAccountFlow = editAccountFlow;
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
        logger.trace("NEW Account added with email: "+accountResponse.getAccountEMail());
        Response<AccountDto> response = new Response<>(true,accountResponse);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("Id/{id}")
    @ApiOperation(value = "Retrieves account based on id", notes = "returns account")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Account returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)})
    public ResponseEntity<Response<AccountDto>> FetchById(
            @ApiParam(value = "Id for the account",
                    example = "2",
                    name="id",
                    required = true)
            @PathVariable("id") String id){
        Long longId = Long.parseLong(id);
        AccountDto accountDto = this.fetchAccountFlow.FetchById(longId);
        Response<AccountDto> response = new Response<>(true,accountDto);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @GetMapping("Email/{mail}")
    @ApiOperation(value = "Retrieves account based on email", notes = "returns account")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Account returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)})
    public ResponseEntity<Response<AccountDto>> FetchByEMail(
            @ApiParam(value = "E-mail for the account",
                    example = "john.doe@gmaill.com",
                    name="mail",
                    required = true)
            @PathVariable("mail") String mail){
        AccountDto accountDto = this.fetchAccountFlow.FetchByEMail(mail);
        Response<AccountDto> response = new Response<>(true,accountDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(value = "Add/{amount}/to/{id}", method = RequestMethod.POST)
    @ApiOperation(value ="Adds miles to an account", notes = "returns modified account")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Miles added, transaction logged", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)})
    public  ResponseEntity<Response<AccountDto>> AddMiles(
            @ApiParam(value = "Amount of Miles to add", required = true, type = "String")
            @PathVariable("amount") String amount,
            @ApiParam(value = "Id of the account", required = true, type = "String")
            @PathVariable("id")String id){
        Long longId= Long.parseLong(id);
        Integer intAmount = Integer.parseInt(amount);
        AccountDto accountDto = editAccountFlow.AddMiles(longId,intAmount) ;
        logger.trace(accountDto.getAccountFName()+" just added "+intAmount+" MILES");
        Response<AccountDto> response = new Response<>(true,accountDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(value = "Subtract/{amount}/from/{id}", method = RequestMethod.POST)
    @ApiOperation(value ="Subtracts miles from an account", notes = "returns modified account")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Miles subtracted, transaction logged", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)})
    public  ResponseEntity<Response<AccountDto>> SubtractMiles(
            @ApiParam(value = "Amount of Miles to subtract", required = true, type = "String")
            @PathVariable("amount") String amount,
            @ApiParam(value = "Id of the account", required = true, type = "String")
            @PathVariable("id")String id){
        Long longId= Long.parseLong(id);
        Integer intAmount = Integer.parseInt(amount);
        AccountDto accountDto = editAccountFlow.SubMiles(longId,intAmount) ;
        logger.trace(accountDto.getAccountFName()+" just subtracted "+intAmount+" MILES");
        Response<AccountDto> response = new Response<>(true,accountDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }





}
