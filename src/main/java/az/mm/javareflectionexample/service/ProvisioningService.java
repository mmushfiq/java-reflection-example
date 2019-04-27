package az.mm.javareflectionexample.service;

import az.mm.javareflectionexample.constant.ProvisioningCommand;
import az.mm.javareflectionexample.engine.Provider1Provisioner;
import az.mm.javareflectionexample.engine.Provider2Provisioner;
import az.mm.javareflectionexample.engine.ProvisioningEngine;
import az.mm.javareflectionexample.model.ProvisioningRequest;
import az.mm.javareflectionexample.model.ProvisioningResponse;
import org.springframework.stereotype.Service;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author MushfigM on 4/27/2019
 */
@Service
public class ProvisioningService {


    public ProvisioningResponse startProvisioning(ProvisioningRequest request) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        ProvisioningEngine provisioner = getCurrentProvisioner(request.getProviderId());
        if (provisioner == null)
            throw new IllegalArgumentException("Wrong provider id: "+request.getProviderId());

        ProvisioningCommand command = request.getProvisioningCommand();

        /*
        switch (command){
            case INIT_SERVICE:
                return provisioner.initService(request);
            case OPEN_SERVICE:
                return provisioner.openService(request);
            case CLOSE_SERVICE:
                return provisioner.closeService(request);
            case CHANGE_SERVICE:
                return provisioner.changeService(request);
            case UPDATE_ACCOUNT:
                return  provisioner.updateAccount(request);
            case REMOVE_ACCOUNT:
                return provisioner.removeAccount(request);
            case OPEN_VAS:
                return provisioner.openVAS(request);
            case CLOSE_VAS:
                return provisioner.closeVAS(request);
            case CREATE_NAS:
                return  provisioner.createNas(request);
            case UPDATE_NAS:
                return  provisioner.updateNas(request);
            case CREATE_ATTRIBUTE:
                return provisioner.createAttribute(request);
            case UPDATE_ATTRIBUTE:
                return provisioner.updateAttribute(request);
            case CREATE_SERVICE_PROFILE:
                return provisioner.createServiceProfile(request);
            case UPDATE_SERVICE_PROFILE:
                return provisioner.updateServiceProfile(request);
            case DISCONNECT:
                return provisioner.disconnect(request);

             //   ...other commands..

            default: throw new IllegalArgumentException("UNSUPPORTED COMMAND!");
        }
        */

        Method callingMethod = ProvisioningEngine.class.getDeclaredMethod(command.getMethodName(), ProvisioningRequest.class);
        ProvisioningResponse provisioningResponse = (ProvisioningResponse) callingMethod.invoke(provisioner, request);

        return provisioningResponse;
    }

    public ProvisioningEngine getCurrentProvisioner(int id){
        return  id == 111111 ? Provider1Provisioner.getInstance() :
                id == 222222 ? Provider2Provisioner.getInstance() :
                null;
    }
}
