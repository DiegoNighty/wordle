package com.github.diegonighty.wordle.packets;

import com.github.diegonighty.wordle.packets.intercept.Interceptors;
import com.github.diegonighty.wordle.packets.intercept.PacketInterceptor;
import net.minecraft.server.v1_16_R3.PacketPlayInWindowClick;
import org.bukkit.entity.Player;

import java.util.concurrent.Executor;

public class KeyboardInterceptor1_16_5_R0_1 implements PacketInterceptor<PacketPlayInWindowClick> {

	private final Executor bukkitExecutor;

	public KeyboardInterceptor1_16_5_R0_1(Executor bukkitExecutor) {
		this.bukkitExecutor = bukkitExecutor;
	}

	@Override
	public PacketPlayInWindowClick in(Player player, PacketPlayInWindowClick packet) {
		return Interceptors.handleWindowUpdate(
				bukkitExecutor,
				player,
				player.getOpenInventory(),
				packet.c()
		) ? null : packet;
	}
}

