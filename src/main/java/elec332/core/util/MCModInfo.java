package elec332.core.util;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class MCModInfo {

	public static void CreateMCModInfo(FMLPreInitializationEvent event, String modid, String name, String version, String credits, String desc, String url, String logo, String[] authors)
	{
		ModMetadata meta = event.getModMetadata();
		meta.autogenerated = false;
		meta.modId = modid;
		meta.name = name;
		meta.version = version;
		meta.credits = credits;
		meta.description = desc;
		meta.url = url;
		meta.logoFile = logo;
		meta.authorList = Lists.newArrayList(authors);
	}
}
