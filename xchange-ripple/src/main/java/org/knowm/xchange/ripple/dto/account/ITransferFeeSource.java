package org.knowm.xchange.ripple.dto.account;

import java.io.IOException;
import org.knowm.xchange.ripple.dto.RippleException;

public interface ITransferFeeSource {
  Double getTransferFeeRate(String address) throws RippleException, IOException;
}
