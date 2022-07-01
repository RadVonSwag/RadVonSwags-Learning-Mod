package net.radslearning.Main.util;

import net.minecraft.util.SignType;
import net.radslearning.Main.mixin.SignTypeAccessor;

public class RadsSignType {

    public static final SignType LEMON_WOOD = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("lemon_wood"));
    public static final SignType LIME_WOOD = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("lime_wood"));

}
