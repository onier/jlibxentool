/*
 * Copyright 2004-2008 Sun Microsystems, Inc. All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2
 * only, as published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License version 2 for more details (a copy is
 * included in the LICENSE file that accompanied this code).
 *
 * You should have received a copy of the GNU General Public License
 * version 2 along with this work; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA
 *
 * Please contact Sun Microsystems, Inc., 16 Network Circle, Menlo
 * Park, CA 94025 or visit www.sun.com if you need additional
 * information or have any questions.
 */
package org.linux.libc;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import java.util.Arrays;
import java.util.List;

/**
 *
 * java wrapper around #include <netdb.h>
 */
//@Includes("<netdb.h>")
public interface NetDB extends Library {

    NetDB INSTANCE = (NetDB) Native.loadLibrary("RTLD",
            NetDB.class);

    /**
     * The gethostbyname() function returns a HostEnt structure describing an
     * internet host referenced by name.
     *
     * @param name the host name
     * @return the address of struct hostent, or null on error
     */
    public hostent gethostbyname(String name);

//    /** Authoritative Answer Host not found. 
//     * @see #h_errno() */
//    int HOST_NOT_FOUND = IMPORT;
//    /** Non-Authoritative Host not found, or SERVERFAIL. 
//     * @see #h_errno() */
//    int TRY_AGAIN = IMPORT;
//    /** Non recoverable errors, FORMERR, REFUSED, NOTIMP. 
//     * @see #h_errno() */
//    int NO_RECOVERY = IMPORT;
//    /** Valid name, no data record of requested type.
//     * @see #h_errno() */
//    int NO_DATA = IMPORT;
    /**
     * Return error code for last call to gethostbyname() or gethostbyaddr().
     *
     * @return one of the error codes defined in this class.
     */
//    @GlobalVar
    public int h_errno();

    /**
     * C STRUCTURE HostEnt struct hostent { char *h_name; official name of host
     * char **h_aliases; alias list int h_addrtype; host address type int
     * h_length; length of address char **h_addr_list; list of addresses from
     * name server }; #define h_addr h_addr_list[0] address, for backward
     * compatibility
     */
    public static class hostent extends Structure {

        /**
         * Official name of host.
         */
        public Pointer h_name;
        /**
         * Alias list.
         */
        public PointerByReference h_aliases;
        /**
         * Host address type.
         */
        public int h_addrtype;
        /**
         * Length of address.
         */
        public int h_length;
        /**
         * List of addresses from name server.
         */
        public PointerByReference h_addr_list;

        public hostent() {
            super();
        }

        protected List<?> getFieldOrder() {
            return Arrays.asList("h_name", "h_aliases", "h_addrtype", "h_length", "h_addr_list");
        }

        public hostent(Pointer h_name, PointerByReference h_aliases, int h_addrtype, int h_length, PointerByReference h_addr_list) {
            super();
            this.h_name = h_name;
            this.h_aliases = h_aliases;
            this.h_addrtype = h_addrtype;
            this.h_length = h_length;
            this.h_addr_list = h_addr_list;
        }

        public hostent(Pointer peer) {
            super(peer);
        }

        public static class ByReference extends hostent implements Structure.ByReference {

        };

        public static class ByValue extends hostent implements Structure.ByValue {

        };
    };
}
