package newssite.controller;

import newssite.payload.ApiResponse;
import newssite.payload.RoleDto;
import newssite.service.LavozimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/lavozim")
public class RoleController {

    @Autowired
    LavozimService lavozimService;

    @PreAuthorize(value = "hasAnyAuthority('ADD_USER')")
    @PostMapping()
    public HttpEntity<?> registerUser(@Valid @RequestBody RoleDto roleDto) {
        ApiResponse apiResponse = lavozimService.addlavozim(roleDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}
