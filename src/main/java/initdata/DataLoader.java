package initdata;

import model.*;
import services.CrudService;
import services.factory.ServiceFactory;

import java.time.LocalDate;

public class DataLoader {
    public static void run(){
        CrudService<Bank> bankService = ServiceFactory.getServiceFor(Bank.class);
        CrudService<Credit> creditService =  ServiceFactory.getServiceFor(Credit.class);
        CrudService<Contract> contractService =  ServiceFactory.getServiceFor(Contract.class);
        CrudService<PhysicalClient> physicalClientService =  ServiceFactory.getServiceFor(PhysicalClient.class);
        CrudService<JuridicalClient> juridicalClientService =  ServiceFactory.getServiceFor(JuridicalClient.class);


        PhysicalClient pClientAlex = new PhysicalClient("Alex", "Address1", "+373883", 123L);
        PhysicalClient pClientBrian = new PhysicalClient("Brian", "Address2", "+373884", 124L);
        PhysicalClient pClientJeremy = new PhysicalClient("Jeremy", "Address3", "+373885", 125L);
        PhysicalClient pClientJordan = new PhysicalClient("Jordan", "Address4", "+373886", 126L);

        JuridicalClient jClientLinella = new JuridicalClient("Linella", "someAddress1", "+324", 101L,
                "Immovable","Nicoleta","Peter");
        JuridicalClient jClientCEITI = new JuridicalClient("CEITI", "someAddress2", "+322224", 201L,
                "Immovable","Olga","Ion");
        JuridicalClient jClientMML= new JuridicalClient("MML", "someAddress3", "+3231324", 301L,
                "Immovable","Emre","Deniz");

        Credit phoneCredit = new Credit("Phone Credit","Open", Currency.currencyOf("MDL"), 5.0D);
        Credit computerCredit = new Credit("Computer Credit", "Open",Currency.currencyOf("MDL"), 3.0D);
        Credit houseCredit = new Credit("House Credit", "Open",Currency.currencyOf("MDL"), 8.0D);
        Credit carCredit = new Credit("Car Credit","Closed", Currency.currencyOf("MDL"), 2.0D);
        Credit travelCredit = new Credit("Travel Credit","Closed", Currency.currencyOf("MDL"), 3.0D);

        Bank bankMAIB = new Bank("MAIB", "an address","+373", null);
        Bank bankMICB = new Bank("MICB", "another address2", "+373232", null);

        Contract contract1 = new Contract(101L, LocalDate.ofYearDay(2021, 321), pClientAlex,
                houseCredit, 200000D, LocalDate.ofYearDay(2032, 1), bankMAIB);
        Contract contract2 = new Contract(201L, LocalDate.ofYearDay(2022, 33), jClientLinella,
                carCredit, 15000D, LocalDate.ofYearDay(2022, 150), bankMICB);
        Contract contract3 = new Contract(301L, LocalDate.ofYearDay(2020, 123), jClientCEITI,
                computerCredit, 200000D, LocalDate.ofYearDay(2022, 123), bankMICB);
        Contract contract4 = new Contract(401L, LocalDate.ofYearDay(2022, 1), pClientJordan,
                phoneCredit, 9000D, LocalDate.ofYearDay(2022, 200), bankMAIB);
        Contract contract5 = new Contract(501L, LocalDate.ofYearDay(2019, 100), pClientJeremy,
                travelCredit, 10000D, LocalDate.ofYearDay(2019, 150), bankMAIB);


        bankService.save(bankMAIB);
        bankService.save(bankMICB);

        contractService.save(contract1);
        contractService.save(contract2);
        contractService.save(contract3);
        contractService.save(contract4);
        contractService.save(contract5);

        creditService.save(phoneCredit);
        creditService.save(computerCredit);
        creditService.save(houseCredit);
        creditService.save(carCredit);
        creditService.save(travelCredit);

        physicalClientService.save(pClientAlex);
        physicalClientService.save(pClientBrian);
        physicalClientService.save(pClientJeremy);
        physicalClientService.save(pClientJordan);

        juridicalClientService.save(jClientLinella);
        juridicalClientService.save(jClientCEITI);
        juridicalClientService.save(jClientMML);
    }
}
