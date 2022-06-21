package model;

public class PhysicalClient extends Client implements Convertible<PhysicalClient>{
    private Long personalCode;

    public PhysicalClient(String name, String address, String phoneNumber, Long personalCode) {
        super(name, address, phoneNumber);
        this.personalCode = personalCode;
    }

    public Long getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(Long personalCode) {
        this.personalCode = personalCode;
    }

    @Override
    public void convert(PhysicalClient newObjectFields) {
        if (newObjectFields == null){
            throw  new RuntimeException("Cannot convert to null object!");
        }
        setName(newObjectFields.getName());
        setAddress(newObjectFields.getAddress());
        setPhoneNumber(newObjectFields.getPhoneNumber());
        setPersonalCode(newObjectFields.getPersonalCode());
    }
}
