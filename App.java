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
public class App {
    public static void main(String[] args) throws Exception {
        //Ammo ammoT = Ammo.GenerateAmmo(Rarity.Legendary, AmmoType.AP, 120, true);
       // ammoT.DisplayInfo(false);
        
        //int i= 0;
       // Module moduleT = Module.GenerateModule(Rarity.Epic, ModuleType.Turret, true,30);
        
        //moduleT.DisplayInfo(false);
        Core core = new Core();
        core.HomeworkMenu();
        //core.Initialize();
    }
}

class Core {
    Vehicle playerVehicle;
    List<Module> modules;
    public void Initialize() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Name your vehicle:");
        String name = scanner.nextLine();
        System.out.println("Choose your caliber(30/57,105,120):");
        int caliber = scanner.nextInt() ;
        Module turrent = Module.GenerateModule(Rarity.Normal, ModuleType.Turret, false,caliber);
        
        scanner.close();
    }
    public void HomeworkMenu(){
        ModuleType[] types = {ModuleType.Reloader,ModuleType.Scout,ModuleType.APS,ModuleType.Turret,ModuleType.ExtraArmor,ModuleType.SideTurret};
        Rarity[] rarities = {Rarity.Normal,Rarity.Rare,Rarity.SuperRare,Rarity.Epic,Rarity.Legendary};
        Random rand = new Random();
        for(int i = 0;i<10;i++){
            int res1 = rand.nextInt(5)+1;
            int res2 = rand.nextInt(4)+1;
            Module module = Module.GenerateModule(rarities[res2-1], types[res1-1], true, 120);
            modules.add(module);
        }
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
             
        System.out.println("0) Module management \n2) Exit");
        int res = scanner.nextInt() ;
        switch (res) {
            case 0:
                ModuleManage();
                    
                
                break;
            case 2:
                scanner.close();
                
                return;
            default:
                break;
        }
        }
       
    }
    public Core(){
        modules = new ArrayList<>();
    }
    public void ModuleManage(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if(modules.size()==0){
                System.out.println("No Module here.");
            }
            for(int i =0;i<modules.size();i++){
                System.out.print(i);
                modules.get(i).DisplayInfo(false);
            }
            ModuleType[] types = {ModuleType.Reloader,ModuleType.Scout,ModuleType.APS,ModuleType.Turret,ModuleType.ExtraArmor,ModuleType.SideTurret};
            System.out.println("1) Get a module \n2) Remove a module \n3X) List the modules according to module type X=1/2/3/4//5/6 for Reloader/Scout/APS/Turret/ExtraArmor/SideTurret\n4) to exit");
            int res = scanner.nextInt() ;
            if(res==1){
                ProcessAddModule();
            }
            if(res==2){
                DeleteModule();
            }
            if((int)res/10==3){
                FilterList(types[res%10-1]);
            }
            if(res==4){
                return;
            }
        }
        
    }
    // App.java - 修改了FilterList方法中使用type的地方
public void FilterList(ModuleType type){
    
    for(int i =0;i<modules.size();i++){
            if(type!=modules.get(i).getType()) continue;  // 改为使用getter
            System.out.print(i);
            modules.get(i).DisplayInfo(false);
        }
        System.out.println("----------------Filter Complete-------------------");
}
    public void ProcessAddModule(){
        ModuleType[] types = {ModuleType.Reloader,ModuleType.Scout,ModuleType.APS,ModuleType.Turret,ModuleType.ExtraArmor,ModuleType.SideTurret};
        Rarity[] rarities = {Rarity.Normal,Rarity.Rare,Rarity.SuperRare,Rarity.Epic,Rarity.Legendary};
        Scanner scanner = new Scanner(System.in);
        System.out.println("0/1/2/3/4//5/6 for Random/Reloader/Scout/APS/Turret/ExtraArmor/SideTurret:");
        int res1 = scanner.nextInt() ;
        Random rand = new Random();
        if(res1==0) res1 = rand.nextInt(5)+1;
        System.out.println("0/1/2/3/4//5/ for Random/Normal/Rare/SuperRare/Epic/Legendary:");
        int res2 = scanner.nextInt() ;
        if(res2==0) res2 = rand.nextInt(4)+1;
        Module module = Module.GenerateModule(rarities[res2-1], types[res1-1], true, 120);
        
        if(module==null) {
            System.out.println("Failed");
            return;
        }
        System.out.println("Succeed");
        module.DisplayInfo(false);
        modules.add(module);

    }
    public void DeleteModule(){
        if(modules.size()==0) return;
        System.out.println("Enter the index of the module you want to delete,-1 for random delete");
        Scanner scanner = new Scanner(System.in);
        int res1 = scanner.nextInt() ;
        Random rand = new Random();
        if(res1==-1) res1 = rand.nextInt(modules.size())-1;
        modules.remove(res1);
        
    }
}
class Controller{
    Vehicle vehicle;
    public boolean isPlayer;
    void Decide(Controller enemy){
        if(enemy==null) return;
        if(isPlayer){
            System.out.println("Choose your decision:");
            String res = scanner.nextLine() ;
        }
    }
}
