package ms.billing;

import java.util.Date;

public class Card {

    private String sortCode;
    private String cardNumber;
    private Date expiryDate;

    public Card(String sortCode, String cardNumber, Date expiryDate) {
        super();
        this.sortCode = sortCode;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    public String getSortCode() {
        return sortCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

}
