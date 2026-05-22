/*
 * Copyright 2002-2016 jamod & j2mod development teams
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ghgande.j2mod.modbus;

/**
 * Thrown when a CRC mismatch is detected on an RTU-over-TCP read.
 * The underlying TCP connection is still healthy; only the payload was corrupted.
 * Callers should retry without closing the connection.
 */
public class ModbusCrcException extends ModbusIOException {

    private static final long serialVersionUID = 1L;

    public ModbusCrcException(String message) {
        super(message);
    }
}
