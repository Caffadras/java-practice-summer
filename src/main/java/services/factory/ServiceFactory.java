package services.factory;

import model.*;
import services.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static final Map<Class<?>, CrudService<?>> instancesMap = new HashMap<>();
    static {
        instancesMap.put(Bank.class, new BankListService());
        instancesMap.put(Credit.class, new CreditListService());
        instancesMap.put(Contract.class, new ContractListService());
        instancesMap.put(PhysicalClient.class, new PhysicalClientListService());
        instancesMap.put(JuridicalClient.class, new JuridicalClientListService());
    }

    public static synchronized <T extends Nameable & Convertible<T>> CrudService<T> getServiceFor(Class<T> tClass){
        if (instancesMap.get(tClass) == null){
            throw new IllegalArgumentException("No service found for " + tClass.toString());
        }

        return (CrudService<T>) instancesMap.get(tClass);
    }
}
