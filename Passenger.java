package fit5171.monash.edu;

public class Passenger extends Person
{
    private String email;
    private String phoneNumber;
    private String cardNumber;
    private int securityCode;
    private String passport;

    public Passenger(){
        super();
    }

    public Passenger(String firstName, String secondName, int age, String gender) {
        super(firstName, secondName, age, gender);
    }

    public Passenger(String firstName, String secondName, int age, String gender,String email, String phoneNumber, String passport, String cardNumber,int securityCode)
    {
        super(firstName,secondName,age,gender);
        setEmail(email);
        setSecurityCode(securityCode);
        setCardNumber(cardNumber);
        setPassport(passport);
        setPhoneNumber(phoneNumber);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {

        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        email = email.trim();

        System.out.println(email);
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        else if (email.matches("^[a-zA-Z0-9._%+-]{1,64}@[a-zA-Z0-9.-]{1,189}\\.[a-zA-Z]{2,}$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email contains invalid characters");
        }
           }

    public String getFirstName() {
        return super.getFirstName();
    }

    public String getSecondName() {
        return super.getSecondName();
    }

    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    public String getPassport() {
        return passport;
    }

    public void setGender(String gender) {
        super.setGender(gender);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {

        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be empty");
        }

        cardNumber = cardNumber.replaceAll("\\s", "");

        if (cardNumber.matches("^[1-9][0-9]{15}$")) {
            this.cardNumber = cardNumber;
        } else {
            throw new IllegalArgumentException("Card number contains invalid characters");
        }

    }

    public void setSecurityCode(int securityCode) {
        if (securityCode < 100 || securityCode > 999) {
            throw new IllegalArgumentException("Security code must be a 3 digit number");
        }
        this.securityCode = securityCode;
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    public void setPassport(String passport) {
        if (passport == null) {
            throw new IllegalArgumentException("Passport cannot be null");
        }

        passport = passport.trim().toUpperCase();

        // Australia || UK || Singapore passport format
        if (passport.matches("^[A-Z][0-9]{8}$") ||
                passport.matches("^[0-9]{9}$|^[A-Z]{2}[0-9]{7}$") ||
                passport.matches("^[A-Z][0-9]{7}$")) {
            this.passport = passport;
        } else {
            throw new IllegalArgumentException("Passport is invalid");
        }
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }

        String cleanNumber = phoneNumber.replaceAll("\\s", "");

        // Australian formats (local: 04XX XXX XXX, international: +614XXXXXXXX)
        if (cleanNumber.matches("^0[4][0-9]{8}$")) {
            // Convert Australian local format to international
            this.phoneNumber = "61" + cleanNumber.substring(1);
        }
        // Already in Australian international format
        else if (cleanNumber.matches("^61[4][0-9]{8}$")) {
            this.phoneNumber = cleanNumber;
        }

        // Singapore formats (local: 8/9XXXXXXX, international: +658/9XXXXXXX)
        else if (cleanNumber.matches("^[89][0-9]{7}$")) {
            // Convert Singapore local format to international
            this.phoneNumber = "65" + cleanNumber;
        }
        // Already in Singapore international format
        else if (cleanNumber.matches("^65[89][0-9]{7}$")) {
            this.phoneNumber = cleanNumber;
        }

        // UK formats (local: 07XXXXXXXXX, international: +447XXXXXXXXX)
        else if (cleanNumber.matches("^0[7][0-9]{9}$")) {
            // Convert UK local format to international
            this.phoneNumber = "44" + cleanNumber.substring(1);
        }
        // Already in UK international format
        else if (cleanNumber.matches("^44[7][0-9]{9}$")) {
            this.phoneNumber = cleanNumber;
        }

        else {
            throw new IllegalArgumentException("Invalid phone number format. Must be a valid Australian, Singapore, or UK mobile number.");
        }
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String toString()
    {
        return "Passenger{" + " Fullname= "+ super.getFirstName()+" "+super.getSecondName()+
                " ,email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport +
                '}';
    }
}
