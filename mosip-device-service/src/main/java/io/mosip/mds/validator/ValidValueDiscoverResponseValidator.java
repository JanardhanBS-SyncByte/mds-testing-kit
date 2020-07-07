package io.mosip.mds.validator;

import java.util.ArrayList;
import java.util.List;

import io.mosip.mds.dto.DiscoverResponse;
import io.mosip.mds.dto.ValidateResponseRequestDto;
import io.mosip.mds.entitiy.Validator;

public class ValidValueDiscoverResponseValidator extends Validator {

	public ValidValueDiscoverResponseValidator() {
		super("ValidValueDiscoverResponseValidator", "Valid Value Discover Response Validator");
	}
	@Override
	protected List<String> DoValidate(ValidateResponseRequestDto response) {
		List<String> errors = new ArrayList<>();
		DiscoverResponse discoverResponse = response.discoverResponse;

		//Check for device status
		if(!discoverResponse.deviceStatus.equals(CommonConstant.READY) && !discoverResponse.deviceStatus.equals(CommonConstant.BUSY)
				&& !discoverResponse.deviceStatus.equals(CommonConstant.NOT_READY) && !discoverResponse.deviceStatus.equals(CommonConstant.NOT_REGISTERED))
		{
			errors.add("Device discover response device status is invalid");
			return errors;
		}
		//Check for device certification
		if(!discoverResponse.certification.equals(CommonConstant.L0)  && !discoverResponse.certification.equals(CommonConstant.L1) && !discoverResponse.certification.equals(CommonConstant.L2))
		{
			errors.add("Device discover response certification is invalid");
			return errors;
		}
		//Check for device sub id
		for(Integer subid:discoverResponse.deviceSubId)
		{
			if(subid != null)
				if(subid < 0 && subid >3)
				{
					errors.add("Device discover response deviceSubId - "+ subid +" is invalid");
					return errors;
				}
		}

		//Check for purpose
		if(!discoverResponse.purpose.equals(CommonConstant.AUTH) && !discoverResponse.purpose.equals(CommonConstant.REGISTRATION))
		{
			errors.add("Device discover response purpose is invalid");
			return errors;
		}

		//TODO Check for digital id
		//digitalId - Digital ID as per the Digital ID definition but it will not be signed.
		errors=validateDigitalId(discoverResponse,errors);

		//TODO check array of spec versions
		//TODO validate errors
		return errors;
	}

	private List<String> validateDigitalId(DiscoverResponse discoverResponse, List<String> errors) {
		//digitalId - Digital ID as per the Digital ID definition but it will not be signed.

		CommonValidator commonValidator=new CommonValidator();
		errors = commonValidator.validateUnSignedDigitalID(discoverResponse.digitalId);
		return errors;
	}
}
