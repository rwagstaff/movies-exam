package ms.billing;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Confirmation {

    private String invoiceId;
    private String status;

    public Confirmation(String invoiceId, String status) {
        super();
        this.invoiceId = invoiceId;
        this.status = status;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Confirmation))
            return false;
        Confirmation castOther = (Confirmation) other;
        return new EqualsBuilder().append(invoiceId, castOther.invoiceId).append(status, castOther.status).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(invoiceId).append(status).toHashCode();
    }

    @Override
    public String toString() {
        return "Confirmation [invoiceId=" + invoiceId + ", status=" + status + "]";
    }

}
