package com.ghgande.j2mod.modbus;

public class ModbusTimeoutException extends ModbusIOException {

    private static final long serialVersionUID = 1L;

    public ModbusTimeoutException() {
    }

    public ModbusTimeoutException(String message) {
        super(message);
    }

    public ModbusTimeoutException(String message, Object... values) {
        super(message, values);
    }

    public ModbusTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }
}
