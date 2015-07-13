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
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/**
 * java wrapper around #include <sys/time.h>
 */
//@Includes({"<sys/time.h>"})
public interface Time extends Library {

    Time INSTANCE = (Time) Native.loadLibrary("RTLD",
            Time.class);

    /**
     *
     * struct timeval { time_t tv_sec; // seconds since Jan. 1, 1970 suseconds_t
     * tv_usec; // and microseconds };
     */
    public final static class timeval extends Structure {

        public long tv_sec;  // seconds since Jan. 1, 1970  (really an unsigned int)
        public long tv_usec; // microseconds, (really an unsigned int)

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("tv_sec", "tv_usec");
        }

    }

}