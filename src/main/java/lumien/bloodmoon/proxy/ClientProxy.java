package lumien.bloodmoon.proxy;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import lumien.bloodmoon.client.ClientBloodmoonHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		MinecraftForge.EVENT_BUS.register(ClientBloodmoonHandler.INSTANCE);
	}

	@Override
	public boolean isBloodmoon() {
		return ClientBloodmoonHandler.INSTANCE.isBloodmoonActive();
	}

	@Override
	public boolean canColorMoon() {
		try {
			return Display.isCurrent();
		} catch (LWJGLException e) {
			return false;
		}
	}
}
