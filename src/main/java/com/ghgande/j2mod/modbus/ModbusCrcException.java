package com.ghgande.j2mod.modbus;

public class ModbusCrcException extends ModbusIOException {

    private static final long serialVersionUID = 1L;

    public ModbusCrcException() {
    }

    public ModbusCrcException(String message) {
        super(message);
    }

    public ModbusCrcException(String message, Object... values) {
        super(message, values);
    }

    public ModbusCrcException(String message, Throwable cause) {
        super(message, cause);
    }
}