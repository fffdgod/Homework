import java.util.Map;
import java.io.Console;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import org.w3c.dom.events.MouseEvent;

public class Vehicle {
    public String name;
    public float hp;
    public float[] armor; // 1抗穿，2抗破
    public Map<ModuleType, Module> modules;
    public Map<ModuleType,Int> moduleEnhancement;
    public Map<AmmoType, Ammo> ammos;
    
    public Vehicle(){
        modules = new HashMap<>();  // 初始化Map
        moduleEnhancement = new HashMap<>();  // 初始化Map
        modules.put(ModuleType.APS, null);
        modules.put(ModuleType.ExtraArmor, null);
        modules.put(ModuleType.Reloader, null);
        modules.put(ModuleType.Scout, null);
        modules.put(ModuleType.SideTurret, null);
        modules.put(ModuleType.Turret, null);
        moduleEnhancement.put(ModuleType.APS, 0);
        moduleEnhancement.put(ModuleType.ExtraArmor, 0);
        moduleEnhancement.put(ModuleType.Reloader, 0);
        moduleEnhancement.put(ModuleType.Scout, 0);
        moduleEnhancement.put(ModuleType.SideTurret, 0);
        moduleEnhancement.put(ModuleType.Turret, 0);
    }
    public static Vehicle GenerateVehicle(boolean isRandom,int level) {
        //If level==0 playerVehicle
        float antiScout;
        float hp;
        float pkArmor; 
        float ekArmor;
        float multiplier;
        String name;
        
        switch (level) {
            case 0:
                
                hp = DefaultPlayerVehicle.hp;
                
                break;
            
        }
        
        switch (rarity) {
            case Normal:
                multiplier = 1f;
                break;
            case Rare:
                multiplier = 1.2f;
                break;
            case SuperRare:
                multiplier = 1.4f;
                break;
            case Epic:
                multiplier = 1.6f;
                break;
            case Legendary:
                multiplier = 1.8f;
                break;
            default:
                multiplier = 1f;
                break;
        }
        
        if (isRandom) {
            Random rand = new Random();
            multiplier = multiplier - 0.1f + rand.nextFloat() * 0.2f;
        }
        
        value *= multiplier;
        antiScout *= multiplier;
        hp *= multiplier;
        
        Module module = new Module(name, hp, type, value, antiScout, rarity);
        return module;
    }
}
class Module {
    public String name;
    private Rarity rarity;
    private ModuleType type;
    private float hp;
    private float value;
    private float antiScout;
    private String color;
    private String pre;
    
    // Getter and Setter methods
    public Rarity getRarity(){
        return rarity;
    }
    public void setRarity(Rarity rarity){
        this.rarity = rarity;
    }
    
    public ModuleType getType() {
        return type;
    }
    public void setType(ModuleType type) {
        this.type = type;
    }
    
    public float getHp() {
        return hp;
    }
    public void setHp(float hp) {
        this.hp = hp;
    }
    
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
    
    public float getAntiScout() {
        return antiScout;
    }
    public void setAntiScout(float antiScout) {
        this.antiScout = antiScout;
    }
    
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getPre() {
        return pre;
    }
    public void setPre(String pre) {
        this.pre = pre;
    }
    
