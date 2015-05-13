package ms.billing;

import ms.Buyable;
import ms.user.Subscribed;

public interface BillingProvider {

    Confirmation purchase(Buyable buyable, Subscribed subscribed, Payer payer) throws BillingException;

}
