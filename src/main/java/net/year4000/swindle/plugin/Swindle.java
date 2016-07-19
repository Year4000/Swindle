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
package net.year4000.swindle.plugin;

import com.google.inject.Inject;
import net.year4000.utilities.sponge.protocol.Packets;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import net.year4000.utilities.sponge.AbstractSpongePlugin;
import org.spongepowered.api.service.ServiceManager;

import static net.year4000.swindle.Swindle.isDebug;

@Plugin(
    id = "swindle",
    description = "An anti cheat system for sponge",
    authors = {"ewized"},
    dependencies = {@Dependency(id = "utilities")}
)
public final class Swindle extends AbstractSpongePlugin {
    private Packets packets; // once enabled have access to utilities packets manger module

    @Inject
    private ServiceManager serviceManager;

    /** Get the current instance of swindle*/
    public static Swindle get() {
        return instance(Swindle.class);
    }

    /** Log messages to the screen */
    static void log(Object object, Object... args) {
        log(get(), object, args);
    }

    /** Debug messages to the screen */
    static void debug(Object object, Object... args) {
        if (isDebug()) {
            debug(get(), object, args);
        }
    }

    @Listener
    public void enable(GameInitializationEvent event) {
        packets = Packets.manager();
        serviceManager.setProvider(this, net.year4000.swindle.Swindle.class, net.year4000.swindle.Swindle.get());
    }
}
