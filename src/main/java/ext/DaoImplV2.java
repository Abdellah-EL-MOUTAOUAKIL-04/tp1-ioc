package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao2")
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Web service");
        double t=11;
        return t;
    }
}
