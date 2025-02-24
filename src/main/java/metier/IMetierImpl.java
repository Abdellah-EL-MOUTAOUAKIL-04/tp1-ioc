package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("metier")
public class IMetierImpl implements IMetier {
    //Couplage faible
    //l'annotation autowired n'est pas conseiller d'utiliser car il viole le principe de l'encapsulation en accedant directement à la variable pour l'initialiser
    //il est conseiller d'utiliser le constructeur pour initialiser la variable
    //@Autowired
    private IDao dao;

    public IMetierImpl(@Qualifier("dao") IDao dao) {
        this.dao = dao;
    }

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
