package az.mm.javareflectionexample.engine;

import az.mm.javareflectionexample.model.ProvisioningRequest;
import az.mm.javareflectionexample.model.ProvisioningResponse;

/**
 * @author MushfigM on 4/27/2019
 */
public class Provider2Provisioner implements ProvisioningEngine {

    private static volatile Provider2Provisioner instance;

    private Provider2Provisioner(){}

    public static Provider2Provisioner getInstance() {
        if (instance == null)
            synchronized (Provider2Provisioner.class) {
                if (instance == null) instance = new Provider2Provisioner();
            }
        return instance;
    }

    @Override
    public ProvisioningResponse initService(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("initService()"));
    }

    @Override
    public ProvisioningResponse openService(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("openService()"));
    }

    @Override
    public ProvisioningResponse closeService(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("closeService()"));
    }

    @Override
    public ProvisioningResponse changeService(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("changeService()"));
    }

    @Override
    public ProvisioningResponse updateAccount(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("updateAccount()"));
    }

    @Override
    public ProvisioningResponse removeAccount(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("removeAccount()"));
    }

    @Override
    public ProvisioningResponse openVAS(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("openVAS()"));
    }

    @Override
    public ProvisioningResponse closeVAS(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("closeVAS()"));
    }

    @Override
    public ProvisioningResponse createNas(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("createNas()"));
    }

    @Override
    public ProvisioningResponse updateNas(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("updateNas()"));
    }

    @Override
    public ProvisioningResponse createAttribute(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("createAttribute()"));
    }

    @Override
    public ProvisioningResponse updateAttribute(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("updateAttribute()"));
    }

    @Override
    public ProvisioningResponse createServiceProfile(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("createServiceProfile()"));
    }

    @Override
    public ProvisioningResponse updateServiceProfile(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("updateServiceProfile()"));
    }

    @Override
    public ProvisioningResponse disconnect(ProvisioningRequest request) {
        return new ProvisioningResponse(request.getRequestId(), true, getMessage("disconnect()"));
    }

    private String getMessage(String methodName){
        return methodName + " method invoked and completed successfully!";
    }
}