    public void DisplayInfo(boolean nameOnly) {
        
        String ability = "";
        switch (getType()) {  
            case Turret:
                ability = "Caliber";
                break;
            case Scout:
                ability = "Scout Ability";
                break;
            case SideTurret:
                ability = "Side Turrent Reload Time";
                break;
            case ExtraArmor:
                ability = "ExtraArmor width";
                break;
            case APS:
                ability = "APS Count";
                break;
            case Reloader:
                ability = "Reload Time";
                break;
            default:
                name = "None";
                break;
        }
        System.out.format("\u001B[" + getColor() + getPre() +" "+name + "\u001B[0m");  
        if (!nameOnly) {
            System.out.println(" - Hp: " + getHp() + ", "+ability + getValue() + ", AntiScout: " + getAntiScout());  
        }
    }
    public Module(String name,float hp,ModuleType type,float value,float antiScout,Rarity rarity) {
        this.name =name;
        this.hp = hp;
        this.type = type;
        this.value = value;
        this.antiScout=antiScout;
        switch (rarity) {
            case Normal:
                color = "0m"; 
                pre = "Normal";
                break;
            case Rare:
                color = "32m";
                pre = "Rare";
                break;
            case SuperRare:
                color = "34m";
                pre = "SuperRare";
                break;
            case Epic:
                color = "35m";
                pre = "Epic";
                break;
            case Legendary:
                color = "33m";
                pre = "Legendary";
                break;
            default:
                color = "0m"; // 默认颜色
                break;
        }
    }
    public static Module GenerateModule(Rarity rarity, ModuleType type, boolean isRandom,int caliber) {
        float hp;
        float value; 
        float antiScout;
        float multiplier;
        String name;
        
        switch (type) {
            case Turret:
                name = "Turret";
                value = caliber;
                hp = DefaultTurrent.hp;
                antiScout = DefaultTurrent.antiScout;
                break;
            case Scout:
                name = "Scout";
                value =DefaultScout.value;
                hp = DefaultScout.hp;
                antiScout = DefaultScout.antiScout;
                break;
            case SideTurret:
                name = "SideTurret";
                value =DefaultSideTurrent.value;
                hp = DefaultSideTurrent.hp;
                antiScout = DefaultSideTurrent.antiScout;
                break;
            case ExtraArmor:
                name = "ExtraArmor";
                value =DefaultExtraArmor.value;
                hp = DefaultExtraArmor.hp;
                antiScout = DefaultExtraArmor.antiScout;
                break;
            case APS:
                name = "APS";
                value =DefaultAPS.value;
                hp = DefaultAPS.hp;
                antiScout = DefaultAPS.antiScout;
                break;
            case Reloader:
                name = "Reloader";
                value =DefaultReloader.value;
                hp = DefaultReloader.hp;
                
                antiScout = DefaultReloader.antiScout;
                break;
            default:
                name = "None";
                value =DefaultScout.value;
                hp = DefaultScout.hp;
                antiScout = DefaultScout.antiScout;
                break;
        }
        
        switch (rarity) {
            case Normal:
                multiplier = 1f;
                break;
            case Rare:
                multiplier = 1.2f;
                break;
            case SuperRare:
                multiplier = 1.4f;
                break;
            case Epic:
                multiplier = 1.6f;
                break;
            case Legendary:
                multiplier = 1.8f;
                break;
            default:
                multiplier = 1f;
                break;
        }
        
        if (isRandom) {
            Random rand = new Random();
            multiplier = multiplier - 0.1f + rand.nextFloat() * 0.2f;
        }
        
        value *= multiplier;
        antiScout *= multiplier;
        hp *= multiplier;
        
        Module module = new Module(name, hp, type, value, antiScout, rarity);
        return module;
    }
    
}

    
public class Ammo {
    public String name;
    public int caliber;
    public float pd; // 穿甲深度
    public float ed; // 破甲深度
    public float damage;
    public int count;
    public Rarity rarity;
    public boolean ignoreAPS;
    public AmmoType type;
    public String color = "";
    public String pre;
    public static int[] caliberList = {30, 57, 105, 120}; // 对导弹以外有效
    
    public Ammo(String name, int caliber, float pd, float ed, float damage, Rarity rarity, AmmoType type) {
        this.caliber = caliber;
        this.name = name;
        this.pd = pd;
        this.ed = ed;
        this.damage = damage;
        this.rarity = rarity;
        this.type = type;
        this.count = 0;
        
        switch (rarity) {
            case Normal:
                color = "0m";
                pre = "Normal";
                break;
            case Rare:
                color = "32m";
                pre = "Rare";
                break;
            case SuperRare:
                color = "34m";
                pre = "SuperRare";
                break;
            case Epic:
                color = "35m";
                pre = "Epic";
                break;
            case Legendary:
                color = "33m";
                pre = "Legendary";
                break;
            default:
                color = "0m"; // 默认颜色
                break;
        }
    }
    
    
    public void DisplayInfo(boolean nameOnly) {
        System.out.format("\u001B[" + color + " " + pre +" "+name + "\u001B[0m");
        if (!nameOnly) {
            System.out.println(" - Caliber: " + caliber + ", PD: " + pd + ", ED: " + ed + ", Damage: " + damage);
        }
    }
    
    public static Ammo GenerateAmmo(Rarity rarity, AmmoType type, int caliber, boolean isRandom) {
        float pd; // 穿甲深度
        float ed; // 破甲深度
        float damage;
        float multiplier;
        String name;
        
        switch (type) {
            case AP:
                name = "AP";
                pd = DefaultAP.pd;
                ed = DefaultAP.ed;
                damage = DefaultAP.damage;
                break;
            case HEAT:
                name = "HEAT";
                pd = DefaultHEAT.pd;
                ed = DefaultHEAT.ed;
                damage = DefaultHEAT.damage;
                break;
            case APFSDS:
                name = "APFSDS";
                pd = DefaultAPFSDS.pd;
                ed = DefaultAPFSDS.ed;
                damage = DefaultAPFSDS.damage;
                break;
            case Missile:
                name = "Missile";
                pd = DefaultMissile.pd;
                ed = DefaultMissile.ed;
                damage = DefaultMissile.damage;
                break;
            default:
                name = "None";
                pd = 0;
                ed = 0;
                damage = 0;
                break;
        }
        
        switch (rarity) {
            case Normal:
                multiplier = 1f;
                break;
            case Rare:
                multiplier = 1.2f;
                break;
            case SuperRare:
                multiplier = 1.4f;
                break;
            case Epic:
                multiplier = 1.6f;
                break;
            case Legendary:
                multiplier = 1.8f;
                break;
            default:
                multiplier = 1f;
                break;
        }
        
        if (isRandom) {
            Random rand = new Random();
            // 修正：使用正确的随机数生成方法
            multiplier = multiplier - 0.1f + rand.nextFloat() * 0.2f;
        }
        
        pd *= multiplier;
        ed *= multiplier;
        damage *= multiplier;
        
        Ammo ammo = new Ammo(name, caliber, pd, ed, damage, rarity, type);
        return ammo;
    }
    
    public void AddAmmo(int count) {
        this.count += count;
    }
}
