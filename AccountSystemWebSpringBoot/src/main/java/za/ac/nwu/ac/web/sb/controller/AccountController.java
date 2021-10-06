package za.ac.nwu.ac.web.sb.controller;


import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.Response;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("AccountType")
public class AccountController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    @Autowired
    public AccountController(FetchAccountTypeFlow accountTypeFlow){
        this.fetchAccountTypeFlow =accountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value ="Gets all the configured account types", notes = "gets a list of all account types")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Account types returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Response.class)})
    public ResponseEntity<Response<String>> getAll(){
        Response<String> response = new Response<String>(true,"no types found");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
