package metier;

import dao.IDao;

public class IMetierImpl implements IMetier {
    //Couplage faible
    private IDao dao;
    @Override
    public double calcul() {
        double t=dao.getData();
        double res=t*23;
        return res;
    }

    //pour injecter dans la variable dao un objet d'une classe qui implemente l'interface IDao
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
