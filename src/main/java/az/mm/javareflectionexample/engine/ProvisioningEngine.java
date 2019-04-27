package az.mm.javareflectionexample.engine;

import az.mm.javareflectionexample.model.ProvisioningRequest;
import az.mm.javareflectionexample.model.ProvisioningResponse;

/**
 * @author MushfigM on 4/27/2019
 */
public interface ProvisioningEngine {

    ProvisioningResponse initService(ProvisioningRequest request);

    ProvisioningResponse openService(ProvisioningRequest request);

    ProvisioningResponse closeService(ProvisioningRequest request);

    ProvisioningResponse changeService(ProvisioningRequest request);

    ProvisioningResponse updateAccount(ProvisioningRequest request);

    ProvisioningResponse removeAccount(ProvisioningRequest request);

    ProvisioningResponse openVAS(ProvisioningRequest request);

    ProvisioningResponse closeVAS(ProvisioningRequest request);

    ProvisioningResponse createNas(ProvisioningRequest request);

    ProvisioningResponse updateNas(ProvisioningRequest request);

    ProvisioningResponse createAttribute(ProvisioningRequest request);

    ProvisioningResponse updateAttribute(ProvisioningRequest request);

    ProvisioningResponse createServiceProfile(ProvisioningRequest request);

    ProvisioningResponse updateServiceProfile(ProvisioningRequest request);

    ProvisioningResponse disconnect(ProvisioningRequest request);

    //some other methods..

}
