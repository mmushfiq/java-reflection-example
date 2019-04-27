package az.mm.javareflectionexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author MushfigM on 4/27/2019
 */
@AllArgsConstructor
@Data
public class ProvisioningResponse {
    private String requestId;
    private boolean status;
    private String message;
}
