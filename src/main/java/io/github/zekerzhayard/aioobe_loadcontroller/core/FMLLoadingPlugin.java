package io.github.zekerzhayard.aioobe_loadcontroller.core;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.TransformerExclusions("io.github.zekerzhayard.aioobe_loadcontroller.core.")
public class FMLLoadingPlugin implements IFMLLoadingPlugin {
    static {
        try {
            Method addURLMethod = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addURLMethod.setAccessible(true);
            addURLMethod.invoke(ClassLoader.getSystemClassLoader(), FMLLoadingPlugin.class.getProtectionDomain().getCodeSource().getLocation());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[] { "io.github.zekerzhayard.aioobe_loadcontroller.core.ClassTransformer" };
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
