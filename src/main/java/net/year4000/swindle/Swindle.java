/*
 Copyright (C) 2016 Year4000
 Copyright (C) 2016 ewized

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 */
package net.year4000.swindle;

import net.year4000.utilities.reflection.Gateways;
import net.year4000.utilities.reflection.annotations.Getter;
import net.year4000.utilities.reflection.annotations.Invoke;
import net.year4000.utilities.reflection.annotations.Proxied;
import net.year4000.utilities.sponge.protocol.Packets;

/** The main interface to allow for external plugins in interact with swindles internals */
@Proxied("net.year4000.swindle.plugin.Swindle")
public interface Swindle {

    /** Get the instance of Swindle plugin */
    static Swindle get() {
        return Gateways.proxy(Swindle.class, net.year4000.swindle.plugin.Swindle.get());
    }

    /** Is the plugin in debug mode, when enabled hidden features and debug messages */
    static boolean isDebug() {
        return System.getProperty("swindle.debug") != null;
    }

    /** Log messages to the screen */
    @Invoke
    void log(Object object, Object... args);

    /** Debug messages to the screen */
    @Invoke
    void debug(Object object, Object... args);

    /** Get the instance of the packets manager module */
    @Getter
    Packets packets();
}