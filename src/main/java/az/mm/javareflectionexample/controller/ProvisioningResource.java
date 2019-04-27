package az.mm.javareflectionexample.controller;

import az.mm.javareflectionexample.model.ProvisioningRequest;
import az.mm.javareflectionexample.model.ProvisioningResponse;
import az.mm.javareflectionexample.service.ProvisioningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;


/**
 * @author MushfigM on 4/27/2019
 */
@RestController
@RequestMapping("/api")
public class ProvisioningResource {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ProvisioningService provisioningService;

    public ProvisioningResource(ProvisioningService provisioningService){
        this.provisioningService = provisioningService;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/provisioning")
    public ResponseEntity<ProvisioningResponse> startProvisioning(@Valid @RequestBody ProvisioningRequest request) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        log.debug("New provisioning REST request accepted: {}", request);
        ProvisioningResponse response = provisioningService.startProvisioning(request);
        return ResponseEntity.ok(response);
    }

}
