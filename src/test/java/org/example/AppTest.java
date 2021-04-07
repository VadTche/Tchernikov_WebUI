package org.example;

//import org.junit.Assert;
//import org.junit.Test;

import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        AbstractBooleanAssert<?> abstractBooleanAssert = Assertions.assertThat(true);
    }

  }
