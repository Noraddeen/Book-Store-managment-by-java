package com.model.managment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.model.data.Manager;


public class ManagerList {
    IntListFile<Manager> file;
    private List<Manager> managers;
//    public ManagerList(String str) throws Exception {
//        managers = new ArrayList<Manager>();
//        managers.add(new Manager("Noraddin","Hawler shikhla C111","0750 1222 829","NoraddinHassan@gmail.com","qwert12345"));
//        managers.add(new Manager("Soleen","Hawler shikhla C112","0750 2333 839","SoleenJamel@gmail.com","qwert12345"));
//        managers.add(new Manager("Roman","Hawler bakhtiari B001","0750 1444 849","RomanKarim@gmail.com","qwert12345"));
//    file = new ListFile<Manager>("Managers");
//             file.saveAndClose(managers);
//    }
     
    public ManagerList() {                // by default is getting listFile of Manager
      file = new ListFile<Manager>("Managers");
   	  managers = file.openAndFitch();
         file.saveAndClose(managers);
    }

    public void add(Manager manager) {
   	 managers.add(manager);
    }

    public void fitchFromFile(){
    managers = file.openAndFitch();
    }
    public void save() throws IOException {
   	 file.saveAndClose(managers);
    }
    // function and impliments will be detrmine next week after know wich datastructue will use
    public List<Manager> getManagers(){
        return managers;
    }
}
