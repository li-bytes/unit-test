package com.test;

import org.junit.Rule;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * @author lichong
 * @date 2021/8/2
 */
@PrepareForTest(User.class)
public class WhenNewTest {

     /*static {
         PowerMockAgent.initializeIfNeeded();
     }*/

    /**
     * 不使用类上的注解 @RunWith(PowerMockRunner.class)，单元测试覆盖率在使用 jacoco 检查时无法计入
     * 使用 @Rule 注解代替
     */
    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Test
    public void testWhenNew() throws Exception {
        Address address = new Address();
        whenNew(Address.class).withNoArguments().thenReturn(address);
        assertEquals(address, new User().getAddress());
    }
}
