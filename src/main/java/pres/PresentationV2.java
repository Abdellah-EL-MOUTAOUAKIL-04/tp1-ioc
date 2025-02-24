package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args)  {
        try{
            Scanner scanner=new Scanner(new File("config.txt"));

            //DaoImpl d=new DaoImpl();
            String daoClassName=scanner.nextLine();
            Class cDao=Class.forName(daoClassName);
            IDao dao=(IDao)cDao.getConstructor().newInstance();

            //MetierImpl metier=new MetierImpl(d);
            String metierClassName=scanner.nextLine();
            Class cMetier=Class.forName(metierClassName);
            //instanciation via le constructeur
            //IMetier metier=(IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
            //instanciation via le setter
            IMetier metier=(IMetier) cMetier.getConstructor().newInstance();

            //metier.setDao(d);
            Method setDao=cMetier.getDeclaredMethod("setDao",IDao.class);
            //invoke permet d'executer la fonction setDao sur l'objet metier avec le parametre dao
            setDao.invoke(metier,dao);

            System.out.println(metier.calcul());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
