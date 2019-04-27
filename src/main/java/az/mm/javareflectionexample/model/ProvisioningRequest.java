package az.mm.javareflectionexample.model;

import az.mm.javareflectionexample.constant.ProvisioningCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author MushfigM on 4/27/2019
 */
@AllArgsConstructor
@Data
public class ProvisioningRequest {
    @NotBlank
    private String requestId;
    @NotNull
    private int providerId;
    @NotNull
    private ProvisioningCommand provisioningCommand;
}
