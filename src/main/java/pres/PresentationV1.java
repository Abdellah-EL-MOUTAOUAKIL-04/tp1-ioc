package pres;

import dao.DaoImpl;
import dao.IDao;
import ext.DaoImplV2;
import metier.IMetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        /*
        * Injection des dependances par instanciation statique
        */
        DaoImplV2 d=new DaoImplV2();
        IMetierImpl metier=new IMetierImpl(d);//Injection via le constructeur
        //metier.setDao(d);//Injection via le setter
        System.out.println("Res= "+metier.calcul());
    }
}
