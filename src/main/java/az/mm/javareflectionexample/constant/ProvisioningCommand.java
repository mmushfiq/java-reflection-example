package az.mm.javareflectionexample.constant;

/**
 * @author MushfigM on 4/27/2019
 */
public enum ProvisioningCommand {
    INIT_SERVICE("initService"),
    OPEN_SERVICE("openService"),
    CLOSE_SERVICE("closeService"),
    CHANGE_SERVICE("changeService"),
    UPDATE_ACCOUNT("updateAccount"),
    REMOVE_ACCOUNT("removeAccount"),
    OPEN_VAS("openVAS"),
    CLOSE_VAS("closeVAS"),
    CREATE_NAS("createNas"),
    UPDATE_NAS("updateNas"),
    CREATE_ATTRIBUTE("createAttribute"),
    UPDATE_ATTRIBUTE("updateAttribute"),
    CREATE_SERVICE_PROFILE("createServiceProfile"),
    UPDATE_SERVICE_PROFILE("updateServiceProfile"),
    DISCONNECT("disconnect");

    private final String methodname;
    ProvisioningCommand(final String methodName){
        this.methodname = methodName;
    }

    public String getMethodName(){
        return this.methodname;
    }
}
