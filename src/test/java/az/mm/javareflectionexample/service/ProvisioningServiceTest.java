package az.mm.javareflectionexample.service;

import az.mm.javareflectionexample.constant.ProvisioningCommand;
import az.mm.javareflectionexample.model.ProvisioningRequest;
import az.mm.javareflectionexample.model.ProvisioningResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

/**
 * @author MushfigM on 4/27/2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvisioningServiceTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProvisioningService provisioningService;

    @Before
    public void setUp() throws Exception {
        log.debug("Test starts for provisioning..");
    }

    @After
    public void tearDown() throws Exception {
        log.debug("Test ends for provisioning..");
    }

    @Test
    public void startProvisioning() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ProvisioningRequest request = new ProvisioningRequest("654", 111111, ProvisioningCommand.CHANGE_SERVICE);
        ProvisioningResponse response = provisioningService.startProvisioning(request);
        log.debug("response: {}", response);
        assertEquals(request.getRequestId(), response.getRequestId());
        assertTrue("Status should be true", response.isStatus());
        assertThat(response.getMessage(), containsString("changeService()"));
    }
}