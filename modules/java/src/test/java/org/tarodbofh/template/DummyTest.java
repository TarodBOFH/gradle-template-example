package org.tarodbofh.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;


class DummyTest {

    @Test
    @Disabled("Allowing kotlin module dependency to build on root project build")
    public void thisTestShouldFail() {
        fail("This test should fail");
    }
}
