package net.codetojoy

import com.lesfurets.jenkins.unit.BasePipelineTest

import org.junit.*;
import static org.junit.Assert.*;

class TestExampleJob extends BasePipelineTest {
    @Override
    @Before
    void setUp() {
        super.setUp()
        // Assigns false to a job parameter ENABLE_TEST_STAGE
        addParam('ENABLE_TEST_STAGE', 'false')
        // Defines the previous execution status
        binding.getVariable('currentBuild').previousBuild = [result: 'UNSTABLE']
    }

    @Test
    void verifyParam() {
        assertEquals('false', binding.getVariable('params')['ENABLE_TEST_STAGE'])
    }
}
