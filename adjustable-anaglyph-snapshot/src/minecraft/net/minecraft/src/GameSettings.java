package net.minecraft.src;

import java.io.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class GameSettings
{
    private static final String RENDER_DISTANCES[] =
    {
        "options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"
    };
    private static final String DIFFICULTIES[] =
    {
        "options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"
    };
    private static final String GUISCALES[] =
    {
        "options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"
    };
    private static final String field_55387_ab[] =
    {
        "options.chat.visibility.full", "options.chat.visibility.system", "options.chat.visibility.hidden"
    };
    private static final String PARTICLES[] =
    {
        "options.particles.all", "options.particles.decreased", "options.particles.minimal"
    };
    private static final String LIMIT_FRAMERATES[] =
    {
        "performance.max", "performance.balanced", "performance.powersaver"
    };
    public float musicVolume;
    public float soundVolume;
    public float mouseSensitivity;
    public boolean invertMouse;
    public int renderDistance;
    public boolean viewBobbing;
    public boolean anaglyph;

    /** Advanced OpenGL */
    public boolean advancedOpengl;
    public int limitFramerate;
    public boolean fancyGraphics;

    /** Smooth Lighting */
    public boolean ambientOcclusion;

    /** Clouds flag */
    public boolean clouds;

    /** The name of the selected texture pack. */
    public String skin;
    public int field_55382_n;
    public boolean field_55383_o;
    public boolean field_55386_p;
    public boolean field_55385_q;
    public float field_55384_r;
    public boolean field_57427_s;
    public KeyBinding keyBindForward;
    public KeyBinding keyBindLeft;
    public KeyBinding keyBindBack;
    public KeyBinding keyBindRight;
    public KeyBinding keyBindJump;
    public KeyBinding keyBindInventory;
    public KeyBinding keyBindDrop;
    public KeyBinding keyBindChat;
    public KeyBinding keyBindSneak;
    public KeyBinding keyBindAttack;
    public KeyBinding keyBindUseItem;
    public KeyBinding keyBindPlayerList;
    public KeyBinding keyBindPickBlock;
    public KeyBinding field_55381_F;
    public KeyBinding keyBindings[];
    protected Minecraft mc;
    private File optionsFile;
    public int difficulty;
    public boolean hideGUI;
    public int thirdPersonView;

    /** true if debug info should be displayed instead of version */
    public boolean showDebugInfo;
    public boolean field_50119_G;

    /** The lastServer string. */
    public String lastServer;

    /** No clipping for singleplayer */
    public boolean noclip;

    /** Smooth Camera Toggle */
    public boolean smoothCamera;
    public boolean debugCamEnable;

    /** No clipping movement rate */
    public float noclipRate;

    /** Change rate for debug camera */
    public float debugCamRate;
    public float fovSetting;
    public float gammaSetting;

    /** GUI scale */
    public int guiScale;

    /** Determines amount of particles. 0 = All, 1 = Decreased, 2 = Minimal */
    public int particleSetting;

    /** Game settings language */
    public String language;

    public GameSettings(Minecraft par1Minecraft, File par2File)
    {
        musicVolume = 1.0F;
        soundVolume = 1.0F;
        mouseSensitivity = 0.5F;
        invertMouse = false;
        renderDistance = 0;
        viewBobbing = true;
        anaglyph = false;
        advancedOpengl = false;
        limitFramerate = 1;
        fancyGraphics = true;
        ambientOcclusion = true;
        clouds = true;
        skin = "Default";
        field_55382_n = 0;
        field_55383_o = true;
        field_55386_p = true;
        field_55385_q = true;
        field_55384_r = 1.0F;
        field_57427_s = true;
        keyBindForward = new KeyBinding("key.forward", 17);
        keyBindLeft = new KeyBinding("key.left", 30);
        keyBindBack = new KeyBinding("key.back", 31);
        keyBindRight = new KeyBinding("key.right", 32);
        keyBindJump = new KeyBinding("key.jump", 57);
        keyBindInventory = new KeyBinding("key.inventory", 18);
        keyBindDrop = new KeyBinding("key.drop", 16);
        keyBindChat = new KeyBinding("key.chat", 20);
        keyBindSneak = new KeyBinding("key.sneak", 42);
        keyBindAttack = new KeyBinding("key.attack", -100);
        keyBindUseItem = new KeyBinding("key.use", -99);
        keyBindPlayerList = new KeyBinding("key.playerlist", 15);
        keyBindPickBlock = new KeyBinding("key.pickItem", -98);
        field_55381_F = new KeyBinding("key.command", 53);
        keyBindings = (new KeyBinding[]
                {
                    keyBindAttack, keyBindUseItem, keyBindForward, keyBindLeft, keyBindBack, keyBindRight, keyBindJump, keyBindSneak, keyBindDrop, keyBindInventory,
                    keyBindChat, keyBindPlayerList, keyBindPickBlock, field_55381_F
                });
        difficulty = 2;
        hideGUI = false;
        thirdPersonView = 0;
        showDebugInfo = false;
        field_50119_G = false;
        lastServer = "";
        noclip = false;
        smoothCamera = false;
        debugCamEnable = false;
        noclipRate = 1.0F;
        debugCamRate = 1.0F;
        fovSetting = 0.0F;
        gammaSetting = 0.0F;
        guiScale = 0;
        particleSetting = 0;
        language = "en_US";
        mc = par1Minecraft;
        optionsFile = new File(par2File, "options.txt");
        loadOptions();
    }

    public GameSettings()
    {
        musicVolume = 1.0F;
        soundVolume = 1.0F;
        mouseSensitivity = 0.5F;
        invertMouse = false;
        renderDistance = 0;
        viewBobbing = true;
        anaglyph = false;
        advancedOpengl = false;
        limitFramerate = 1;
        fancyGraphics = true;
        ambientOcclusion = true;
        clouds = true;
        skin = "Default";
        field_55382_n = 0;
        field_55383_o = true;
        field_55386_p = true;
        field_55385_q = true;
        field_55384_r = 1.0F;
        field_57427_s = true;
        keyBindForward = new KeyBinding("key.forward", 17);
        keyBindLeft = new KeyBinding("key.left", 30);
        keyBindBack = new KeyBinding("key.back", 31);
        keyBindRight = new KeyBinding("key.right", 32);
        keyBindJump = new KeyBinding("key.jump", 57);
        keyBindInventory = new KeyBinding("key.inventory", 18);
        keyBindDrop = new KeyBinding("key.drop", 16);
        keyBindChat = new KeyBinding("key.chat", 20);
        keyBindSneak = new KeyBinding("key.sneak", 42);
        keyBindAttack = new KeyBinding("key.attack", -100);
        keyBindUseItem = new KeyBinding("key.use", -99);
        keyBindPlayerList = new KeyBinding("key.playerlist", 15);
        keyBindPickBlock = new KeyBinding("key.pickItem", -98);
        field_55381_F = new KeyBinding("key.command", 53);
        keyBindings = (new KeyBinding[]
                {
                    keyBindAttack, keyBindUseItem, keyBindForward, keyBindLeft, keyBindBack, keyBindRight, keyBindJump, keyBindSneak, keyBindDrop, keyBindInventory,
                    keyBindChat, keyBindPlayerList, keyBindPickBlock, field_55381_F
                });
        difficulty = 2;
        hideGUI = false;
        thirdPersonView = 0;
        showDebugInfo = false;
        field_50119_G = false;
        lastServer = "";
        noclip = false;
        smoothCamera = false;
        debugCamEnable = false;
        noclipRate = 1.0F;
        debugCamRate = 1.0F;
        fovSetting = 0.0F;
        gammaSetting = 0.0F;
        guiScale = 0;
        particleSetting = 0;
        language = "en_US";
    }

    public String getKeyBindingDescription(int par1)
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        return stringtranslate.translateKey(keyBindings[par1].keyDescription);
    }

    /**
     * The string that appears inside the button/slider in the options menu.
     */
    public String getOptionDisplayString(int par1)
    {
        int i = keyBindings[par1].keyCode;
        return getKeyDisplayString(i);
    }

    /**
     * Represents a key or mouse button as a string. Args: key
     */
    public static String getKeyDisplayString(int par0)
    {
        if (par0 < 0)
        {
            return StatCollector.translateToLocalFormatted("key.mouseButton", new Object[]
                    {
                        Integer.valueOf(par0 + 101)
                    });
        }
        else
        {
            return Keyboard.getKeyName(par0);
        }
    }

    /**
     * Sets a key binding.
     */
    public void setKeyBinding(int par1, int par2)
    {
        keyBindings[par1].keyCode = par2;
        saveOptions();
    }

    /**
     * If the specified option is controlled by a slider (float value), this will set the float value.
     */
    public void setOptionFloatValue(EnumOptions par1EnumOptions, float par2)
    {
        if (par1EnumOptions == EnumOptions.MUSIC)
        {
            musicVolume = par2;
            mc.sndManager.onSoundOptionsChanged();
        }

        if (par1EnumOptions == EnumOptions.SOUND)
        {
            soundVolume = par2;
            mc.sndManager.onSoundOptionsChanged();
        }

        if (par1EnumOptions == EnumOptions.SENSITIVITY)
        {
            mouseSensitivity = par2;
        }

        if (par1EnumOptions == EnumOptions.FOV)
        {
            fovSetting = par2;
        }

        if (par1EnumOptions == EnumOptions.GAMMA)
        {
            gammaSetting = par2;
        }

        if (par1EnumOptions == EnumOptions.CHAT_OPACITY)
        {
            field_55384_r = par2;
        }
    }

    /**
     * For non-float options. Toggles the option on/off, or cycles through the list i.e. render distances.
     */
    public void setOptionValue(EnumOptions par1EnumOptions, int par2)
    {
        if (par1EnumOptions == EnumOptions.INVERT_MOUSE)
        {
            invertMouse = !invertMouse;
        }

        if (par1EnumOptions == EnumOptions.RENDER_DISTANCE)
        {
            renderDistance = renderDistance + par2 & 3;
        }

        if (par1EnumOptions == EnumOptions.GUI_SCALE)
        {
            guiScale = guiScale + par2 & 3;
        }

        if (par1EnumOptions == EnumOptions.PARTICLES)
        {
            particleSetting = (particleSetting + par2) % 3;
        }

        if (par1EnumOptions == EnumOptions.VIEW_BOBBING)
        {
            viewBobbing = !viewBobbing;
        }

        if (par1EnumOptions == EnumOptions.RENDER_CLOUDS)
        {
            clouds = !clouds;
        }

        if (par1EnumOptions == EnumOptions.ADVANCED_OPENGL)
        {
            advancedOpengl = !advancedOpengl;
            mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.ANAGLYPH)
        {
            anaglyph = !anaglyph;
            mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.FRAMERATE_LIMIT)
        {
            limitFramerate = (limitFramerate + par2 + 3) % 3;
        }

        if (par1EnumOptions == EnumOptions.DIFFICULTY)
        {
            difficulty = difficulty + par2 & 3;
        }

        if (par1EnumOptions == EnumOptions.GRAPHICS)
        {
            fancyGraphics = !fancyGraphics;
            mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.AMBIENT_OCCLUSION)
        {
            ambientOcclusion = !ambientOcclusion;
            mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.CHAT_VISIBILITY)
        {
            field_55382_n = (field_55382_n + par2) % 3;
        }

        if (par1EnumOptions == EnumOptions.CHAT_COLOR)
        {
            field_55383_o = !field_55383_o;
        }

        if (par1EnumOptions == EnumOptions.CHAT_LINKS)
        {
            field_55386_p = !field_55386_p;
        }

        if (par1EnumOptions == EnumOptions.CHAT_LINKS_PROMPT)
        {
            field_55385_q = !field_55385_q;
        }

        if (par1EnumOptions == EnumOptions.USE_SERVER_TEXTURES)
        {
            field_57427_s = !field_57427_s;
        }

        saveOptions();
    }

    public float getOptionFloatValue(EnumOptions par1EnumOptions)
    {
        if (par1EnumOptions == EnumOptions.FOV)
        {
            return fovSetting;
        }

        if (par1EnumOptions == EnumOptions.GAMMA)
        {
            return gammaSetting;
        }

        if (par1EnumOptions == EnumOptions.MUSIC)
        {
            return musicVolume;
        }

        if (par1EnumOptions == EnumOptions.SOUND)
        {
            return soundVolume;
        }

        if (par1EnumOptions == EnumOptions.SENSITIVITY)
        {
            return mouseSensitivity;
        }

        if (par1EnumOptions == EnumOptions.CHAT_OPACITY)
        {
            return field_55384_r;
        }
        else
        {
            return 0.0F;
        }
    }

    public boolean getOptionOrdinalValue(EnumOptions par1EnumOptions)
    {
        switch (EnumOptionsHelper.enumOptionsMappingHelperArray[par1EnumOptions.ordinal()])
        {
            case 1:
                return invertMouse;

            case 2:
                return viewBobbing;

            case 3:
                return anaglyph;

            case 4:
                return advancedOpengl;

            case 5:
                return ambientOcclusion;

            case 6:
                return clouds;

            case 7:
                return field_55383_o;

            case 8:
                return field_55386_p;

            case 9:
                return field_55385_q;

            case 10:
                return field_57427_s;
        }

        return false;
    }

    private static String func_48571_a(String par0ArrayOfStr[], int par1)
    {
        if (par1 < 0 || par1 >= par0ArrayOfStr.length)
        {
            par1 = 0;
        }

        StringTranslate stringtranslate = StringTranslate.getInstance();
        return stringtranslate.translateKey(par0ArrayOfStr[par1]);
    }

    /**
     * Gets a key binding.
     */
    public String getKeyBinding(EnumOptions par1EnumOptions)
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        String s = (new StringBuilder()).append(stringtranslate.translateKey(par1EnumOptions.getEnumString())).append(": ").toString();

        if (par1EnumOptions.getEnumFloat())
        {
            float f = getOptionFloatValue(par1EnumOptions);

            if (par1EnumOptions == EnumOptions.SENSITIVITY)
            {
                if (f == 0.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.sensitivity.min")).toString();
                }

                if (f == 1.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.sensitivity.max")).toString();
                }
                else
                {
                    return (new StringBuilder()).append(s).append((int)(f * 200F)).append("%").toString();
                }
            }

            if (par1EnumOptions == EnumOptions.FOV)
            {
                if (f == 0.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.fov.min")).toString();
                }

                if (f == 1.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.fov.max")).toString();
                }
                else
                {
                    return (new StringBuilder()).append(s).append((int)(70F + f * 40F)).toString();
                }
            }

            if (par1EnumOptions == EnumOptions.GAMMA)
            {
                if (f == 0.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.gamma.min")).toString();
                }

                if (f == 1.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.gamma.max")).toString();
                }
                else
                {
                    return (new StringBuilder()).append(s).append("+").append((int)(f * 100F)).append("%").toString();
                }
            }

            if (par1EnumOptions == EnumOptions.CHAT_OPACITY)
            {
                return (new StringBuilder()).append(s).append((int)(f * 90F + 10F)).append("%").toString();
            }

            if (f == 0.0F)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.off")).toString();
            }
            else
            {
                return (new StringBuilder()).append(s).append((int)(f * 100F)).append("%").toString();
            }
        }

        if (par1EnumOptions.getEnumBoolean())
        {
            boolean flag = getOptionOrdinalValue(par1EnumOptions);

            if (flag)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.on")).toString();
            }
            else
            {
                return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.off")).toString();
            }
        }

        if (par1EnumOptions == EnumOptions.RENDER_DISTANCE)
        {
            return (new StringBuilder()).append(s).append(func_48571_a(RENDER_DISTANCES, renderDistance)).toString();
        }

        if (par1EnumOptions == EnumOptions.DIFFICULTY)
        {
            return (new StringBuilder()).append(s).append(func_48571_a(DIFFICULTIES, difficulty)).toString();
        }

        if (par1EnumOptions == EnumOptions.GUI_SCALE)
        {
            return (new StringBuilder()).append(s).append(func_48571_a(GUISCALES, guiScale)).toString();
        }

        if (par1EnumOptions == EnumOptions.CHAT_VISIBILITY)
        {
            return (new StringBuilder()).append(s).append(func_48571_a(field_55387_ab, field_55382_n)).toString();
        }

        if (par1EnumOptions == EnumOptions.PARTICLES)
        {
            return (new StringBuilder()).append(s).append(func_48571_a(PARTICLES, particleSetting)).toString();
        }

        if (par1EnumOptions == EnumOptions.FRAMERATE_LIMIT)
        {
            return (new StringBuilder()).append(s).append(func_48571_a(LIMIT_FRAMERATES, limitFramerate)).toString();
        }

        if (par1EnumOptions == EnumOptions.GRAPHICS)
        {
            if (fancyGraphics)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.graphics.fancy")).toString();
            }
            else
            {
                return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.graphics.fast")).toString();
            }
        }
        else
        {
            return s;
        }
    }

    /**
     * Loads the options from the options file. It appears that this has replaced the previous 'loadOptions'
     */
    public void loadOptions()
    {
        try
        {
            if (!optionsFile.exists())
            {
                return;
            }

            BufferedReader bufferedreader = new BufferedReader(new FileReader(optionsFile));

            for (String s = ""; (s = bufferedreader.readLine()) != null;)
            {
                try
                {
                    String as[] = s.split(":");

                    if (as[0].equals("music"))
                    {
                        musicVolume = parseFloat(as[1]);
                    }

                    if (as[0].equals("sound"))
                    {
                        soundVolume = parseFloat(as[1]);
                    }

                    if (as[0].equals("mouseSensitivity"))
                    {
                        mouseSensitivity = parseFloat(as[1]);
                    }

                    if (as[0].equals("fov"))
                    {
                        fovSetting = parseFloat(as[1]);
                    }

                    if (as[0].equals("gamma"))
                    {
                        gammaSetting = parseFloat(as[1]);
                    }

                    if (as[0].equals("invertYMouse"))
                    {
                        invertMouse = as[1].equals("true");
                    }

                    if (as[0].equals("viewDistance"))
                    {
                        renderDistance = Integer.parseInt(as[1]);
                    }

                    if (as[0].equals("guiScale"))
                    {
                        guiScale = Integer.parseInt(as[1]);
                    }

                    if (as[0].equals("particles"))
                    {
                        particleSetting = Integer.parseInt(as[1]);
                    }

                    if (as[0].equals("bobView"))
                    {
                        viewBobbing = as[1].equals("true");
                    }

                    if (as[0].equals("anaglyph3d"))
                    {
                        anaglyph = as[1].equals("true");
                    }

                    if (as[0].equals("advancedOpengl"))
                    {
                        advancedOpengl = as[1].equals("true");
                    }

                    if (as[0].equals("fpsLimit"))
                    {
                        limitFramerate = Integer.parseInt(as[1]);
                    }

                    if (as[0].equals("difficulty"))
                    {
                        difficulty = Integer.parseInt(as[1]);
                    }

                    if (as[0].equals("fancyGraphics"))
                    {
                        fancyGraphics = as[1].equals("true");
                    }

                    if (as[0].equals("ao"))
                    {
                        ambientOcclusion = as[1].equals("true");
                    }

                    if (as[0].equals("clouds"))
                    {
                        clouds = as[1].equals("true");
                    }

                    if (as[0].equals("skin"))
                    {
                        skin = as[1];
                    }

                    if (as[0].equals("lastServer") && as.length >= 2)
                    {
                        lastServer = as[1];
                    }

                    if (as[0].equals("lang") && as.length >= 2)
                    {
                        language = as[1];
                    }

                    if (as[0].equals("chatVisibility"))
                    {
                        field_55382_n = Integer.parseInt(as[1]);
                    }

                    if (as[0].equals("chatColors"))
                    {
                        field_55383_o = as[1].equals("true");
                    }

                    if (as[0].equals("chatLinks"))
                    {
                        field_55386_p = as[1].equals("true");
                    }

                    if (as[0].equals("chatLinksPrompt"))
                    {
                        field_55385_q = as[1].equals("true");
                    }

                    if (as[0].equals("chatOpacity"))
                    {
                        field_55384_r = parseFloat(as[1]);
                    }

                    if (as[0].equals("serverTextures"))
                    {
                        field_57427_s = as[1].equals("true");
                    }

                    KeyBinding akeybinding[] = keyBindings;
                    int i = akeybinding.length;
                    int j = 0;

                    while (j < i)
                    {
                        KeyBinding keybinding = akeybinding[j];

                        if (as[0].equals((new StringBuilder()).append("key_").append(keybinding.keyDescription).toString()))
                        {
                            keybinding.keyCode = Integer.parseInt(as[1]);
                        }

                        j++;
                    }
                }
                catch (Exception exception1)
                {
                    System.out.println((new StringBuilder()).append("Skipping bad option: ").append(s).toString());
                }
            }

            KeyBinding.resetKeyBindingArrayAndHash();
            bufferedreader.close();
        }
        catch (Exception exception)
        {
            System.out.println("Failed to load options");
            exception.printStackTrace();
        }
    }

    /**
     * Parses a string into a float.
     */
    private float parseFloat(String par1Str)
    {
        if (par1Str.equals("true"))
        {
            return 1.0F;
        }

        if (par1Str.equals("false"))
        {
            return 0.0F;
        }
        else
        {
            return Float.parseFloat(par1Str);
        }
    }

    /**
     * Saves the options to the options file.
     */
    public void saveOptions()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(optionsFile));
            printwriter.println((new StringBuilder()).append("music:").append(musicVolume).toString());
            printwriter.println((new StringBuilder()).append("sound:").append(soundVolume).toString());
            printwriter.println((new StringBuilder()).append("invertYMouse:").append(invertMouse).toString());
            printwriter.println((new StringBuilder()).append("mouseSensitivity:").append(mouseSensitivity).toString());
            printwriter.println((new StringBuilder()).append("fov:").append(fovSetting).toString());
            printwriter.println((new StringBuilder()).append("gamma:").append(gammaSetting).toString());
            printwriter.println((new StringBuilder()).append("viewDistance:").append(renderDistance).toString());
            printwriter.println((new StringBuilder()).append("guiScale:").append(guiScale).toString());
            printwriter.println((new StringBuilder()).append("particles:").append(particleSetting).toString());
            printwriter.println((new StringBuilder()).append("bobView:").append(viewBobbing).toString());
            printwriter.println((new StringBuilder()).append("anaglyph3d:").append(anaglyph).toString());
            printwriter.println((new StringBuilder()).append("advancedOpengl:").append(advancedOpengl).toString());
            printwriter.println((new StringBuilder()).append("fpsLimit:").append(limitFramerate).toString());
            printwriter.println((new StringBuilder()).append("difficulty:").append(difficulty).toString());
            printwriter.println((new StringBuilder()).append("fancyGraphics:").append(fancyGraphics).toString());
            printwriter.println((new StringBuilder()).append("ao:").append(ambientOcclusion).toString());
            printwriter.println((new StringBuilder()).append("clouds:").append(clouds).toString());
            printwriter.println((new StringBuilder()).append("skin:").append(skin).toString());
            printwriter.println((new StringBuilder()).append("lastServer:").append(lastServer).toString());
            printwriter.println((new StringBuilder()).append("lang:").append(language).toString());
            printwriter.println((new StringBuilder()).append("chatVisibility:").append(field_55382_n).toString());
            printwriter.println((new StringBuilder()).append("chatColors:").append(field_55383_o).toString());
            printwriter.println((new StringBuilder()).append("chatLinks:").append(field_55386_p).toString());
            printwriter.println((new StringBuilder()).append("chatLinksPrompt:").append(field_55385_q).toString());
            printwriter.println((new StringBuilder()).append("chatOpacity:").append(field_55384_r).toString());
            printwriter.println((new StringBuilder()).append("serverTextures:").append(field_57427_s).toString());
            KeyBinding akeybinding[] = keyBindings;
            int i = akeybinding.length;

            for (int j = 0; j < i; j++)
            {
                KeyBinding keybinding = akeybinding[j];
                printwriter.println((new StringBuilder()).append("key_").append(keybinding.keyDescription).append(":").append(keybinding.keyCode).toString());
            }

            printwriter.close();
        }
        catch (Exception exception)
        {
            System.out.println("Failed to save options");
            exception.printStackTrace();
        }

        if (mc.field_56455_h != null)
        {
            mc.field_56455_h.sendQueue.addToSendQueue(new Packet204ClientInfo(language, renderDistance, field_55382_n, field_55383_o, difficulty));
        }
    }

    /**
     * Should render clouds
     */
    public boolean shouldRenderClouds()
    {
        return renderDistance < 2 && clouds;
    }
}
