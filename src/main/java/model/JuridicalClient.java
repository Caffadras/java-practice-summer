package model;

public class JuridicalClient extends Client implements Convertible<JuridicalClient>{
    private Long fiscalCode;
    private String propertyType;
    private String administratorName;
    private String contactPerson;

    public JuridicalClient(String name, String address, String phoneNumber, Long fiscalCode,
                           String propertyType, String administratorName, String contactPerson) {
        super(name, address, phoneNumber);
        this.fiscalCode = fiscalCode;
        this.propertyType = propertyType;
        this.administratorName = administratorName;
        this.contactPerson = contactPerson;
    }

    public Long getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(Long fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public void convert(JuridicalClient newObjectFields) {
        if (newObjectFields == null){
            throw new RuntimeException("Cannot convert to null object!");
        }

        setName(newObjectFields.getName());
        setAddress(newObjectFields.getAddress());
        setPhoneNumber(newObjectFields.getPhoneNumber());
        setFiscalCode(newObjectFields.getFiscalCode());
        setPropertyType(newObjectFields.getPropertyType());
        setAdministratorName(newObjectFields.getAdministratorName());
        setContactPerson(newObjectFields.getContactPerson());
    }
}
