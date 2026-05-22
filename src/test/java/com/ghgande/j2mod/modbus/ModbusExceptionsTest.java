package com.ghgande.j2mod.modbus;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModbusExceptionsTest {

    @Test
    public void testModbusException() {
        Assert.assertNotNull("Instantiation of ModbusException() failed.", new ModbusException());
        ModbusException modbusEx1 = new ModbusException("TEST1");
        Assert.assertEquals("Exception message incorrect return.", "TEST1", modbusEx1.getMessage());
        ModbusException modbusEx2 = new ModbusException("TEST2", modbusEx1);
        Assert.assertEquals("Exception message incorrect.", "TEST2", modbusEx2.getMessage());
        Assert.assertEquals("Exception cause incorrect.", modbusEx1, modbusEx2.getCause());
        ModbusException modbusEx3 = new ModbusException("TEST %s %d", "with string formatter", 68);
        Assert.assertEquals("Exception message incorrect.", "TEST with string formatter 68", modbusEx3.getMessage());
    }

    @Test
    public void testModbusIOException() {
        Assert.assertNotNull("Instantiation of ModbusIOException() failed.", new ModbusIOException());
        ModbusIOException modbusEx1 = new ModbusIOException("TEST1");
        Assert.assertEquals("Exception message incorrect return.", "TEST1", modbusEx1.getMessage());
        ModbusIOException modbusEx2 = new ModbusIOException("TEST2", modbusEx1);
        Assert.assertEquals("Exception message incorrect.", "TEST2", modbusEx2.getMessage());
        Assert.assertEquals("Exception cause incorrect.", modbusEx1, modbusEx2.getCause());
        ModbusIOException modbusEx3 = new ModbusIOException("TEST %s %d", "with string formatter", 68);
        Assert.assertEquals("Exception message incorrect.", "TEST with string formatter 68", modbusEx3.getMessage());

        ModbusIOException modbusEx4 = new ModbusIOException(true);
        Assert.assertTrue("IO Exception should be at EOF.", modbusEx4.isEOF());
        modbusEx4.setEOF(false);
        Assert.assertFalse("IO Exception should not be at EOF.", modbusEx4.isEOF());
    }

    @Test
    public void testModbusCrcException() {
        ModbusCrcException ex = new ModbusCrcException("CRC mismatch");
        assertEquals("CRC mismatch", ex.getMessage());
        assertTrue("ModbusCrcException must be a ModbusIOException", ex instanceof ModbusIOException);
        assertTrue("ModbusCrcException must be a ModbusException", ex instanceof ModbusException);
    }

    @Test
    public void testModbusTimeoutException() {
        ModbusTimeoutException ex = new ModbusTimeoutException("timeout");
        assertEquals("timeout", ex.getMessage());
        assertTrue("ModbusTimeoutException must be a ModbusIOException", ex instanceof ModbusIOException);
        assertTrue("ModbusTimeoutException must be a ModbusException", ex instanceof ModbusException);
    }

    @Test
    public void testModbusRetryException() {
        ModbusRetryException ex = new ModbusRetryException("failed after %d tries", 3);
        assertEquals("failed after 3 tries", ex.getMessage());
        assertTrue("ModbusRetryException must be a ModbusException", ex instanceof ModbusException);
        assertFalse("ModbusRetryException must NOT be a ModbusIOException", ((Exception) ex) instanceof ModbusIOException);
    }

    @Test
    public void testModbusSlaveException() {
        for (int i = 0; i < 20; i++) {
            ModbusSlaveException modbusEx = new ModbusSlaveException(i);
            Assert.assertEquals("Incorrect type for " + i, i, modbusEx.getType());
            Assert.assertEquals("Incorrect type string for " + i,
                    ModbusSlaveException.getMessage(i), modbusEx.getMessage());
            Assert.assertTrue("Incorrect type check for " + i, modbusEx.isType(i));
            Assert.assertFalse("Incorrect negative type check for " + i, modbusEx.isType(-1));
        }
    }
}
