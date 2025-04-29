package com.r3signed.overrides.core.restrictions;

import net.minecraft.text.Text;

public abstract class Restriction<T> {
    /**
     * @return The permission string that this restriction checks for
     */
    public abstract String getPermission();

    /**
     * @return The message that this restriction should display
     */
    public Text getMessage() {
        return Text.of("§cPermission denied.");
    }

    /**
     * Check if the restriction should be applied to the given object.
     *
     * @param object The object to check
     * @return True if the restriction should be applied, otherwise false
     */
    public abstract boolean shouldApply(T object);

    /**
     * Apply the restriction to the given object.
     *
     * @param object The object to apply the restriction to
     */
    public abstract T apply(T object);
}
