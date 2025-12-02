package com.tom.cpm.client;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;

import com.mojang.blaze3d.platform.InputConstants;
import com.tom.cpl.gui.IKeybind;
import com.tom.cpl.gui.KeyboardEvent;

public class KeyBindings implements IKeybind {
	public static KeyMapping gestureMenuBinding, renderToggleBinding;
	public static IKeybind[] quickAccess = new IKeybind[IKeybind.QUICK_ACCESS_KEYBINDS_COUNT];
	public static List<IKeybind> kbs = new ArrayList<>();

	static {
		gestureMenuBinding = new KeyMapping("key.cpm.gestureMenu", KeyConflictContext.IN_GAME,
				InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_UNKNOWN), "key.cpm.category");
		renderToggleBinding = new KeyMapping("key.cpm.renderToggle", KeyConflictContext.IN_GAME, InputConstants.UNKNOWN,
				"key.cpm.category");

		// Initialize quickAccess with dummy IKeybinds to prevent NPE if accessed
		for (int i = 0; i < quickAccess.length; i++) {
			KeyBindings kb = new KeyBindings();
			quickAccess[i] = kb;
		}

		// Add main bindings to kbs
		kbs.add(new KeyBindings()); // gestureMenu
		kbs.add(new KeyBindings()); // renderToggle

		// Add quick access to kbs
		for (IKeybind kb : quickAccess) {
			kbs.add(kb);
		}
	}

	private KeyBindings() {
	} // Private constructor for dummy instances

	public static void init(RegisterKeyMappingsEvent evt) {
	}

	@Override
	public boolean isPressed(KeyboardEvent evt) {
		return false;
	}

	@Override
	public String getBoundKey() {
		return "";
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public boolean isPressed() {
		return false;
	}
}
