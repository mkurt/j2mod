package com.ghgande.j2mod.modbus;

public class ModbusRetryException extends ModbusException {

    private static final long serialVersionUID = 1L;

    public ModbusRetryException() {
    }

    public ModbusRetryException(String message) {
        super(message);
    }

    public ModbusRetryException(String message, Object... values) {
        super(message, values);
    }

    public ModbusRetryException(String message, Throwable cause) {
        super(message, cause);
    }
}